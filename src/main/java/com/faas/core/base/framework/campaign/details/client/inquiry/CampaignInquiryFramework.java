package com.faas.core.base.framework.campaign.details.client.inquiry;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquiryWSDTO;
import com.faas.core.base.model.ws.inquiry.dto.InquiryWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.mapper.InquiryMapper;
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
    InquiryMapper inquiryMapper;

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    OperationMapper operationMapper;

    @Autowired
    InquiryRepository inquiryRepository;

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

        Page<InquiryDBModel> inquiryDBModelPage = inquiryRepository.findAllByCampaignIdAndClientCityAndClientCountry(campaignId,city,country, PageRequest.of(reqPage,reqSize));
        if (inquiryDBModelPage != null){

            CampaignInquiryWSDTO campaignInquiryWSDTO = new CampaignInquiryWSDTO();
            campaignInquiryWSDTO.setPagination(inquiryMapper.createInquiryPagination(inquiryDBModelPage));
            campaignInquiryWSDTO.setInquiries(inquiryMapper.createInquiryWSDTOS(inquiryDBModelPage.getContent()));
            return campaignInquiryWSDTO;
        }
        return null;
    }


    public CampaignInquiryWSDTO getCampaignInquiriesService(long userId,String campaignId,int reqPage,int reqSize) {

        Page<InquiryDBModel> inquiryDBModelPage = inquiryRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage,reqSize));
        if (inquiryDBModelPage != null){

            CampaignInquiryWSDTO campaignInquiryWSDTO = new CampaignInquiryWSDTO();
            campaignInquiryWSDTO.setPagination(inquiryMapper.createInquiryPagination(inquiryDBModelPage));
            campaignInquiryWSDTO.setInquiries(inquiryMapper.createInquiryWSDTOS(inquiryDBModelPage.getContent()));

            return campaignInquiryWSDTO;
        }
        return null;
    }


    public InquiryWSDTO getCampaignInquiryService(long userId, long inquiryId, long clientId) {

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (inquiryDBModels.size()>0){
            return new InquiryWSDTO(inquiryDBModels.get(0));
        }
        return null;
    }


    public InquiryWSDTO createCampaignInquiryService(long userId, String campaignId, long clientId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);

        if (campaignDBModel.isPresent() && clientDBModel.isPresent()){

            clientDBModel.get().setClientState(AppConstant.BUSY_CLIENT);
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel.get());

            InquiryDBModel inquiryDBModel = inquiryMapper.mapInquiryDBModel(campaignDBModel.get(),clientDBModel.get());
            if(inquiryDBModel != null){
                return new InquiryWSDTO(inquiryRepository.save(inquiryDBModel));
            }
        }
        return null;
    }


    public InquiryWSDTO updateCampaignInquiryService(long userId, long inquiryId, long clientId, String inquiryState) {

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (inquiryDBModels.size()>0){
            inquiryDBModels.get(0).setInquiryState(inquiryState);
            inquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new InquiryWSDTO(inquiryRepository.save(inquiryDBModels.get(0)));
        }
        return null;
    }


    public InquiryWSDTO removeCampaignInquiryService(long userId, long inquiryId, long clientId) {

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (inquiryDBModels.size() > 0) {
            inquiryRepository.delete(inquiryDBModels.get(0));
            Optional<SessionDBModel>sessionDBModel = sessionRepository.findById(inquiryDBModels.get(0).getSessionId());
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
            return new InquiryWSDTO(inquiryDBModels.get(0));
        }
        return null;
    }


}
