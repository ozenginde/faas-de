package com.faas.core.api.framework.notification.content;

import com.faas.core.api.model.ws.session.details.dto.ApiSessionClientWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiNotificationFramework {


    @Autowired
    AppUtils appUtils;


    public ApiSessionClientWSDTO apiGetAgentNotificationService() {

        return null;
    }


    public ApiSessionClientWSDTO apiGetNotificationsService() {

        return null;
    }

    public ApiSessionClientWSDTO apiGetNotificationsByStateService() {

        return null;
    }

    public ApiSessionClientWSDTO apiGetNotificationService() {

        return null;
    }

    public ApiSessionClientWSDTO apiUpdateNotificationService() {

        return null;
    }


    public ApiSessionClientWSDTO apiRemoveNotificationService() {

        return null;
    }


}
