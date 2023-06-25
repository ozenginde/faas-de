package com.faas.core.base.middleware.scenario.details.action.details;

import com.faas.core.base.framework.scenario.details.action.details.ActionDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.action.details.ActionDataWSModel;
import com.faas.core.base.model.ws.scenario.details.action.details.dto.ActionDataWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ActionDetailsMiddleware {


    @Autowired
    ActionDetailsFramework actionDetailsFramework;


    public ActionDataWSModel getActionDatas(long userId, String actionId) {

        ActionDataWSModel response = new ActionDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ActionDataWSDTO> actionDataWSDTOS = actionDetailsFramework.getActionDatasService(actionId);
        if (actionDataWSDTOS != null){
            response.setActionDatas(actionDataWSDTOS);
        }

        general.setOperation("getActionDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionDataWSModel getActionData(long userId, String actionId, String dataId) {

        ActionDataWSModel response = new ActionDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionDataWSDTO> actionDataWSDTOS = new ArrayList<>();

        ActionDataWSDTO actionDataWSDTO = actionDetailsFramework.getActionDataService(actionId,dataId);
        if (actionDataWSDTO != null){
            actionDataWSDTOS.add(actionDataWSDTO);
        }

        response.setActionDatas(actionDataWSDTOS);
        general.setOperation("getActionData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionDataWSModel createActionData(long userId, String actionId, long dataTypeId, String value) {

        ActionDataWSModel response = new ActionDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionDataWSDTO> actionDataWSDTOS = new ArrayList<>();

        ActionDataWSDTO actionDataWSDTO = actionDetailsFramework.createActionDataService(actionId,dataTypeId,value);
        if (actionDataWSDTO != null){
            actionDataWSDTOS.add(actionDataWSDTO);
        }

        response.setActionDatas(actionDataWSDTOS);
        general.setOperation("createActionData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ActionDataWSModel updateActionData(long userId, String actionId, String dataId, long dataTypeId, String value) {

        ActionDataWSModel response = new ActionDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionDataWSDTO> actionDataWSDTOS = new ArrayList<>();

        ActionDataWSDTO actionDataWSDTO = actionDetailsFramework.updateActionDataService(actionId,dataId,dataTypeId,value);
        if (actionDataWSDTO != null){
            actionDataWSDTOS.add(actionDataWSDTO);
        }

        response.setActionDatas(actionDataWSDTOS);
        general.setOperation("updateActionData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionDataWSModel removeActionData(long userId, String actionId, String dataId) {

        ActionDataWSModel response = new ActionDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionDataWSDTO> actionDataWSDTOS = new ArrayList<>();

        ActionDataWSDTO actionDataWSDTO = actionDetailsFramework.removeActionDataService(actionId,dataId);
        if (actionDataWSDTO != null){
            actionDataWSDTOS.add(actionDataWSDTO);
        }

        response.setActionDatas(actionDataWSDTOS);
        general.setOperation("removeActionData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
