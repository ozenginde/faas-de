package com.faas.core.base.endpoint.controller.scenario.element.automation.details;

import com.faas.core.base.middleware.scenario.element.automation.details.AutomationDetailsMiddleware;
import com.faas.core.base.model.ws.scenario.element.automation.details.AutomationDataWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/element/automation/details/")
public class AutomationDetailsController {


    @Autowired
    AutomationDetailsMiddleware automationDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationDatas(@RequestParam long userId,
                                                @RequestParam String automationId) {

        AutomationDataWSModel response = automationDetailsMiddleware.getAutomationDatas(userId,automationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationData(@RequestParam long userId,
                                               @RequestParam String automationId,
                                               @RequestParam String dataId) {

        AutomationDataWSModel response = automationDetailsMiddleware.getAutomationData(userId,automationId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_AUTOMATION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomationData(@RequestParam long userId,
                                                  @RequestParam String automationId,
                                                  @RequestParam long dataTypeId,
                                                  @RequestParam String value) {

        AutomationDataWSModel response = automationDetailsMiddleware.createAutomationData(userId,automationId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomationData(@RequestParam long userId,
                                                  @RequestParam String automationId,
                                                  @RequestParam String dataId,
                                                  @RequestParam long dataTypeId,
                                                  @RequestParam String value) {

        AutomationDataWSModel response = automationDetailsMiddleware.updateAutomationData(userId,automationId,dataId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomationData(@RequestParam long userId,
                                                  @RequestParam String automationId,
                                                  @RequestParam String dataId) {

        AutomationDataWSModel response = automationDetailsMiddleware.removeAutomationData(userId,automationId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
