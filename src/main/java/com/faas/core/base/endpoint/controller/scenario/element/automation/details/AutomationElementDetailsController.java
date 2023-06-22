package com.faas.core.base.endpoint.controller.scenario.element.automation.details;

import com.faas.core.base.middleware.scenario.element.automation.details.AutomationElementDetailsMiddleware;
import com.faas.core.base.model.ws.scenario.element.automation.details.AutomationElementDataWSModel;
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
public class AutomationElementDetailsController {


    @Autowired
    AutomationElementDetailsMiddleware automationElementDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_ELEMENT_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationElementDatas(@RequestParam long userId,
                                                        @RequestParam String elementId) {

        AutomationElementDataWSModel response = automationElementDetailsMiddleware.getAutomationElementDatas(userId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_ELEMENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationElementData(@RequestParam long userId,
                                                      @RequestParam String elementId,
                                                      @RequestParam String dataId) {

        AutomationElementDataWSModel response = automationElementDetailsMiddleware.getAutomationElementData(userId,elementId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_AUTOMATION_ELEMENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomationElementData(@RequestParam long userId,
                                                         @RequestParam String elementId,
                                                         @RequestParam long dataTypeId,
                                                         @RequestParam String value) {

        AutomationElementDataWSModel response = automationElementDetailsMiddleware.createAutomationElementData(userId,elementId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATION_ELEMENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomationElementData(@RequestParam long userId,
                                                         @RequestParam String elementId,
                                                         @RequestParam String dataId,
                                                         @RequestParam long dataTypeId,
                                                         @RequestParam String value) {

        AutomationElementDataWSModel response = automationElementDetailsMiddleware.updateAutomationElementData(userId,elementId,dataId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATION_ELEMENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomationElementData(@RequestParam long userId,
                                                         @RequestParam String elementId,
                                                         @RequestParam String dataId) {

        AutomationElementDataWSModel response = automationElementDetailsMiddleware.removeAutomationElementData(userId,elementId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
