package com.faas.core.base.endpoint.controller.process.details.trigger;

import com.faas.core.base.middleware.process.details.trigger.ProcessTriggerMiddleware;
import com.faas.core.base.model.ws.process.details.trigger.ProcessTriggerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/trigger/")
public class ProcessTriggerController {


    @Autowired
    ProcessTriggerMiddleware processTriggerMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessTrigger(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTrigger(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createSmsTrigger(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTrigger(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateSmsTrigger(@RequestParam long userId,
                                              @RequestParam String processId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTrigger(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SMS_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeSmsTrigger(@RequestParam long userId,
                                              @RequestParam String processId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTrigger(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.CREATE_WAPP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> createWappTrigger(@RequestParam long userId,
                                              @RequestParam String processId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTrigger(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_WAPP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappTrigger(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTrigger(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_WAPP_TRIGGER, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappTrigger(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessTriggerWSModel response = processTriggerMiddleware.getProcessTrigger(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
