package com.faas.core.api.framework.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioActionWSDTO;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioAutomationWSDTO;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioDetailsWSDTO;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.scenario.details.action.ActionRepository;
import com.faas.core.base.repo.scenario.details.automation.AutomationRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiScenarioDetailsFramework {


    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    AutomationRepository automationRepository;

    @Autowired
    AppUtils appUtils;


    public ApiScenarioDetailsWSDTO apiGetScenarioDetailsService(long agentId, long sessionId, long clientId, String processId) {



        return null;
    }


    public List<ApiScenarioActionWSDTO> apiGetScenarioActionsService(long agentId, long sessionId, long clientId, String processId) {

        return null;
    }

    public ApiScenarioActionWSDTO apiGetScenarioActionService(long agentId, long sessionId, long clientId, String scenarioId) {


        return null;
    }


    public List<ApiScenarioAutomationWSDTO> apiGetScenarioAutomationsService(long agentId, long sessionId, long clientId, String scenarioId) {


        return null;
    }


    public ApiScenarioAutomationWSDTO apiGetScenarioAutomationService(long agentId, long sessionId, long clientId, String scenarioId) {


        return null;
    }




}
