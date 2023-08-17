package com.faas.core.api.endpoint.controller.operation.channel.message.sms;

import com.faas.core.api.middleware.operation.channel.message.sms.ApiSmsMessageMiddleware;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiOperationSmsWSModel;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiSmsTempWSModel;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiSmsWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/channel/message/sms/")
public class ApiSmsMessageController {


    @Autowired
    ApiSmsMessageMiddleware apiSmsMessageMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SMS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationSms(@RequestParam long agentId,
                                                       @RequestParam long sessionId,
                                                       @RequestParam long clientId) {

        ApiOperationSmsWSModel response = apiSmsMessageMiddleware.apiGetOperationSms(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SMSS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSmss(@RequestParam long agentId,
                                        @RequestParam long sessionId,
                                        @RequestParam long clientId,
                                        @RequestParam String processId) {

        ApiSmsWSModel response = apiSmsMessageMiddleware.apiGetSmss(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SMS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSms(@RequestParam long agentId,
                                       @RequestParam long sessionId,
                                       @RequestParam long clientId,
                                       @RequestParam String processId,
                                       @RequestParam String messageId) {

        ApiSmsWSModel response = apiSmsMessageMiddleware.apiGetSms(agentId,sessionId,clientId,processId,messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_SEND_SMS, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendSms(@RequestParam long agentId,
                                        @RequestParam long sessionId,
                                        @RequestParam long clientId,
                                        @RequestParam String processId,
                                        @RequestParam String tempId,
                                        @RequestParam long numberId) throws IOException {

        ApiSmsWSModel response = apiSmsMessageMiddleware.apiSendSms(agentId,sessionId,clientId,processId,tempId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_SMS, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateSms(@RequestParam long agentId,
                                          @RequestParam long sessionId,
                                          @RequestParam long clientId,
                                          @RequestParam String processId,
                                          @RequestParam String messageId) {

        ApiSmsWSModel response = apiSmsMessageMiddleware.apiUpdateSms(agentId,sessionId,clientId,processId,messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_SMS, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveSms(@RequestParam long agentId,
                                          @RequestParam long sessionId,
                                          @RequestParam long clientId,
                                          @RequestParam String processId,
                                          @RequestParam String messageId) {

        ApiSmsWSModel response = apiSmsMessageMiddleware.apiRemoveSms(agentId,sessionId,clientId,processId,messageId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_SMS_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSmsTemps(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam long clientId,
                                                   @RequestParam String processId) {

        ApiSmsTempWSModel response = apiSmsMessageMiddleware.apiGetSmsTemps(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SMS_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSmsTemp(@RequestParam long agentId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam long clientId,
                                                  @RequestParam String processId,
                                                  @RequestParam String tempId) {

        ApiSmsTempWSModel response = apiSmsMessageMiddleware.apiGetSmsTemp(agentId,sessionId,clientId,processId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
