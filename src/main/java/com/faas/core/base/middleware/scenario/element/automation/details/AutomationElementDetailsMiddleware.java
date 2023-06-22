package com.faas.core.base.middleware.scenario.element.automation.details;

import com.faas.core.base.framework.scenario.element.automation.details.AutomationElementDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.details.AutomationElementDataWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.details.dto.AutomationElementDataWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomationElementDetailsMiddleware {


    @Autowired
    AutomationElementDetailsFramework automationElementDetailsFramework;


    public AutomationElementDataWSModel getAutomationElementDatas(long userId,String elementId) {

        AutomationElementDataWSModel response = new AutomationElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomationElementDataWSDTO> elementDataWSDTOS = automationElementDetailsFramework.getAutomationElementDatasService(elementId);
        if (elementDataWSDTOS != null){
            response.setElementDatas(elementDataWSDTOS);
        }

        general.setOperation("getAutomationElementDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public AutomationElementDataWSModel getAutomationElementData(long userId, String elementId,String dataId) {

        AutomationElementDataWSModel response = new AutomationElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationElementDataWSDTO>elementDataWSDTOS = new ArrayList<>();

        AutomationElementDataWSDTO elementDataWSDTO = automationElementDetailsFramework.getAutomationElementDataService(elementId,dataId);
        if (elementDataWSDTO != null){
            elementDataWSDTOS.add(elementDataWSDTO);
        }

        response.setElementDatas(elementDataWSDTOS);
        general.setOperation("getAutomationElementData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationElementDataWSModel createAutomationElementData(long userId, String elementId,long dataTypeId,String value) {

        AutomationElementDataWSModel response = new AutomationElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationElementDataWSDTO>elementDataWSDTOS = new ArrayList<>();

        AutomationElementDataWSDTO elementDataWSDTO = automationElementDetailsFramework.createAutomationElementDataService(elementId,dataTypeId,value);
        if (elementDataWSDTO != null){
            elementDataWSDTOS.add(elementDataWSDTO);
        }

        response.setElementDatas(elementDataWSDTOS);
        general.setOperation("createAutomationElementData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public AutomationElementDataWSModel updateAutomationElementData(long userId, String elementId, String dataId, long dataTypeId, String value) {

        AutomationElementDataWSModel response = new AutomationElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationElementDataWSDTO>elementDataWSDTOS = new ArrayList<>();

        AutomationElementDataWSDTO elementDataWSDTO = automationElementDetailsFramework.updateAutomationElementDataService(elementId,dataId,dataTypeId,value);
        if (elementDataWSDTO != null){
            elementDataWSDTOS.add(elementDataWSDTO);
        }

        response.setElementDatas(elementDataWSDTOS);
        general.setOperation("updateAutomationElementData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationElementDataWSModel removeAutomationElementData(long userId, String elementId, String dataId) {

        AutomationElementDataWSModel response = new AutomationElementDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationElementDataWSDTO>elementDataWSDTOS = new ArrayList<>();

        AutomationElementDataWSDTO elementDataWSDTO = automationElementDetailsFramework.removeAutomationElementDataService(elementId,dataId);
        if (elementDataWSDTO != null){
            elementDataWSDTOS.add(elementDataWSDTO);
        }

        response.setElementDatas(elementDataWSDTOS);
        general.setOperation("removeAutomationElementData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
