package com.faas.core.api.framework.operation.scenario.content;

import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiActionWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiAutomationWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiScenarioDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiScenarioDetailsFramework {

    @Autowired
    AppUtils appUtils;


    public ApiScenarioDetailsWSDTO apiGetScenarioDetailsService(long agentId, long sessionId,String scenarioId) {

        return null;
    }


    public List<ApiActionWSDTO> apiGetScenarioActionsService(long agentId,long sessionId,String scenarioId) {

        return null;
    }

    public ApiActionWSDTO apiGetScenarioActionService(long agentId, long sessionId, String scenarioId) {


        return null;
    }


    public List<ApiAutomationWSDTO> apiGetScenarioAutomationsService(long agentId, long sessionId, String scenarioId) {


        return null;
    }


    public ApiAutomationWSDTO apiGetScenarioAutomationService(long agentId, long sessionId, String scenarioId) {


        return null;
    }



}
