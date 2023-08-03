package com.faas.core.api.framework.operation.scenario.execution;

import com.faas.core.api.model.ws.operation.scenario.execution.dto.ApiScenarioExecutionWSDTO;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.scenario.ScenarioExecutionRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiScenarioExecutionFramework {


    @Autowired
    OperationMapper operationMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ScenarioExecutionRepository scenarioExecutionRepository;

    @Autowired
    AppUtils appUtils;


    public ApiScenarioExecutionWSDTO apiExecuteScenarioService(long agentId, long sessionId, long clientId, String scenarioId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);

        return null;
    }


    public List<ApiScenarioExecutionWSDTO> apiGetScenarioExecutionsService(long agentId, long sessionId, long clientId) {

        List<ApiScenarioExecutionWSDTO> scenarioExecutionWSDTOS = new ArrayList<>();

        return scenarioExecutionWSDTOS;
    }


    public ApiScenarioExecutionWSDTO apiGetScenarioExecutionService(long agentId, long sessionId, long clientId, String executionId) {


        return null;
    }


    public ApiScenarioExecutionWSDTO apiUpdateScenarioExecutionService(long agentId, long sessionId, long clientId, String executionId) {

        return null;
    }


    public ApiScenarioExecutionWSDTO apiRemoveScenarioExecutionService(long agentId, long sessionId, long clientId, String executionId) {


        return null;
    }


}
