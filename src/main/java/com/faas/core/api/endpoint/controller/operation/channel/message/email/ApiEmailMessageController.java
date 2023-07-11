package com.faas.core.api.endpoint.controller.operation.channel.message.email;

import com.faas.core.api.middleware.operation.channel.message.email.ApiEmailMessageMiddleware;
import com.faas.core.api.model.ws.operation.channel.message.email.ApiEmailMessageTempWSModel;
import com.faas.core.api.model.ws.operation.channel.message.email.ApiEmailMessageWSModel;
import com.faas.core.api.model.ws.operation.channel.message.email.ApiOperationEmailMessageWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/channel/message/email/")
public class ApiEmailMessageController {


    @Autowired
    ApiEmailMessageMiddleware apiEmailMessageMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_EMAIL_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationEmailMessage(@RequestParam long agentId,
                                                         @RequestParam long sessionId) {

        ApiOperationEmailMessageWSModel response = apiEmailMessageMiddleware.apiGetOperationEmailMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_EMAIL_MESSAGES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetEmailMessages(@RequestParam long agentId,
                                                 @RequestParam long sessionId) {

        ApiEmailMessageWSModel response = apiEmailMessageMiddleware.apiGetEmailMessages(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_EMAIL_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetEmailMessage(@RequestParam long agentId,
                                                @RequestParam long sessionId) {

        ApiEmailMessageWSModel response = apiEmailMessageMiddleware.apiGetEmailMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_SEND_EMAIL_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendEmailMessage(@RequestParam long agentId,
                                                 @RequestParam long sessionId) {

        ApiEmailMessageWSModel response = apiEmailMessageMiddleware.apiSendEmailMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_EMAIL_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateEmailMessage(@RequestParam long agentId,
                                                   @RequestParam long sessionId) {

        ApiEmailMessageWSModel response = apiEmailMessageMiddleware.apiUpdateEmailMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_EMAIL_MESSAGE, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveEmailMessage(@RequestParam long agentId,
                                                   @RequestParam long sessionId) {

        ApiEmailMessageWSModel response = apiEmailMessageMiddleware.apiRemoveEmailMessage(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_EMAIL_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetEmailMessageTemps(@RequestParam long agentId,
                                                     @RequestParam long sessionId) {

        ApiEmailMessageTempWSModel response = apiEmailMessageMiddleware.apiGetEmailMessageTemps(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_EMAIL_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetEmailMessageTemp(@RequestParam long agentId,
                                                    @RequestParam long sessionId) {

        ApiEmailMessageTempWSModel response = apiEmailMessageMiddleware.apiGetEmailMessageTemp(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
