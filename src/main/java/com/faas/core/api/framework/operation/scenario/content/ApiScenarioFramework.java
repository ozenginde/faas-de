package com.faas.core.api.framework.operation.scenario.content;

import com.faas.core.api.model.ws.operation.scenario.content.dto.*;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.operation.scenario.ScenarioExecutionRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
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
public class ApiScenarioFramework {


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


    public ApiOperationScenarioWSDTO apiGetOperationScenarioService(long agentId,long sessionId,String processId) {
        return operationMapper.mapApiOperationScenarioWSDTO(sessionId,processId);
    }


    public List<ApiScenarioWSDTO> apiGetScenariosService(long agentId,long sessionId,String processId) {

        List<ApiScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processId);
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
            if (scenarioDBModel.isPresent()) {
                scenarioWSDTOS.add(new ApiScenarioWSDTO(scenarioDBModel.get(), processScenarioDBModel));
            }
        }
        return scenarioWSDTOS;
    }


    public ApiScenarioWSDTO apiGetScenarioService(long agentId,long sessionId,String processId,String scenarioId) {

        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (!processScenarioDBModels.isEmpty() && scenarioDBModel.isPresent()){
            return new ApiScenarioWSDTO(scenarioDBModel.get(),processScenarioDBModels.get(0));
        }
        return null;
    }


    public ApiScenarioDetailsWSDTO apiGetScenarioDetailsService(long agentId, long sessionId, String processId, String scenarioId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (scenarioDBModel.isPresent() && !processScenarioDBModels.isEmpty()){
            return new ApiScenarioDetailsWSDTO(scenarioDBModel.get(),processScenarioDBModels.get(0));
        }
        return null;
    }


    public List<ApiScenarioElementWSDTO> apiGetScenarioElementsService(long agentId, long sessionId, String scenarioId) {

        return null;
    }


    public ApiScenarioElementWSDTO apiGetScenarioElementService(long agentId, long sessionId, String scenarioId) {

        return null;
    }




}
