package com.faas.core.api.framework.operation.details.scenario.execution;

import com.faas.core.api.model.ws.operation.details.scenario.execution.dto.ApiScenarioExecutionWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiScenarioExecutionFramework {


    @Autowired
    AppUtils appUtils;


    public ApiScenarioExecutionWSDTO apiExecuteScenarioService(long agentId, long sessionId,long clientId,String scenarioId) {

        return null;
    }

    public List<ApiScenarioExecutionWSDTO> apiGetScenarioExecutionsService(long agentId, long sessionId,long clientId) {

        return null;
    }

    public ApiScenarioExecutionWSDTO apiGetScenarioExecutionService(long agentId, long sessionId,long clientId,String executionId) {

        return null;
    }

    public ApiScenarioExecutionWSDTO apiUpdateScenarioExecutionService(long agentId,long sessionId,long clientId,String executionId) {

        return null;
    }

    public ApiScenarioExecutionWSDTO apiRemoveScenarioExecutionService(long agentId,long sessionId,long clientId,String executionId) {

        return null;
    }



}
