package com.faas.core.api.framework.notification.details;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.notification.details.dto.ApiNotificationDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiNotificationDetailsFramework {


    @Autowired
    AppUtils appUtils;


    public ApiNotificationDetailsWSDTO apiGetNotificationDetailsService() {

        return null;
    }


    public List<ApiSummaryWSDTO> apiGetNotificationSummaryService() {

        return null;
    }



}
