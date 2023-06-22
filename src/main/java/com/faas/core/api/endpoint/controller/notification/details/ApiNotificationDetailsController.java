package com.faas.core.api.endpoint.controller.notification.details;

import com.faas.core.api.middleware.notification.details.ApiNotificationDetailsMiddleware;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.notification.details.ApiNotificationDetailsWSModel;
import com.faas.core.api.model.ws.session.details.ApiSessionClientWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/notification/details/")
public class ApiNotificationDetailsController {


    @Autowired
    ApiNotificationDetailsMiddleware apiNotificationDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_NOTIFICATION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetNotificationDetails(@RequestParam long agentId) {

        ApiNotificationDetailsWSModel response = apiNotificationDetailsMiddleware.apiGetNotificationDetails(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_NOTIFICATION_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetNotificationSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiNotificationDetailsMiddleware.apiGetNotificationSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
