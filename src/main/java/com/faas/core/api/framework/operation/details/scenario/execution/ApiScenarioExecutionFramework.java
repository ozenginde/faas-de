package com.faas.core.api.framework.operation.details.scenario.execution;

import com.faas.core.api.model.ws.operation.details.scenario.execution.dto.ApiScenarioExecutionWSDTO;
import com.faas.core.base.model.db.operation.details.ScenarioExecutionDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.scenario.ScenarioExecutionRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
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


    public ApiScenarioExecutionWSDTO apiExecuteScenarioService(long agentId, long sessionId,long clientId,String scenarioId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (sessionDBModels.size()>0 && scenarioDBModel.isPresent()){

            ScenarioExecutionDBModel scenarioExecutionDBModel = new ScenarioExecutionDBModel();
            scenarioExecutionDBModel.setSessionId(sessionId);
            scenarioExecutionDBModel.setClientId(clientId);
            scenarioExecutionDBModel.setCampaignId(sessionDBModels.get(0).getCampaignId());
            scenarioExecutionDBModel.setProcessId(sessionDBModels.get(0).getProcessId());
            scenarioExecutionDBModel.setScenarioId(scenarioId);
            scenarioExecutionDBModel.setExecutionResults(new ArrayList<>());
            scenarioExecutionDBModel.setExecutionState(AppConstant.EXECUTION_READY);
            scenarioExecutionDBModel.setuDate(appUtils.getCurrentTimeStamp());
            scenarioExecutionDBModel.setcDate(appUtils.getCurrentTimeStamp());
            scenarioExecutionDBModel.setStatus(1);

            return operationMapper.mapApiScenarioExecutionWSDTO(scenarioExecutionRepository.save(scenarioExecutionDBModel));
        }
        return null;
    }


    public List<ApiScenarioExecutionWSDTO> apiGetScenarioExecutionsService(long agentId, long sessionId,long clientId) {

        List<ApiScenarioExecutionWSDTO> scenarioExecutionWSDTOS = new ArrayList<>();
        List<ScenarioExecutionDBModel> scenarioExecutionDBModels = scenarioExecutionRepository.findBySessionIdAndClientId(sessionId,clientId);
        for (ScenarioExecutionDBModel scenarioExecutionDBModel : scenarioExecutionDBModels) {
            scenarioExecutionWSDTOS.add(operationMapper.mapApiScenarioExecutionWSDTO(scenarioExecutionDBModel));
        }
        return scenarioExecutionWSDTOS;
    }


    public ApiScenarioExecutionWSDTO apiGetScenarioExecutionService(long agentId, long sessionId,long clientId,String executionId) {

        List<ScenarioExecutionDBModel> scenarioExecutionDBModels = scenarioExecutionRepository.findByIdAndSessionIdAndClientId(executionId,sessionId,clientId);
        for (ScenarioExecutionDBModel scenarioExecutionDBModel : scenarioExecutionDBModels) {
            return operationMapper.mapApiScenarioExecutionWSDTO(scenarioExecutionDBModel);
        }
        return null;
    }


    public ApiScenarioExecutionWSDTO apiUpdateScenarioExecutionService(long agentId,long sessionId,long clientId,String executionId) {

        return null;
    }


    public ApiScenarioExecutionWSDTO apiRemoveScenarioExecutionService(long agentId,long sessionId,long clientId,String executionId) {

        List<ScenarioExecutionDBModel> scenarioExecutionDBModels = scenarioExecutionRepository.findByIdAndSessionIdAndClientId(executionId,sessionId,clientId);
        if (scenarioExecutionDBModels.size()>0) {
            scenarioExecutionRepository.delete(scenarioExecutionDBModels.get(0));
            return operationMapper.mapApiScenarioExecutionWSDTO(scenarioExecutionDBModels.get(0));
        }
        return null;
    }


}
