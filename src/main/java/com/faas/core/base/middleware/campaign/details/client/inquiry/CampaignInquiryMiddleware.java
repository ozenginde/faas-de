package com.faas.core.base.middleware.campaign.details.client.inquiry;

import com.faas.core.base.framework.campaign.details.client.inquiry.CampaignInquiryFramework;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquiryWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.InquiryWSModel;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignInquiryMiddleware {


    @Autowired
    CampaignInquiryFramework campaignInquiryFramework;


    public CampaignInquiryWSModel searchCampaignInquiries(long userId, String campaignId,String city,String country,int reqPage,int reqSize) {

        CampaignInquiryWSModel response = new CampaignInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquiryWSDTO campaignInquiryWSDTO = campaignInquiryFramework.searchCampaignInquiriesService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignInquiryWSDTO != null){
            response.setCampaignInquiry(campaignInquiryWSDTO);
        }

        general.setOperation("getCampaignInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignInquiryWSModel getCampaignInquiries(long userId,String campaignId,int reqPage,int reqSize) {

        CampaignInquiryWSModel response = new CampaignInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquiryWSDTO campaignInquiryWSDTO = campaignInquiryFramework.getCampaignInquiriesService(userId,campaignId,reqPage,reqSize);
        if (campaignInquiryWSDTO != null){
            response.setCampaignInquiry(campaignInquiryWSDTO);
        }

        general.setOperation("getCampaignInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel getCampaignInquiry(long userId,long inquiryId,long clientId) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();

        InquiryWSDTO inquiryWSDTO = campaignInquiryFramework.getCampaignInquiryService(userId,inquiryId,clientId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("getCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public InquiryWSModel createCampaignInquiry(long userId,String campaignId,long clientId) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();

        InquiryWSDTO inquiryWSDTO = campaignInquiryFramework.createCampaignInquiryService(userId,campaignId,clientId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("createCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public InquiryWSModel updateCampaignInquiry(long userId,long inquiryId,long clientId,String inquiryState) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();

        InquiryWSDTO inquiryWSDTO = campaignInquiryFramework.updateCampaignInquiryService(userId,inquiryId,clientId,inquiryState);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("updateCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public InquiryWSModel removeCampaignInquiry(long userId,long inquiryId,long clientId) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();

        InquiryWSDTO inquiryWSDTO = campaignInquiryFramework.removeCampaignInquiryService(userId,inquiryId,clientId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("removeCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
