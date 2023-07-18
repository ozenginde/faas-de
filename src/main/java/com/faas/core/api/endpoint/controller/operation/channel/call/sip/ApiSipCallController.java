package com.faas.core.api.endpoint.controller.operation.channel.call.sip;

import com.faas.core.api.middleware.operation.channel.call.sip.ApiSipCallMiddleware;
import com.faas.core.api.model.ws.operation.channel.call.sip.ApiOperationSipCallWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/channel/call/sip/")
public class ApiSipCallController {

    @Autowired
    ApiSipCallMiddleware apiSipCallMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSipCall(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId,
                                                    @RequestParam String processId) {

        ApiOperationSipCallWSModel response = apiSipCallMiddleware.apiGetOperationSipCall(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSipCall(@RequestParam long agentId,
                                           @RequestParam long sessionId,
                                           @RequestParam long clientId,
                                           @RequestParam String processId,
                                           @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiSipCallMiddleware.apiGetSipCall(agentId,sessionId,clientId,processId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_CREATE_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateSipCall(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam long clientId,
                                              @RequestParam String processId,
                                              @RequestParam long numberId) {

        ApiOperationSipCallWSModel response = apiSipCallMiddleware.apiCreateSipCall(agentId,sessionId,clientId,processId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateSipCall(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam long clientId,
                                              @RequestParam String processId,
                                              @RequestParam String callId,
                                              @RequestParam String callState) {

        ApiOperationSipCallWSModel response = apiSipCallMiddleware.apiUpdateSipCall(agentId,sessionId,clientId,processId,callId,callState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_SIP_CALL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveSipCall(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam long clientId,
                                              @RequestParam String processId,
                                              @RequestParam String callId) {

        ApiOperationSipCallWSModel response = apiSipCallMiddleware.apiRemoveSipCall(agentId,sessionId,clientId,processId,callId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
