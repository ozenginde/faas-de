package com.faas.core.base.endpoint.controller.scenario.settings;

import com.faas.core.base.middleware.scenario.settings.ScenarioSettingsMiddleware;
import com.faas.core.base.model.ws.scenario.settings.ActionTypeWSModel;
import com.faas.core.base.model.ws.scenario.settings.AutomationTypeWSModel;
import com.faas.core.base.model.ws.scenario.settings.ScenarioTypeWSModel;
import com.faas.core.base.model.ws.scenario.settings.VariableTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/settings/")
public class ScenarioSettingsController {

    @Autowired
    ScenarioSettingsMiddleware scenarioSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_SCENARIO_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllScenarioTypes(@RequestParam long userId) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.getAllScenarioTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_SCENARIO_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioType(@RequestParam long userId,
                                             @RequestParam long typeId) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.getScenarioType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SCENARIO_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createScenarioType(@RequestParam long userId,
                                                @RequestParam String scenarioType,
                                                @RequestParam String baseType) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.createScenarioType(userId,scenarioType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SCENARIO_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateScenarioType(@RequestParam long userId,
                                                @RequestParam long typeId,
                                                @RequestParam String scenarioType,
                                                @RequestParam String baseType) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.updateScenarioType(userId,typeId,scenarioType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SCENARIO_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeScenarioType(@RequestParam long userId,
                                                @RequestParam long typeId) {

        ScenarioTypeWSModel response = scenarioSettingsMiddleware.removeScenarioType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_VARIABLE_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllVariableTypes(@RequestParam long userId) {

        VariableTypeWSModel response = scenarioSettingsMiddleware.getAllVariableTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_VARIABLE_TYPES_BY_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<?> getVariableTypesByCategory(@RequestParam long userId,
                                                        @RequestParam String category) {

        VariableTypeWSModel response = scenarioSettingsMiddleware.getVariableTypesByCategory(userId,category);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_VARIABLE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getVariableType(@RequestParam long userId,
                                             @RequestParam long typeId) {

        VariableTypeWSModel response = scenarioSettingsMiddleware.getVariableType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_VARIABLE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createVariableType(@RequestParam long userId,
                                                @RequestParam String variableType,
                                                @RequestParam String category) {

        VariableTypeWSModel response = scenarioSettingsMiddleware.createVariableType(userId,variableType,category);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_VARIABLE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateVariableType(@RequestParam long userId,
                                                @RequestParam long typeId,
                                                @RequestParam String variableType,
                                                @RequestParam String category) {

        VariableTypeWSModel response = scenarioSettingsMiddleware.updateVariableType(userId,typeId,variableType,category);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_VARIABLE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeVariableType(@RequestParam long userId,
                                                @RequestParam long typeId) {

        VariableTypeWSModel response = scenarioSettingsMiddleware.removeVariableType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ACTION_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getActionTypes(@RequestParam long userId) {

        ActionTypeWSModel response = scenarioSettingsMiddleware.getActionTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ACTION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getActionType(@RequestParam long userId,
                                           @RequestParam long typeId) {

        ActionTypeWSModel response = scenarioSettingsMiddleware.getActionType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ACTION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createActionType(@RequestParam long userId,
                                              @RequestParam String actionType) {

        ActionTypeWSModel response = scenarioSettingsMiddleware.createActionType(userId,actionType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_ACTION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateActionType(@RequestParam long userId,
                                              @RequestParam long typeId,
                                              @RequestParam String actionType) {

        ActionTypeWSModel response = scenarioSettingsMiddleware.updateActionType(userId,typeId,actionType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ACTION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeActionType(@RequestParam long userId,
                                              @RequestParam long typeId) {

        ActionTypeWSModel response = scenarioSettingsMiddleware.removeActionType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationTypes(@RequestParam long userId) {

        AutomationTypeWSModel response = scenarioSettingsMiddleware.getAutomationTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationType(@RequestParam long userId,
                                               @RequestParam long typeId) {

        AutomationTypeWSModel response = scenarioSettingsMiddleware.getAutomationType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_AUTOMATION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomationType(@RequestParam long userId,
                                                  @RequestParam String automationType,
                                                  @RequestParam String baseType) {

        AutomationTypeWSModel response = scenarioSettingsMiddleware.createAutomationType(userId,automationType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomationType(@RequestParam long userId,
                                                  @RequestParam long typeId,
                                                  @RequestParam String automationType,
                                                  @RequestParam String baseType) {

        AutomationTypeWSModel response = scenarioSettingsMiddleware.updateAutomationType(userId,typeId,automationType,baseType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomationType(@RequestParam long userId,
                                                  @RequestParam long typeId) {

        AutomationTypeWSModel response = scenarioSettingsMiddleware.removeAutomationType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
