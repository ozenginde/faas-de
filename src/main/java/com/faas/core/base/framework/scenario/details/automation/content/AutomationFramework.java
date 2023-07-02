package com.faas.core.base.framework.scenario.details.automation.content;

import com.faas.core.base.model.db.scenario.automation.AutomationTempDBModel;
import com.faas.core.base.model.db.scenario.details.automation.AutomationDBModel;
import com.faas.core.base.model.ws.scenario.details.automation.content.dto.AutomationWSDTO;
import com.faas.core.base.repo.scenario.automation.AutomationTempRepository;
import com.faas.core.base.repo.scenario.details.automation.AutomationRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AutomationFramework {


    @Autowired
    AutomationRepository automationRepository;

    @Autowired
    AutomationTempRepository automationTempRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomationWSDTO> getScenarioAutomationsService(String scenarioId) {

        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();
        List<AutomationDBModel> automationDBModels = automationRepository.findByScenarioId(scenarioId);
        for (AutomationDBModel automationDBModel : automationDBModels) {
            automationWSDTOS.add(new AutomationWSDTO(automationDBModel));
        }
        return automationWSDTOS;
    }


    public AutomationWSDTO getAutomationService(String automationId) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent()){
            AutomationWSDTO automationWSDTO = new AutomationWSDTO();
            automationWSDTO.setAutomation(automationDBModel.get());
            return automationWSDTO;
        }
        return null;
    }


    public AutomationWSDTO createAutomationService(String scenarioId, String automation, String automationDesc, long automationTempId, int order) {

        Optional<AutomationTempDBModel> automationTempDBModel = automationTempRepository.findById(automationTempId);
        if (automationTempDBModel.isPresent()){

            AutomationDBModel automationDBModel = new AutomationDBModel();
            automationDBModel.setScenarioId(scenarioId);
            automationDBModel.setAutomation(automation);
            automationDBModel.setAutomationDesc(automationDesc);
            automationDBModel.setAutomationTempId(automationTempId);
            automationDBModel.setAutomationTemp(automationTempDBModel.get().getAutomationTemp());
            automationDBModel.setAutomationTypeId(automationTempDBModel.get().getTypeId());
            automationDBModel.setAutomationType(automationTempDBModel.get().getAutomationType());
            automationDBModel.setBaseType(automationTempDBModel.get().getBaseType());
            automationDBModel.setAutomationVariables(new ArrayList<>());
            automationDBModel.setOrder(order);
            automationDBModel.setuDate(appUtils.getCurrentTimeStamp());
            automationDBModel.setcDate(appUtils.getCurrentTimeStamp());
            automationDBModel.setStatus(1);

            return new AutomationWSDTO(automationRepository.save(automationDBModel));
        }
        return null;
    }


    public AutomationWSDTO updateAutomationService(String automationId, String automation, String automationDesc, long automationTempId, int order) {

        Optional<AutomationTempDBModel> automationTempDBModel = automationTempRepository.findById(automationTempId);
        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent() && automationTempDBModel.isPresent()){

            automationDBModel.get().setAutomation(automation);
            automationDBModel.get().setAutomationDesc(automationDesc);
            automationDBModel.get().setAutomationTempId(automationTempId);
            automationDBModel.get().setAutomationTemp(automationTempDBModel.get().getAutomationTemp());
            automationDBModel.get().setAutomationTypeId(automationTempDBModel.get().getTypeId());
            automationDBModel.get().setAutomationType(automationTempDBModel.get().getAutomationType());
            automationDBModel.get().setBaseType(automationTempDBModel.get().getBaseType());
            automationDBModel.get().setOrder(order);
            automationDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            automationDBModel.get().setStatus(1);

            return new AutomationWSDTO(automationRepository.save(automationDBModel.get()));
        }
        return null;
    }


    public AutomationWSDTO removeAutomationService(String automationId) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent()){
            automationRepository.delete(automationDBModel.get());
            return new AutomationWSDTO(automationDBModel.get());
        }
        return null;
    }




}
