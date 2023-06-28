package com.faas.core.base.middleware.inquiry.settings;

import com.faas.core.base.framework.inquiry.settings.InquirySettingsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.settings.InquiryTypeWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquirySettingsMiddleware {


    @Autowired
    InquirySettingsFramework inquirySettingsFramework;


    public InquiryTypeWSModel getAllInquiryTypes(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllInquiryTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel getInquiryType(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel createInquiryType(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("createInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel updateInquiryType(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("updateInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel removeInquiryType(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("removeInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
