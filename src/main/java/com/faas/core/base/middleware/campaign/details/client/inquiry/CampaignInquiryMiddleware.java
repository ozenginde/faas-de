package com.faas.core.base.middleware.campaign.details.client.inquiry;

import com.faas.core.base.framework.campaign.details.client.inquiry.CampaignInquiryFramework;
import com.faas.core.base.model.ws.campaign.details.client.content.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.InquiryRequest;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignInquiryMiddleware {


    @Autowired
    CampaignInquiryFramework campaignInquiryFramework;



    public CampaignClientWSModel searchCampaignInquiries(long userId, String campaignId,String city,String country,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignInquiryFramework.searchCampaignInquiriesService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("getCampaignInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignClientWSModel getCampaignInquiries(long userId,String campaignId,String inquiryState, int reqPage, int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignInquiryFramework.getCampaignInquiriesService(userId,campaignId,inquiryState,reqPage,reqSize);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("getCampaignInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignClientWSModel getCampaignInquiry(long userId,long inquiryId,long clientId) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignInquiryFramework.getCampaignInquiryService(userId,inquiryId,clientId);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("getCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CampaignClientWSModel createCampaignInquiry(InquiryRequest inquiryRequest) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignInquiryFramework.createCampaignInquiryService(inquiryRequest);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("createCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CampaignClientWSModel updateCampaignInquiry(long userId,long inquiryId,long clientId,String campaignId,String inquiryState) {
        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignInquiryFramework.updateCampaignInquiryService(userId,inquiryId,clientId,campaignId,inquiryState);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("updateCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CampaignClientWSModel removeCampaignInquiry(long userId,long inquiryId,long clientId) {
        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignInquiryFramework.removeCampaignInquiryService(userId,inquiryId,clientId);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("removeCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
