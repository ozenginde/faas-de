package com.faas.core.base.middleware.inquiry.maanger;

import com.faas.core.base.framework.inquiry.manager.InquiryManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.InquiryWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquiryManagerMiddleware {


    @Autowired
    InquiryManagerFramework inquiryManagerFramework;


    public InquiryWSModel getInquiryDetails(long userId, int reqPage, int reqSize) {

        InquiryWSModel response = new InquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getInquiryDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
