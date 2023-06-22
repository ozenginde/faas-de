package com.faas.core.base.middleware.scenario.element.action.content;

import com.faas.core.base.framework.scenario.element.action.content.ActionElementFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.action.content.ActionElementWSModel;
import com.faas.core.base.model.ws.scenario.element.action.content.dto.ActionElementWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ActionElementMiddleware {


    @Autowired
    ActionElementFramework actionElementFramework;


    public ActionElementWSModel getScenarioActionElements(long userId, String scenarioId) {

        ActionElementWSModel response = new ActionElementWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ActionElementWSDTO> actionElementWSDTOS = actionElementFramework.getScenarioActionElementsService(scenarioId);
        if (actionElementWSDTOS != null){
            response.setActionElements(actionElementWSDTOS);
        }

        general.setOperation("getScenarioActionElements");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionElementWSModel getActionElement(long userId, String elementId) {

        ActionElementWSModel response = new ActionElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionElementWSDTO> actionElementWSDTOS = new ArrayList<>();

        ActionElementWSDTO actionElementWSDTO = actionElementFramework.getActionElementService(elementId);
        if (actionElementWSDTO != null){
            actionElementWSDTOS.add(actionElementWSDTO);
        }

        response.setActionElements(actionElementWSDTOS);
        general.setOperation("getActionElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionElementWSModel createActionElement(long userId,String scenarioId,String actionName,String actionDesc,long actionTempId,int order) {

        ActionElementWSModel response = new ActionElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionElementWSDTO> actionElementWSDTOS = new ArrayList<>();

        ActionElementWSDTO actionElementWSDTO = actionElementFramework.createActionElementService(scenarioId,actionName,actionDesc,actionTempId,order);
        if (actionElementWSDTO != null){
            actionElementWSDTOS.add(actionElementWSDTO);
        }

        response.setActionElements(actionElementWSDTOS);
        general.setOperation("createActionElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionElementWSModel updateActionElement(long userId,String elementId,String actionName,String actionDesc,long actionTempId,int order) {

        ActionElementWSModel response = new ActionElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionElementWSDTO> actionElementWSDTOS = new ArrayList<>();

        ActionElementWSDTO actionElementWSDTO = actionElementFramework.updateActionElementService(elementId,actionName,actionDesc,actionTempId,order);
        if (actionElementWSDTO != null){
            actionElementWSDTOS.add(actionElementWSDTO);
        }

        response.setActionElements(actionElementWSDTOS);
        general.setOperation("updateActionElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionElementWSModel removeActionElement(long userId, String elementId) {

        ActionElementWSModel response = new ActionElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionElementWSDTO> actionElementWSDTOS = new ArrayList<>();

        ActionElementWSDTO actionElementWSDTO = actionElementFramework.removeActionElementService(elementId);
        if (actionElementWSDTO != null){
            actionElementWSDTOS.add(actionElementWSDTO);
        }

        response.setActionElements(actionElementWSDTOS);
        general.setOperation("removeActionElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
