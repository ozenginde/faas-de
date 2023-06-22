package com.faas.core.api.middleware.notification.details;

import com.faas.core.api.framework.notification.details.ApiNotificationDetailsFramework;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.notification.details.ApiNotificationDetailsWSModel;
import com.faas.core.api.model.ws.session.details.ApiSessionClientWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiNotificationDetailsMiddleware {


    @Autowired
    ApiNotificationDetailsFramework apiNotificationDetailsFramework;


    public ApiNotificationDetailsWSModel apiGetNotificationDetails(long agentId) {

        ApiNotificationDetailsWSModel response = new ApiNotificationDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetNotificationDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetNotificationSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetNotificationSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
