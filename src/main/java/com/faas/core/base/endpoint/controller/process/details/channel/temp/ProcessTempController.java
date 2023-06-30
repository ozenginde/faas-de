package com.faas.core.base.endpoint.controller.process.details.channel.temp;

import com.faas.core.base.middleware.process.details.channel.temp.ProcessTempMiddleware;
import com.faas.core.base.model.ws.process.details.channel.temp.*;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/channel/temp/")
public class ProcessTempController {


    @Autowired
    ProcessTempMiddleware processTempMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTemps(@RequestParam long userId,
                                             @RequestParam String processId) {

        ProcessTempWSModel response = processTempMiddleware.getProcessTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsMessageTemps(@RequestParam long userId,
                                                       @RequestParam String processId) {

        SmsMessageTempWSModel response = processTempMiddleware.getProcessSmsMessageTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsMessageTemp(@RequestParam long userId,
                                                      @RequestParam String tempId) {

        SmsMessageTempWSModel response = processTempMiddleware.getProcessSmsMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessSmsMessageTemp(@RequestParam long userId,
                                                         @RequestParam String processId,
                                                         @RequestParam String title,
                                                         @RequestParam String body,
                                                         @RequestParam String senderId,
                                                         @RequestParam long typeId) {

        SmsMessageTempWSModel response = processTempMiddleware.createProcessSmsMessageTemp(userId,processId,title,body,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessSmsMessageTemp(@RequestParam long userId,
                                                         @RequestParam String tempId,
                                                         @RequestParam String title,
                                                         @RequestParam String body,
                                                         @RequestParam String senderId,
                                                         @RequestParam long typeId) {

        SmsMessageTempWSModel response = processTempMiddleware.updateProcessSmsMessageTemp(userId,tempId,title,body,senderId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SMS_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessSmsMessageTemp(@RequestParam long userId,
                                                         @RequestParam String tempId) {

        SmsMessageTempWSModel response = processTempMiddleware.removeProcessSmsMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTemps(@RequestParam long userId,
                                                        @RequestParam String processId) {

        WappMessageTempWSModel response = processTempMiddleware.getProcessWappMessageTemps(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappMessageTemp(@RequestParam long userId,
                                                       @RequestParam String tempId) {

        WappMessageTempWSModel response = processTempMiddleware.getProcessWappMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.CREATE_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessWappMessageTemp(@RequestParam long userId,
                                                          @RequestParam String processId,
                                                          @RequestParam String title,
                                                          @RequestParam String body,
                                                          @RequestParam long typeId) {

        WappMessageTempWSModel response = processTempMiddleware.createProcessWappMessageTemp(userId,processId,title,body,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessWappMessageTemp(@RequestParam long userId,
                                                          @RequestParam String tempId,
                                                          @RequestParam String title,
                                                          @RequestParam String body,
                                                          @RequestParam long typeId) {

        WappMessageTempWSModel response = processTempMiddleware.updateProcessWappMessageTemp(userId,tempId,title,body,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_MESSAGE_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappMessageTemp(@RequestParam long userId,
                                                          @RequestParam String tempId) {

        WappMessageTempWSModel response = processTempMiddleware.removeProcessWappMessageTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTemps(@RequestParam long userId,
                                                  @RequestParam String processId) {

        EmailTempWSModel response = processTempMiddleware.getProcessEmailTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailTemp(@RequestParam long userId,
                                                 @RequestParam String tempId) {

        EmailTempWSModel response = processTempMiddleware.getProcessEmailTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessEmailTemp(@RequestParam long userId,
                                                    @RequestParam String processId,
                                                    @RequestParam String subject,
                                                    @RequestParam String body,
                                                    @RequestParam String footer,
                                                    @RequestParam String sender,
                                                    @RequestParam long typeId) {

        EmailTempWSModel response = processTempMiddleware.createProcessEmailTemp(userId,processId,subject,body,footer,sender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessEmailTemp(@RequestParam long userId,
                                                    @RequestParam String tempId,
                                                    @RequestParam String subject,
                                                    @RequestParam String body,
                                                    @RequestParam String footer,
                                                    @RequestParam String sender,
                                                    @RequestParam long typeId) {

        EmailTempWSModel response = processTempMiddleware.updateProcessEmailTemp(userId,tempId,subject,body,footer,sender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessEmailTemp(@RequestParam long userId,
                                                    @RequestParam String tempId) {

        EmailTempWSModel response = processTempMiddleware.removeProcessEmailTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_PUSH_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessPushTemps(@RequestParam long userId,
                                                 @RequestParam String processId) {

        PushTempWSModel response = processTempMiddleware.getProcessPushTemps(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessPushTemp(@RequestParam long userId,
                                                @RequestParam String tempId) {

        PushTempWSModel response = processTempMiddleware.getProcessPushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessPushTemp(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String header,
                                                   @RequestParam String body,
                                                   @RequestParam String footer,
                                                   @RequestParam String sender,
                                                   @RequestParam long typeId) {

        PushTempWSModel response = processTempMiddleware.createProcessPushTemp(userId,processId,header,body,footer,sender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessPushTemp(@RequestParam long userId,
                                                   @RequestParam String tempId,
                                                   @RequestParam String header,
                                                   @RequestParam String body,
                                                   @RequestParam String footer,
                                                   @RequestParam String sender,
                                                   @RequestParam long typeId) {

        PushTempWSModel response = processTempMiddleware.updateProcessPushTemp(userId,tempId,header,body,footer,sender,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_PUSH_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessPushTemp(@RequestParam long userId,
                                                   @RequestParam String tempId) {

        PushTempWSModel response = processTempMiddleware.removeProcessPushTemp(userId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
