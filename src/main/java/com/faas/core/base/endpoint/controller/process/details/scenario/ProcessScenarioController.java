package com.faas.core.base.endpoint.controller.process.details.scenario;

import com.faas.core.base.middleware.process.details.scenario.ProcessScenarioMiddleware;
import com.faas.core.base.model.ws.process.details.scenario.ProcessScenarioVariableWSModel;
import com.faas.core.base.model.ws.process.details.scenario.ProcessScenarioWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/scenario/")
public class ProcessScenarioController {

    @Autowired
    ProcessScenarioMiddleware processScenarioMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScenarios(@RequestParam long userId,
                                                 @RequestParam String processId) {

        ProcessScenarioWSModel response = processScenarioMiddleware.getProcessScenarios(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScenario(@RequestParam long userId,
                                                @RequestParam String processId,
                                                @RequestParam String scenarioId) {

        ProcessScenarioWSModel response = processScenarioMiddleware.getProcessScenario(userId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessScenario(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String scenarioId) {

        ProcessScenarioWSModel response = processScenarioMiddleware.createProcessScenario(userId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessScenario(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String scenarioId) {

        ProcessScenarioWSModel response = processScenarioMiddleware.removeProcessScenario(userId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_SCENARIO_VARIABLES, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScenarioVariables(@RequestParam long userId,
                                                         @RequestParam String processId,
                                                         @RequestParam String scenarioId) {

        ProcessScenarioVariableWSModel response = processScenarioMiddleware.getProcessScenarioVariables(userId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SCENARIO_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScenarioVariable(@RequestParam long userId,
                                                        @RequestParam String processId,
                                                        @RequestParam String scenarioId,
                                                        @RequestParam String variableId) {

        ProcessScenarioVariableWSModel response = processScenarioMiddleware.getProcessScenarioVariable(userId,processId,scenarioId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SCENARIO_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessScenarioVariable(@RequestParam long userId,
                                                           @RequestParam String processId,
                                                           @RequestParam String scenarioId,
                                                           @RequestParam long typeId,
                                                           @RequestParam String value) {

        ProcessScenarioVariableWSModel response = processScenarioMiddleware.createProcessScenarioVariable(userId,processId,scenarioId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SCENARIO_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessScenarioVariable(@RequestParam long userId,
                                                           @RequestParam String processId,
                                                           @RequestParam String scenarioId,
                                                           @RequestParam String variableId,
                                                           @RequestParam long typeId,
                                                           @RequestParam String value) {

        ProcessScenarioVariableWSModel response = processScenarioMiddleware.updateProcessScenarioVariable(userId,processId,scenarioId,variableId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SCENARIO_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessScenarioVariable(@RequestParam long userId,
                                                           @RequestParam String processId,
                                                           @RequestParam String scenarioId,
                                                           @RequestParam String variableId) {

        ProcessScenarioVariableWSModel response = processScenarioMiddleware.removeProcessScenarioVariable(userId,processId,scenarioId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
