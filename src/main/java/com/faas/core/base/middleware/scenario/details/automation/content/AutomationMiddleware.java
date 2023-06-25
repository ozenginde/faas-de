package com.faas.core.base.middleware.scenario.details.automation.content;

import com.faas.core.base.framework.scenario.details.automation.content.AutomationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.automation.content.AutomationWSModel;
import com.faas.core.base.model.ws.scenario.details.automation.content.dto.AutomationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomationMiddleware {


    @Autowired
    AutomationFramework automationFramework;


    public AutomationWSModel getScenarioAutomations(long userId, String scenarioId) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomationWSDTO> automationWSDTOS = automationFramework.getScenarioAutomationsService(scenarioId);
        if (automationWSDTOS != null){
            response.setAutomations(automationWSDTOS);
        }

        general.setOperation("getScenarioAutomations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationWSModel getAutomation(long userId, String automationId) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();

        AutomationWSDTO automationWSDTO = automationFramework.getAutomationService(automationId);
        if (automationWSDTO != null){
            automationWSDTOS.add(automationWSDTO);
        }

        response.setAutomations(automationWSDTOS);
        general.setOperation("getAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationWSModel createAutomation(long userId, String scenarioId, String automation, String automationDesc, long automationTempId, int order) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();

        AutomationWSDTO automationWSDTO = automationFramework.createAutomationService(scenarioId,automation,automationDesc,automationTempId,order);
        if (automationWSDTO != null){
            automationWSDTOS.add(automationWSDTO);
        }

        response.setAutomations(automationWSDTOS);
        general.setOperation("createAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationWSModel updateAutomation(long userId, String automationId, String automation, String automationDesc, long automationTempId, int order) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();

        AutomationWSDTO automationWSDTO = automationFramework.updateAutomationService(automationId,automation,automationDesc,automationTempId,order);
        if (automationWSDTO != null){
            automationWSDTOS.add(automationWSDTO);
        }

        response.setAutomations(automationWSDTOS);
        general.setOperation("updateAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationWSModel removeAutomation(long userId, String automationId) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();

        AutomationWSDTO automationWSDTO = automationFramework.removeAutomationService(automationId);
        if (automationWSDTO != null){
            automationWSDTOS.add(automationWSDTO);
        }

        response.setAutomations(automationWSDTOS);
        general.setOperation("removeAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
