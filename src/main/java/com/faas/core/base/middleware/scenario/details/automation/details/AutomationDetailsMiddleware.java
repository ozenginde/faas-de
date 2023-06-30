package com.faas.core.base.middleware.scenario.details.automation.details;

import com.faas.core.base.framework.scenario.details.automation.details.AutomationDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.automation.details.AutomationVariableWSModel;
import com.faas.core.base.model.ws.scenario.details.automation.details.dto.AutomationVariableWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomationDetailsMiddleware {


    @Autowired
    AutomationDetailsFramework automationDetailsFramework;


    public AutomationVariableWSModel getAutomationVariables(long userId, String automationId) {

        AutomationVariableWSModel response = new AutomationVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomationVariableWSDTO> automationVariableWSDTOS = automationDetailsFramework.getAutomationVariablesService(automationId);
        if (automationVariableWSDTOS != null){
            response.setAutomationVariables(automationVariableWSDTOS);
        }

        general.setOperation("getAutomationVariables");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationVariableWSModel getAutomationVariable(long userId, String automationId, String variableId) {

        AutomationVariableWSModel response = new AutomationVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationVariableWSDTO> automationVariableWSDTOS = new ArrayList<>();

        AutomationVariableWSDTO automationVariableWSDTO = automationDetailsFramework.getAutomationVariableService(automationId,variableId);
        if (automationVariableWSDTO != null){
            automationVariableWSDTOS.add(automationVariableWSDTO);
        }

        response.setAutomationVariables(automationVariableWSDTOS);
        general.setOperation("getAutomationVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationVariableWSModel createAutomationVariable(long userId, String automationId, long typeId, String value) {

        AutomationVariableWSModel response = new AutomationVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationVariableWSDTO> automationVariableWSDTOS = new ArrayList<>();

        AutomationVariableWSDTO automationVariableWSDTO = automationDetailsFramework.createAutomationVariableService(automationId,typeId,value);
        if (automationVariableWSDTO != null){
            automationVariableWSDTOS.add(automationVariableWSDTO);
        }

        response.setAutomationVariables(automationVariableWSDTOS);
        general.setOperation("createAutomationVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationVariableWSModel updateAutomationVariable(long userId,String automationId,String variableId,long typeId, String value) {

        AutomationVariableWSModel response = new AutomationVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationVariableWSDTO> automationVariableWSDTOS = new ArrayList<>();

        AutomationVariableWSDTO automationVariableWSDTO = automationDetailsFramework.updateAutomationVariableService(automationId,variableId,typeId,value);
        if (automationVariableWSDTO != null){
            automationVariableWSDTOS.add(automationVariableWSDTO);
        }

        response.setAutomationVariables(automationVariableWSDTOS);
        general.setOperation("updateAutomationVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationVariableWSModel removeAutomationVariable(long userId, String automationId, String variableId) {

        AutomationVariableWSModel response = new AutomationVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationVariableWSDTO> automationVariableWSDTOS = new ArrayList<>();

        AutomationVariableWSDTO automationVariableWSDTO = automationDetailsFramework.removeAutomationVariableService(automationId,variableId);
        if (automationVariableWSDTO != null){
            automationVariableWSDTOS.add(automationVariableWSDTO);
        }

        response.setAutomationVariables(automationVariableWSDTOS);
        general.setOperation("removeAutomationVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
