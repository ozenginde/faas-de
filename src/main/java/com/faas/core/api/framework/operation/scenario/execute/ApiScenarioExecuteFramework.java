package com.faas.core.api.framework.operation.scenario.execute;

import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiScenarioWSDTO;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioDetailsWSDTO;
import com.faas.core.api.model.ws.operation.scenario.execute.ApiScenarioExecuteWSModel;
import com.faas.core.api.model.ws.operation.scenario.execute.dto.ApiScenarioExecuteWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiScenarioExecuteFramework {

    @Autowired
    AppUtils appUtils;


    public List<ApiScenarioExecuteWSDTO> apiGetScenarioExecutesService(long agentId, long sessionId) {

        return null;
    }


    public ApiScenarioExecuteWSDTO apiGetScenarioExecuteService(long agentId, long sessionId) {

        return null;
    }


    public ApiScenarioExecuteWSDTO apiExecuteScenarioService(long agentId, long sessionId) {

        return null;
    }



}
