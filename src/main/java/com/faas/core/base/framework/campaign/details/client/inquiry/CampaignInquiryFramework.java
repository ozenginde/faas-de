package com.faas.core.base.framework.campaign.details.client.inquiry;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.inquiry.ClientInquiryDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquiryWSDTO;
import com.faas.core.base.model.ws.inquiry.dto.ClientInquiryWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.inquiry.ClientInquiryRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.mapper.ClientInquiryMapper;
import com.faas.core.utils.mapper.OperationMapper;
import com.faas.core.utils.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CampaignInquiryFramework {


    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    ClientInquiryMapper clientInquiryMapper;

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    OperationMapper operationMapper;

    @Autowired
    ClientInquiryRepository clientInquiryRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignInquiryWSDTO searchCampaignInquiriesService(long userId, String campaignId,String city,String country,int reqPage,int reqSize) {

        Page<ClientInquiryDBModel> inquiryDBModelPage = clientInquiryRepository.findAllByCampaignIdAndClientCityAndClientCountry(campaignId,city,country, PageRequest.of(reqPage,reqSize));
        if (inquiryDBModelPage != null){
            CampaignInquiryWSDTO campaignInquiryWSDTO = new CampaignInquiryWSDTO();
            campaignInquiryWSDTO.setClientInquiries(clientInquiryMapper.createInquiryWSDTOS(inquiryDBModelPage.getContent()));
            campaignInquiryWSDTO.setPagination(clientInquiryMapper.createClientInquiryPagination(inquiryDBModelPage));
            return campaignInquiryWSDTO;
        }
        return null;
    }


    public CampaignInquiryWSDTO getCampaignInquiriesService(long userId,String campaignId,int reqPage,int reqSize) {

        Page<ClientInquiryDBModel> inquiryDBModelPage = clientInquiryRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage,reqSize));
        if (inquiryDBModelPage != null){
            CampaignInquiryWSDTO campaignInquiryWSDTO = new CampaignInquiryWSDTO();
            campaignInquiryWSDTO.setClientInquiries(clientInquiryMapper.createInquiryWSDTOS(inquiryDBModelPage.getContent()));
            campaignInquiryWSDTO.setPagination(clientInquiryMapper.createClientInquiryPagination(inquiryDBModelPage));
            return campaignInquiryWSDTO;
        }
        return null;
    }


    public ClientInquiryWSDTO getCampaignInquiryService(long userId, long inquiryId, long clientId) {

        List<ClientInquiryDBModel> clientInquiryDBModels = clientInquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (clientInquiryDBModels.size()>0){
            return new ClientInquiryWSDTO(clientInquiryDBModels.get(0));
        }
        return null;
    }


    public ClientInquiryWSDTO createCampaignInquiryService(long userId, String campaignId, long clientId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (campaignDBModel.isPresent() && clientDBModel.isPresent()){

            clientDBModel.get().setClientState(AppConstant.BUSY_CLIENT);
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel.get());

            return new ClientInquiryWSDTO(clientInquiryRepository.save(clientInquiryMapper.mapInquiryDBModel(campaignDBModel.get(),clientDBModel.get())));
        }
        return null;
    }


    public ClientInquiryWSDTO updateCampaignInquiryService(long userId, long inquiryId, long clientId, String inquiryState) {

        List<ClientInquiryDBModel> clientInquiryDBModels = clientInquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (clientInquiryDBModels.size()>0){
            clientInquiryDBModels.get(0).setInquiryState(inquiryState);
            clientInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ClientInquiryWSDTO(clientInquiryRepository.save(clientInquiryDBModels.get(0)));
        }
        return null;
    }


    public ClientInquiryWSDTO removeCampaignInquiryService(long userId, long inquiryId, long clientId) {

        List<ClientInquiryDBModel> clientInquiryDBModels = clientInquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (clientInquiryDBModels.size() > 0) {
            clientInquiryRepository.delete(clientInquiryDBModels.get(0));
            Optional<SessionDBModel>sessionDBModel = sessionRepository.findById(clientInquiryDBModels.get(0).getSessionId());
            if(sessionDBModel.isPresent()){
                sessionRepository.delete(sessionDBModel.get());
                operationRepository.deleteAll(operationRepository.findBySessionIdAndClientId(sessionDBModel.get().getId(),clientId));
            }
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
            if (clientDBModel.isPresent()){
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            return new ClientInquiryWSDTO(clientInquiryDBModels.get(0));
        }
        return null;
    }


}
