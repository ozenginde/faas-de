package com.faas.core.api.framework.operation.scenario.execute;

import com.faas.core.api.model.ws.operation.scenario.execute.dto.ApiScenarioExecuteWSDTO;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.scenario.ScenarioExecuteRepository;
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
public class ApiScenarioExecuteFramework {


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
    ScenarioExecuteRepository scenarioExecuteRepository;

    @Autowired
    AppUtils appUtils;


    public ApiScenarioExecuteWSDTO apiExecuteScenarioService(long agentId, long sessionId, long clientId, String scenarioId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);

        return null;
    }


    public List<ApiScenarioExecuteWSDTO> apiGetScenarioExecutionsService(long agentId, long sessionId, long clientId) {

        List<ApiScenarioExecuteWSDTO> scenarioExecutionWSDTOS = new ArrayList<>();

        return scenarioExecutionWSDTOS;
    }


    public ApiScenarioExecuteWSDTO apiGetScenarioExecutionService(long agentId, long sessionId, long clientId, String executionId) {


        return null;
    }


    public ApiScenarioExecuteWSDTO apiUpdateScenarioExecutionService(long agentId, long sessionId, long clientId, String executionId) {

        return null;
    }


    public ApiScenarioExecuteWSDTO apiRemoveScenarioExecutionService(long agentId, long sessionId, long clientId, String executionId) {


        return null;
    }


}
