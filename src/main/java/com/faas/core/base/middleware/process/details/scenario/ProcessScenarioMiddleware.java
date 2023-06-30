package com.faas.core.base.middleware.process.details.scenario;

import com.faas.core.base.framework.process.details.scenario.ProcessScenarioFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.scenario.ProcessScenarioVariableWSModel;
import com.faas.core.base.model.ws.process.details.scenario.ProcessScenarioWSModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioVariableWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessScenarioMiddleware {

    @Autowired
    ProcessScenarioFramework processScenarioFramework;


    public ProcessScenarioWSModel getProcessScenarios(long userId, String processId) {

        ProcessScenarioWSModel response = new ProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessScenarioWSDTO> processScenarioWSDTOS = processScenarioFramework.getProcessScenariosService(processId);
        if (processScenarioWSDTOS != null){
            response.setProcessScenarios(processScenarioWSDTOS);
        }

        general.setOperation("getProcessScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioWSModel getProcessScenario(long userId,String processId,String scenarioId) {

        ProcessScenarioWSModel response = new ProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();

        ProcessScenarioWSDTO processScenarioWSDTO = processScenarioFramework.getProcessScenarioService(processId,scenarioId);
        if (processScenarioWSDTO != null){
            processScenarioWSDTOS.add(processScenarioWSDTO);
        }

        response.setProcessScenarios(processScenarioWSDTOS);
        general.setOperation("getProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioWSModel createProcessScenario(long userId,String processId,String scenarioId) {

        ProcessScenarioWSModel response = new ProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();

        ProcessScenarioWSDTO processScenarioWSDTO = processScenarioFramework.createProcessScenarioService(processId,scenarioId);
        if (processScenarioWSDTO != null){
            processScenarioWSDTOS.add(processScenarioWSDTO);
        }

        response.setProcessScenarios(processScenarioWSDTOS);
        general.setOperation("getProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioWSModel removeProcessScenario(long userId,String processId,String scenarioId) {

        ProcessScenarioWSModel response = new ProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();

        ProcessScenarioWSDTO processScenarioWSDTO = processScenarioFramework.removeProcessScenarioService(processId,scenarioId);
        if (processScenarioWSDTO != null){
            processScenarioWSDTOS.add(processScenarioWSDTO);
        }

        response.setProcessScenarios(processScenarioWSDTOS);
        general.setOperation("getProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ProcessScenarioVariableWSModel getProcessScenarioVariables(long userId, String processId, String scenarioId) {

        ProcessScenarioVariableWSModel response = new ProcessScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessScenarioVariableWSDTO> scenarioVariableWSDTOS = processScenarioFramework.getProcessScenarioVariablesService(processId,scenarioId);
        if (scenarioVariableWSDTOS != null){
            response.setScenarioVariables(scenarioVariableWSDTOS);
        }

        general.setOperation("getProcessScenarioVariables");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioVariableWSModel getProcessScenarioVariable(long userId, String processId, String scenarioId, String variableId) {

        ProcessScenarioVariableWSModel response = new ProcessScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();

        ProcessScenarioVariableWSDTO scenarioVariableWSDTO = processScenarioFramework.getProcessScenarioVariableService(processId,scenarioId,variableId);
        if (scenarioVariableWSDTO != null){
            scenarioVariableWSDTOS.add(scenarioVariableWSDTO);
        }

        response.setScenarioVariables(scenarioVariableWSDTOS);
        general.setOperation("getProcessScenarioVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioVariableWSModel createProcessScenarioVariable(long userId, String processId, String scenarioId, long typeId, String value) {

        ProcessScenarioVariableWSModel response = new ProcessScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();

        ProcessScenarioVariableWSDTO scenarioVariableWSDTO = processScenarioFramework.createProcessScenarioVariableService(processId,scenarioId,typeId,value);
        if (scenarioVariableWSDTO != null){
            scenarioVariableWSDTOS.add(scenarioVariableWSDTO);
        }

        response.setScenarioVariables(scenarioVariableWSDTOS);
        general.setOperation("createProcessScenarioVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioVariableWSModel updateProcessScenarioVariable(long userId, String processId, String scenarioId, String variableId, long typeId, String value) {

        ProcessScenarioVariableWSModel response = new ProcessScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();

        ProcessScenarioVariableWSDTO scenarioVariableWSDTO = processScenarioFramework.updateProcessScenarioVariableService(processId,scenarioId,variableId,typeId,value);
        if (scenarioVariableWSDTO != null){
            scenarioVariableWSDTOS.add(scenarioVariableWSDTO);
        }

        response.setScenarioVariables(scenarioVariableWSDTOS);
        general.setOperation("updateProcessScenarioVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioVariableWSModel removeProcessScenarioVariable(long userId, String processId, String scenarioId, String variableId) {

        ProcessScenarioVariableWSModel response = new ProcessScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();

        ProcessScenarioVariableWSDTO scenarioVariableWSDTO = processScenarioFramework.removeProcessScenarioVariableService(processId,scenarioId,variableId);
        if (scenarioVariableWSDTO != null){
            scenarioVariableWSDTOS.add(scenarioVariableWSDTO);
        }

        response.setScenarioVariables(scenarioVariableWSDTOS);
        general.setOperation("removeProcessScenarioVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
