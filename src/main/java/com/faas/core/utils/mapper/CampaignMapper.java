package com.faas.core.utils.mapper;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignProcessWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.repo.automation.content.AutomationTempRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignMapper {


    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AutomationTempRepository automationTempRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;

    
    public CampaignAgentWSDTO mapCampaignAgentWSDTO(UserDBModel agentDBModel) {

        CampaignAgentWSDTO campaignAgentWSDTO = new CampaignAgentWSDTO();
        campaignAgentWSDTO.setCampaignAgent(agentDBModel);
        return campaignAgentWSDTO;
    }


    public CampaignAgentWSDTO createCampaignAgentWSDTO(CampaignAgentDBModel campaignAgentDBModel) {

        Optional<UserDBModel> agentDBModel = userRepository.findById(campaignAgentDBModel.getAgentId());
        if (agentDBModel.isPresent()){
            agentDBModel.get().setPassword("");
            return mapCampaignAgentWSDTO(agentDBModel.get());
        }
        return null;
    }

    public CampaignProcessWSDTO mapCampaignProcessWSDTO(ProcessDBModel processDBModel){

        CampaignProcessWSDTO campaignProcessWSDTO = new CampaignProcessWSDTO();
        List<ProcessScenarioWSDTO> processScenarioWSDTOS = new ArrayList<>();

        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processDBModel.getId());
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            processScenarioWSDTOS.add(mapProcessScenarioWSDTO(processScenarioDBModel));
        }
        campaignProcessWSDTO.setProcessScenarios(processScenarioWSDTOS);

        return campaignProcessWSDTO;
    }

    public ProcessScenarioWSDTO mapProcessScenarioWSDTO(ProcessScenarioDBModel processScenarioDBModel){

        ProcessScenarioWSDTO processScenarioWSDTO = new ProcessScenarioWSDTO();
        processScenarioWSDTO.setProcessScenario(processScenarioDBModel);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
        if (scenarioDBModel.isPresent()){
            processScenarioWSDTO.setProcessScenarioDetails(scenarioDBModel.get());
        }
        return processScenarioWSDTO;
    }


    public List<ApiSummaryWSDTO> mapCampaignSummary(long agentId){

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY, String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.TOTAL_SESSIONS_SUMMARY, String.valueOf(sessionRepository.countByAgentId(agentId))));

        return apiSummaryWSDTOS;
    }





}
