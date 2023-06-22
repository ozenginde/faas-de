package com.faas.core.base.middleware.scenario.element.action.details;

import com.faas.core.base.framework.scenario.element.action.details.ActionElementDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.action.details.ActionElementDataWSModel;
import com.faas.core.base.model.ws.scenario.element.action.details.dto.ActionElementDataWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ActionElementDetailsMiddleware {


    @Autowired
    ActionElementDetailsFramework actionElementDetailsFramework;


    public ActionElementDataWSModel getActionElementDatas(long userId,String elementId) {

        ActionElementDataWSModel response = new ActionElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ActionElementDataWSDTO> elementDataWSDTOS = actionElementDetailsFramework.getActionElementDatasService(elementId);
        if (elementDataWSDTOS != null){
            response.setElementDatas(elementDataWSDTOS);
        }

        general.setOperation("getActionElementDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionElementDataWSModel getActionElementData(long userId, String elementId,String dataId) {

        ActionElementDataWSModel response = new ActionElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionElementDataWSDTO> elementDataWSDTOS = new ArrayList<>();

        ActionElementDataWSDTO elementDataWSDTO = actionElementDetailsFramework.getActionElementDataService(elementId,dataId);
        if (elementDataWSDTO != null){
            elementDataWSDTOS.add(elementDataWSDTO);
        }

        response.setElementDatas(elementDataWSDTOS);
        general.setOperation("getActionElementData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionElementDataWSModel createActionElementData(long userId, String elementId,long dataTypeId,String value) {

        ActionElementDataWSModel response = new ActionElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionElementDataWSDTO> elementDataWSDTOS = new ArrayList<>();

        ActionElementDataWSDTO elementDataWSDTO = actionElementDetailsFramework.createActionElementDataService(elementId,dataTypeId,value);
        if (elementDataWSDTO != null){
            elementDataWSDTOS.add(elementDataWSDTO);
        }

        response.setElementDatas(elementDataWSDTOS);
        general.setOperation("createActionElementData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ActionElementDataWSModel updateActionElementData(long userId, String elementId,String dataId,long dataTypeId,String value) {

        ActionElementDataWSModel response = new ActionElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionElementDataWSDTO> elementDataWSDTOS = new ArrayList<>();

        ActionElementDataWSDTO elementDataWSDTO = actionElementDetailsFramework.updateActionElementDataService(elementId,dataId,dataTypeId,value);
        if (elementDataWSDTO != null){
            elementDataWSDTOS.add(elementDataWSDTO);
        }

        response.setElementDatas(elementDataWSDTOS);
        general.setOperation("updateActionElementData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionElementDataWSModel removeActionElementData(long userId, String elementId,String dataId) {

        ActionElementDataWSModel response = new ActionElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionElementDataWSDTO> elementDataWSDTOS = new ArrayList<>();

        ActionElementDataWSDTO elementDataWSDTO = actionElementDetailsFramework.removeActionElementDataService(elementId,dataId);
        if (elementDataWSDTO != null){
            elementDataWSDTOS.add(elementDataWSDTO);
        }

        response.setElementDatas(elementDataWSDTOS);
        general.setOperation("removeActionElementData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
