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


        general.setOperation("getAllNotifications");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel getInquiriesByState(long userId, int reqPage, int reqSize) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllNotifications");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel getInquiry(long userId, int reqPage, int reqSize) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllNotifications");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel createInquiry(long userId, int reqPage, int reqSize) {

        return null;
    }


    public InquiryWSModel updateInquiry(long userId, int reqPage, int reqSize) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllNotifications");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryWSModel removeInquiry(long userId, int reqPage, int reqSize) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllNotifications");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
