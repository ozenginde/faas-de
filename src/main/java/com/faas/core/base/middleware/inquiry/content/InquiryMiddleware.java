package com.faas.core.base.middleware.inquiry.content;

import com.faas.core.base.framework.inquiry.content.InquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.InquiryCampaignWSModel;
import com.faas.core.base.model.ws.inquiry.content.InquiryWSModel;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryCampaignWSDTO;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class InquiryMiddleware {


    @Autowired
    InquiryFramework inquiryFramework;


    public InquiryWSModel getAllInquiries(long userId, int reqPage, int reqSize) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryWSDTO> inquiryWSDTOS =  inquiryFramework.getAllInquiriesService(userId,reqPage,reqSize);
        if (inquiryWSDTOS != null){
            response.setInquiries(inquiryWSDTOS);
        }

        general.setOperation("getAllInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel getInquiriesByState(long userId,String inquiryState, int reqPage, int reqSize) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryWSDTO> inquiryWSDTOS =  inquiryFramework.getInquiriesByStateService(userId,inquiryState,reqPage,reqSize);
        if (inquiryWSDTOS != null){
            response.setInquiries(inquiryWSDTOS);
        }

        general.setOperation("getInquiriesByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryCampaignWSModel getInquiryCampaigns(long userId,int reqPage,int reqSize) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS =  inquiryFramework.getInquiryCampaignsService(userId,reqPage,reqSize);
        if (inquiryCampaignWSDTOS != null){
            response.setInquiryCampaigns(inquiryCampaignWSDTOS);
        }

        general.setOperation("getInquiryCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryCampaignWSModel getInquiryCampaign(long userId,String campaignId,int reqPage,int reqSize) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS = new ArrayList<>();

        InquiryCampaignWSDTO inquiryCampaignWSDTO =  inquiryFramework.getInquiryCampaignService(userId,campaignId,reqPage,reqSize);
        if (inquiryCampaignWSDTO != null){
            inquiryCampaignWSDTOS.add(inquiryCampaignWSDTO);
        }

        response.setInquiryCampaigns(inquiryCampaignWSDTOS);
        general.setOperation("getInquiryCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel getInquiry(long userId, long inquiryId,long clientId) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();

        InquiryWSDTO inquiryWSDTO =  inquiryFramework.getInquiryService(userId,inquiryId,clientId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("getInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel createInquiry(long userId,String campaignId,long clientId) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();

        InquiryWSDTO inquiryWSDTO =  inquiryFramework.createInquiryService(userId,campaignId,clientId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("createInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel updateInquiry(long userId, long inquiryId,long clientId) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();

        InquiryWSDTO inquiryWSDTO =  inquiryFramework.updateInquiryService(userId,inquiryId,clientId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("updateInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel removeInquiry(long userId,long inquiryId,long clientId) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryWSDTO>inquiryWSDTOS = new ArrayList<>();

        InquiryWSDTO inquiryWSDTO =  inquiryFramework.removeInquiryService(userId,inquiryId,clientId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("removeInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
