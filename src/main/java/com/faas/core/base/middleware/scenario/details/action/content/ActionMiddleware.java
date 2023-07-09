package com.faas.core.base.middleware.scenario.details.action.content;

import com.faas.core.base.framework.scenario.details.action.content.ActionFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.action.content.ActionWSModel;
import com.faas.core.base.model.ws.scenario.details.action.content.dto.ActionWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ActionMiddleware {


    @Autowired
    ActionFramework actionFramework;


    public ActionWSModel getScenarioActions(long userId, String scenarioId) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ActionWSDTO> actionWSDTOS = actionFramework.getScenarioActionsService(scenarioId);
        if (actionWSDTOS != null){
            response.setActions(actionWSDTOS);
        }

        general.setOperation("getScenarioActions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionWSModel getAction(long userId, String actionId) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();

        ActionWSDTO actionWSDTO = actionFramework.getActionService(actionId);
        if (actionWSDTO != null){
            actionWSDTOS.add(actionWSDTO);
        }

        response.setActions(actionWSDTOS);
        general.setOperation("getAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionWSModel createAction(long userId, String scenarioId, String action, long actionTempId, int order) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();

        ActionWSDTO actionWSDTO = actionFramework.createActionService(scenarioId,action,actionTempId,order);
        if (actionWSDTO != null){
            actionWSDTOS.add(actionWSDTO);
        }

        response.setActions(actionWSDTOS);
        general.setOperation("createAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionWSModel updateAction(long userId, String actionId, String action, long actionTempId, int order) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();

        ActionWSDTO actionWSDTO = actionFramework.updateActionService(actionId,action,actionTempId,order);
        if (actionWSDTO != null){
            actionWSDTOS.add(actionWSDTO);
        }

        response.setActions(actionWSDTOS);
        general.setOperation("updateAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionWSModel removeAction(long userId, String actionId) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();

        ActionWSDTO actionWSDTO = actionFramework.removeActionService(actionId);
        if (actionWSDTO != null){
            actionWSDTOS.add(actionWSDTO);
        }

        response.setActions(actionWSDTOS);
        general.setOperation("removeAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
