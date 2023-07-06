package com.faas.core.base.middleware.inquiry.content;

import com.faas.core.base.framework.inquiry.content.InquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.InquiryWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquiryMiddleware {


    @Autowired
    InquiryFramework inquiryFramework;


    public InquiryWSModel getAllInquiries(long userId, int reqPage, int reqSize) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


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


        general.setOperation("getInquiriesByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel getInquiry(long userId, long inquiryId,long clientId) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel createInquiry(long userId) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


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


        general.setOperation("removeInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
