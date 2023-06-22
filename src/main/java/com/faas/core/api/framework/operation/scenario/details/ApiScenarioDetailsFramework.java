package com.faas.core.api.framework.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiScenarioWSDTO;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.repo.operation.scenario.ScenarioExecuteRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiScenarioDetailsFramework {


    @Autowired
    OperationMapper operationMapper;

    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ScenarioExecuteRepository scenarioExecuteRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId, long sessionId, long clientId, String processId) {

        return operationMapper.mapApiOperationScenarioWSDTO(sessionId,clientId,processId);
    }

    public List<ApiScenarioWSDTO> apiGetScenariosService(long agentId, long sessionId, long clientId, String processId) {

        List<ScenarioDBModel> scenarioDBModels = scenarioRepository.findByStatus(1);
        if (scenarioDBModels.size()>0){
            List<ApiScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();

            return scenarioWSDTOS;
        }
        return null;
    }

    public ApiScenarioWSDTO apiGetScenarioService(long agentId, long sessionId, long clientId, String scenarioId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);

        return null;
    }







}
