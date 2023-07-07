package com.faas.core.base.framework.inquiry.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryCampaignWSDTO;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.InquiryMapper;
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
    InquiryMapper inquiryMapper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;


    public List<InquiryWSDTO> getAllInquiriesService(long userId, int reqPage, int reqSize) {

        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();
        Page<InquiryDBModel> inquiryModelPage = inquiryRepository.findAll(PageRequest.of(reqPage,reqSize));
        for (int i=0;i<inquiryModelPage.getContent().size();i++){
            inquiryWSDTOS.add(new InquiryWSDTO(inquiryModelPage.getContent().get(i)));
        }
        return inquiryWSDTOS;
    }


    public List<InquiryWSDTO> getInquiriesByStateService(long userId,String inquiryState, int reqPage, int reqSize) {

        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();
        Page<InquiryDBModel> inquiryModelPage = inquiryRepository.findAllByInquiryState(inquiryState,PageRequest.of(reqPage,reqSize));
        for (int i=0;i<inquiryModelPage.getContent().size();i++){
            inquiryWSDTOS.add(new InquiryWSDTO(inquiryModelPage.getContent().get(i)));
        }
        return inquiryWSDTOS;
    }


    public List<InquiryCampaignWSDTO> getInquiryCampaignsService(long userId,int reqPage,int reqSize) {

        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.INQUIRY_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            InquiryCampaignWSDTO inquiryCampaignWSDTO = new InquiryCampaignWSDTO();
            inquiryCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel));
            Page<InquiryDBModel> inquiryModelPage = inquiryRepository.findAllByCampaignId(campaignDBModel.getId(), PageRequest.of(reqPage, reqSize));
            inquiryCampaignWSDTO.setInquiries(inquiryMapper.createInquiryWSDTOS(inquiryModelPage.getContent()));
            inquiryCampaignWSDTO.setPagination(inquiryMapper.createInquiryPaginationWSDTO(inquiryModelPage));

            inquiryCampaignWSDTOS.add(inquiryCampaignWSDTO);
        }
        return inquiryCampaignWSDTOS;
    }


    public InquiryCampaignWSDTO getInquiryCampaignService(long userId,String campaignId,int reqPage,int reqSize) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            InquiryCampaignWSDTO inquiryCampaignWSDTO = new InquiryCampaignWSDTO();
            inquiryCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel.get()));
            Page<InquiryDBModel> inquiryModelPage = inquiryRepository.findAllByCampaignId(campaignDBModel.get().getId(), PageRequest.of(reqPage, reqSize));
            inquiryCampaignWSDTO.setInquiries(inquiryMapper.createInquiryWSDTOS(inquiryModelPage.getContent()));
            inquiryCampaignWSDTO.setPagination(inquiryMapper.createInquiryPaginationWSDTO(inquiryModelPage));

            return inquiryCampaignWSDTO;
        }
        return null;
    }


    public InquiryWSDTO getInquiryService(long userId, long inquiryId,long clientId) {

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (inquiryDBModels.size()>0){
            return new InquiryWSDTO(inquiryDBModels.get(0));
        }
        return null;
    }


    public InquiryWSDTO createInquiryService(long userId, String campaignId,long clientId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (campaignDBModel.isPresent() && clientDBModel.isPresent()){
            InquiryDBModel inquiryDBModel = inquiryMapper.mapInquiryDBModel(campaignDBModel.get(),clientDBModel.get());
            if (inquiryDBModel != null){
                return new InquiryWSDTO(inquiryRepository.save(inquiryDBModel));
            }
        }
        return null;
    }


    public InquiryWSDTO updateInquiryService(long userId, long inquiryId,long clientId) {

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (inquiryDBModels.size()>0){
            return new InquiryWSDTO(inquiryDBModels.get(0));
        }
        return null;
    }


    public InquiryWSDTO removeInquiryService(long userId,long inquiryId,long clientId) {

        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByIdAndClientId(inquiryId,clientId);
        if (inquiryDBModels.size()>0){
            inquiryRepository.delete(inquiryDBModels.get(0));
            return new InquiryWSDTO(inquiryDBModels.get(0));
        }
        return null;
    }

}
