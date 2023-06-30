package com.faas.core.base.middleware.scenario.details.action.details;

import com.faas.core.base.framework.scenario.details.action.details.ActionDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.action.details.ActionVariableWSModel;
import com.faas.core.base.model.ws.scenario.details.action.details.dto.ActionVariableWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ActionDetailsMiddleware {


    @Autowired
    ActionDetailsFramework actionDetailsFramework;


    public ActionVariableWSModel getActionVariables(long userId, String actionId) {

        ActionVariableWSModel response = new ActionVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ActionVariableWSDTO> actionVariableWSDTOS = actionDetailsFramework.getActionVariablesService(actionId);
        if (actionVariableWSDTOS != null){
            response.setActionVariables(actionVariableWSDTOS);
        }

        general.setOperation("getActionVariables");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionVariableWSModel getActionVariable(long userId, String actionId, String variableId) {

        ActionVariableWSModel response = new ActionVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionVariableWSDTO> actionVariableWSDTOS = new ArrayList<>();

        ActionVariableWSDTO actionVariableWSDTO = actionDetailsFramework.getActionVariableService(actionId,variableId);
        if (actionVariableWSDTO != null){
            actionVariableWSDTOS.add(actionVariableWSDTO);
        }

        response.setActionVariables(actionVariableWSDTOS);
        general.setOperation("getActionVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionVariableWSModel createActionVariable(long userId, String actionId, long typeId, String value) {

        ActionVariableWSModel response = new ActionVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionVariableWSDTO> actionVariableWSDTOS = new ArrayList<>();

        ActionVariableWSDTO actionVariableWSDTO = actionDetailsFramework.createActionVariableService(actionId,typeId,value);
        if (actionVariableWSDTO != null){
            actionVariableWSDTOS.add(actionVariableWSDTO);
        }

        response.setActionVariables(actionVariableWSDTOS);
        general.setOperation("createActionVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ActionVariableWSModel updateActionVariable(long userId, String actionId, String variableId, long typeId, String value) {

        ActionVariableWSModel response = new ActionVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionVariableWSDTO> actionVariableWSDTOS = new ArrayList<>();

        ActionVariableWSDTO actionVariableWSDTO = actionDetailsFramework.updateActionVariableService(actionId,variableId,typeId,value);
        if (actionVariableWSDTO != null){
            actionVariableWSDTOS.add(actionVariableWSDTO);
        }

        response.setActionVariables(actionVariableWSDTOS);
        general.setOperation("updateActionData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionVariableWSModel removeActionVariable(long userId, String actionId, String variableId) {

        ActionVariableWSModel response = new ActionVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionVariableWSDTO> actionVariableWSDTOS = new ArrayList<>();

        ActionVariableWSDTO actionVariableWSDTO = actionDetailsFramework.removeActionVariableService(actionId,variableId);
        if (actionVariableWSDTO != null){
            actionVariableWSDTOS.add(actionVariableWSDTO);
        }

        response.setActionVariables(actionVariableWSDTOS);
        general.setOperation("removeActionVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
