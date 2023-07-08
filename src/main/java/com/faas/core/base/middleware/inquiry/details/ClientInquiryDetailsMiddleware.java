package com.faas.core.base.middleware.inquiry.details;

import com.faas.core.base.framework.inquiry.details.InquiryDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.ClientInquiryWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientInquiryDetailsMiddleware {


    @Autowired
    InquiryDetailsFramework inquiryDetailsFramework;


    public ClientInquiryWSModel getClientInquiryDetails(long userId, int reqPage, int reqSize) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getClientInquiryDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
