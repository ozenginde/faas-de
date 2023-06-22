package com.faas.core.base.middleware.inquiry.details;

import com.faas.core.base.framework.inquiry.details.InquiryDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.details.InquiryDetailsWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquiryDetailsMiddleware {


    @Autowired
    InquiryDetailsFramework inquiryDetailsFramework;


    public InquiryDetailsWSModel getInquiryDetails(long userId, long inquiryId) {

        InquiryDetailsWSModel response = new InquiryDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getInquiryDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
