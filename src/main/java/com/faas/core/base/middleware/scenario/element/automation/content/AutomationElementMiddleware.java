package com.faas.core.base.middleware.scenario.element.automation.content;

import com.faas.core.base.framework.scenario.element.automation.content.AutomationElementFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.content.AutomationElementWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.content.dto.AutomationElementWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomationElementMiddleware {


    @Autowired
    AutomationElementFramework automationElementFramework;


    public AutomationElementWSModel getScenarioAutomationElements(long userId, String scenarioId) {

        AutomationElementWSModel response = new AutomationElementWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomationElementWSDTO> automationElementWSDTOS = automationElementFramework.getScenarioAutomationElementsService(scenarioId);
        if (automationElementWSDTOS != null){
            response.setAutomationElements(automationElementWSDTOS);
        }

        general.setOperation("getScenarioAutomationElements");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationElementWSModel getAutomationElement(long userId, String elementId) {

        AutomationElementWSModel response = new AutomationElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationElementWSDTO> automationElementWSDTOS = new ArrayList<>();

        AutomationElementWSDTO automationElementWSDTO = automationElementFramework.getAutomationElementService(elementId);
        if (automationElementWSDTO != null){
            automationElementWSDTOS.add(automationElementWSDTO);
        }

        response.setAutomationElements(automationElementWSDTOS);
        general.setOperation("getAutomationElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationElementWSModel createAutomationElement(long userId,String scenarioId,String automationName,String automationDesc,long automationTempId,int order) {

        AutomationElementWSModel response = new AutomationElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationElementWSDTO> automationElementWSDTOS = new ArrayList<>();

        AutomationElementWSDTO automationElementWSDTO = automationElementFramework.createAutomationElementService(scenarioId,automationName,automationDesc,automationTempId,order);
        if (automationElementWSDTO != null){
            automationElementWSDTOS.add(automationElementWSDTO);
        }

        response.setAutomationElements(automationElementWSDTOS);
        general.setOperation("createAutomationElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationElementWSModel updateAutomationElement(long userId,String elementId,String automationName,String automationDesc,long automationTempId,int order) {

        AutomationElementWSModel response = new AutomationElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationElementWSDTO> automationElementWSDTOS = new ArrayList<>();

        AutomationElementWSDTO automationElementWSDTO = automationElementFramework.updateAutomationElementService(elementId,automationName,automationDesc,automationTempId,order);
        if (automationElementWSDTO != null){
            automationElementWSDTOS.add(automationElementWSDTO);
        }

        response.setAutomationElements(automationElementWSDTOS);
        general.setOperation("updateAutomationElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationElementWSModel removeAutomationElement(long userId, String elementId) {

        AutomationElementWSModel response = new AutomationElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationElementWSDTO> automationElementWSDTOS = new ArrayList<>();

        AutomationElementWSDTO automationElementWSDTO = automationElementFramework.removeAutomationElementService(elementId);
        if (automationElementWSDTO != null){
            automationElementWSDTOS.add(automationElementWSDTO);
        }

        response.setAutomationElements(automationElementWSDTOS);
        general.setOperation("removeAutomationElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
