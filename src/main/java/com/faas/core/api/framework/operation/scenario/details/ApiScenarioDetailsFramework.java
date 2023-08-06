package com.faas.core.api.framework.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiActionWSDTO;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiAutomationWSDTO;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioDetailsWSDTO;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.repo.operation.scenario.ScenarioExecutionRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    ScenarioExecutionRepository scenarioExecutionRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public ApiScenarioDetailsWSDTO apiGetScenarioDetailsService(long agentId, long sessionId, String processId, String scenarioId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (scenarioDBModel.isPresent() && !processScenarioDBModels.isEmpty()){

            ApiScenarioDetailsWSDTO scenarioDetailsWSDTO = new ApiScenarioDetailsWSDTO();
            scenarioDetailsWSDTO.setScenario(scenarioDBModel.get());
            scenarioDetailsWSDTO.setProcessScenario(processScenarioDBModels.get(0));

            return scenarioDetailsWSDTO;
        }
        return null;
    }


    public List<ApiActionWSDTO> apiGetScenarioActionsService(long agentId, long sessionId, String scenarioId) {

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
