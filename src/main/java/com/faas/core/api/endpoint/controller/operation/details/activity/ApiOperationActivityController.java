package com.faas.core.api.endpoint.controller.operation.details.activity;

import com.faas.core.api.middleware.operation.details.activity.ApiOperationActivityMiddleware;
import com.faas.core.api.model.ws.operation.details.activity.ApiOperationActivityWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/activity/")
public class ApiOperationActivityController {


    @Autowired
    ApiOperationActivityMiddleware apiOperationActivityMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_ACTIVITIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationActivities(@RequestParam long agentId,
                                                       @RequestParam long sessionId,
                                                       @RequestParam long clientId) {

        ApiOperationActivityWSModel response = apiOperationActivityMiddleware.apiGetOperationActivities(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_ACTIVITY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationActivity(@RequestParam long agentId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam long clientId,
                                                     @RequestParam String activityId) {

        ApiOperationActivityWSModel response = apiOperationActivityMiddleware.apiGetOperationActivity(agentId,sessionId,clientId,activityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_CREATE_OPERATION_ACTIVITY, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateOperationActivity(@RequestParam long agentId,
                                                        @RequestParam long sessionId,
                                                        @RequestParam long clientId) {

        ApiOperationActivityWSModel response = apiOperationActivityMiddleware.apiCreateOperationActivity(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_ACTIVITY, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationActivity(@RequestParam long agentId,
                                                        @RequestParam long sessionId,
                                                        @RequestParam long clientId) {

        ApiOperationActivityWSModel response = apiOperationActivityMiddleware.apiUpdateOperationActivity(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_ACTIVITY, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationActivity(@RequestParam long agentId,
                                                        @RequestParam long sessionId,
                                                        @RequestParam long clientId,
                                                        @RequestParam String activityId) {

        ApiOperationActivityWSModel response = apiOperationActivityMiddleware.apiRemoveOperationActivity(agentId,sessionId,clientId,activityId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
