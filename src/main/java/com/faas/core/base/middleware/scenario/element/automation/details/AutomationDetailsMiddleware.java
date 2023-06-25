package com.faas.core.base.middleware.scenario.element.automation.details;

import com.faas.core.base.framework.scenario.element.automation.details.AutomationDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.details.AutomationDataWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.details.dto.AutomationDataWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomationDetailsMiddleware {


    @Autowired
    AutomationDetailsFramework automationDetailsFramework;


    public AutomationDataWSModel getAutomationDatas(long userId, String automationId) {

        AutomationDataWSModel response = new AutomationDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomationDataWSDTO> automationDataWSDTOS = automationDetailsFramework.getAutomationDatasService(automationId);
        if (automationDataWSDTOS != null){
            response.setAutomationDatas(automationDataWSDTOS);
        }

        general.setOperation("getAutomationDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public AutomationDataWSModel getAutomationData(long userId, String automationId, String dataId) {

        AutomationDataWSModel response = new AutomationDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationDataWSDTO>automationDataWSDTOS = new ArrayList<>();

        AutomationDataWSDTO automationDataWSDTO = automationDetailsFramework.getAutomationDataService(automationId,dataId);
        if (automationDataWSDTO != null){
            automationDataWSDTOS.add(automationDataWSDTO);
        }

        response.setAutomationDatas(automationDataWSDTOS);
        general.setOperation("getAutomationData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationDataWSModel createAutomationData(long userId, String automationId, long dataTypeId, String value) {

        AutomationDataWSModel response = new AutomationDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationDataWSDTO>automationDataWSDTOS = new ArrayList<>();

        AutomationDataWSDTO automationDataWSDTO = automationDetailsFramework.createAutomationDataService(automationId,dataTypeId,value);
        if (automationDataWSDTO != null){
            automationDataWSDTOS.add(automationDataWSDTO);
        }

        response.setAutomationDatas(automationDataWSDTOS);
        general.setOperation("createAutomationData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public AutomationDataWSModel updateAutomationData(long userId, String automationId, String dataId, long dataTypeId, String value) {

        AutomationDataWSModel response = new AutomationDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationDataWSDTO>automationDataWSDTOS = new ArrayList<>();

        AutomationDataWSDTO automationDataWSDTO = automationDetailsFramework.updateAutomationDataService(automationId,dataId,dataTypeId,value);
        if (automationDataWSDTO != null){
            automationDataWSDTOS.add(automationDataWSDTO);
        }

        response.setAutomationDatas(automationDataWSDTOS);
        general.setOperation("updateAutomationData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationDataWSModel removeAutomationData(long userId, String automationId, String dataId) {

        AutomationDataWSModel response = new AutomationDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationDataWSDTO>automationDataWSDTOS = new ArrayList<>();

        AutomationDataWSDTO automationDataWSDTO = automationDetailsFramework.removeAutomationDataService(automationId,dataId);
        if (automationDataWSDTO != null){
            automationDataWSDTOS.add(automationDataWSDTO);
        }

        response.setAutomationDatas(automationDataWSDTOS);
        general.setOperation("removeAutomationData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
