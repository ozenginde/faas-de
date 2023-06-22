package com.faas.core.api.endpoint.controller.operation.content;

import com.faas.core.api.middleware.operation.content.ApiOperationMiddleware;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.details.content.ApiOperationDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/")
public class ApiOperationController {


    @Autowired
    ApiOperationMiddleware apiOperationMiddleware;


    @RequestMapping(value = ApiRoute.API_OPERATION_VALIDATE, method = RequestMethod.POST)
    public ResponseEntity<?> apiOperationValidate(@RequestParam long agentId,
                                                  @RequestParam long sessionId) {

        ApiOperationDetailsWSModel response = apiOperationMiddleware.apiOperationValidate(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperation(@RequestParam long agentId,
                                             @RequestParam long sessionId,
                                             @RequestParam long clientId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiGetOperation(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_START_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartOperation(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam long clientId,
                                               @RequestParam String campaignId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiStartOperation(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperation(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam long clientId,
                                                @RequestParam String campaignId,
                                                @RequestParam String operationResult) {

        ApiOperationWSModel response = apiOperationMiddleware.apiUpdateOperation(agentId,sessionId,clientId,campaignId,operationResult);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperation(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam long clientId,
                                                @RequestParam String campaignId) {

        ApiOperationWSModel response = apiOperationMiddleware.apiRemoveOperation(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
