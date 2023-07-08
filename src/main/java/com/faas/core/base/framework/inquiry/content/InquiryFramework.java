package com.faas.core.base.framework.inquiry.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.inquiry.ClientInquiryDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryCampaignWSDTO;
import com.faas.core.base.model.ws.inquiry.content.dto.ClientInquiryWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.inquiry.ClientInquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.ClientInquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class InquiryFramework {


    @Autowired
    ClientInquiryMapper clientInquiryMapper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ClientInquiryRepository clientInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public List<ClientInquiryWSDTO> getAllClientInquiriesService(long userId, int reqPage, int reqSize) {

        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();
        Page<ClientInquiryDBModel> inquiryModelPage = clientInquiryRepository.findAll(PageRequest.of(reqPage,reqSize));
        for (int i=0;i<inquiryModelPage.getContent().size();i++){
            clientInquiryWSDTOS.add(new ClientInquiryWSDTO(inquiryModelPage.getContent().get(i)));
        }
        return clientInquiryWSDTOS;
    }


    public List<ClientInquiryWSDTO> getClientInquiriesByStateService(long userId, String inquiryState, int reqPage, int reqSize) {

        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();
        Page<ClientInquiryDBModel> inquiryModelPage = clientInquiryRepository.findAllByInquiryState(inquiryState,PageRequest.of(reqPage,reqSize));
        for (int i=0;i<inquiryModelPage.getContent().size();i++){
            clientInquiryWSDTOS.add(new ClientInquiryWSDTO(inquiryModelPage.getContent().get(i)));
        }
        return clientInquiryWSDTOS;
    }


    public List<InquiryCampaignWSDTO> getInquiryCampaignsService(long userId,int reqPage,int reqSize) {

        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.INQUIRY_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {

            InquiryCampaignWSDTO inquiryCampaignWSDTO = new InquiryCampaignWSDTO();
            inquiryCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel));
            Page<ClientInquiryDBModel> clientInquiryModelPage = clientInquiryRepository.findAllByCampaignId(campaignDBModel.getId(), PageRequest.of(reqPage, reqSize));
            inquiryCampaignWSDTO.setClientInquiries(clientInquiryMapper.createInquiryWSDTOS(clientInquiryModelPage.getContent()));
            inquiryCampaignWSDTO.setPagination(clientInquiryMapper.createClientInquiryPagination(clientInquiryModelPage));

            inquiryCampaignWSDTOS.add(inquiryCampaignWSDTO);
        }
        return inquiryCampaignWSDTOS;
    }


    public InquiryCampaignWSDTO getInquiryCampaignService(long userId,String campaignId,int reqPage,int reqSize) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){

            InquiryCampaignWSDTO inquiryCampaignWSDTO = new InquiryCampaignWSDTO();
            inquiryCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel.get()));
            Page<ClientInquiryDBModel> clientInquiryModelPage = clientInquiryRepository.findAllByCampaignId(campaignDBModel.get().getId(), PageRequest.of(reqPage, reqSize));
            inquiryCampaignWSDTO.setClientInquiries(clientInquiryMapper.createInquiryWSDTOS(clientInquiryModelPage.getContent()));
            inquiryCampaignWSDTO.setPagination(clientInquiryMapper.createClientInquiryPagination(clientInquiryModelPage));

            return inquiryCampaignWSDTO;
        }
        return null;
    }


    public ClientInquiryWSDTO getClientInquiryService(long userId, long inquiryId, long clientId) {

        List<ClientInquiryDBModel> clientInquiryDBModels = clientInquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (clientInquiryDBModels.size()>0){
            return new ClientInquiryWSDTO(clientInquiryDBModels.get(0));
        }
        return null;
    }


    public ClientInquiryWSDTO createClientInquiryService(long userId, String campaignId, long clientId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (campaignDBModel.isPresent() && clientDBModel.isPresent()){
            ClientInquiryDBModel clientInquiryDBModel = clientInquiryMapper.mapInquiryDBModel(campaignDBModel.get(),clientDBModel.get());
            if (clientInquiryDBModel != null){
                return new ClientInquiryWSDTO(clientInquiryRepository.save(clientInquiryDBModel));
            }
        }
        return null;
    }


    public ClientInquiryWSDTO updateClientInquiryService(long userId, long inquiryId, long clientId) {

        List<ClientInquiryDBModel> clientInquiryDBModels = clientInquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (clientInquiryDBModels.size()>0){
            return new ClientInquiryWSDTO(clientInquiryDBModels.get(0));
        }
        return null;
    }


    public ClientInquiryWSDTO removeClientInquiryService(long userId, long inquiryId, long clientId) {

        List<ClientInquiryDBModel> clientInquiryDBModels = clientInquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (clientInquiryDBModels.size()>0){
            clientInquiryRepository.delete(clientInquiryDBModels.get(0));
            return new ClientInquiryWSDTO(clientInquiryDBModels.get(0));
        }
        return null;
    }

}
