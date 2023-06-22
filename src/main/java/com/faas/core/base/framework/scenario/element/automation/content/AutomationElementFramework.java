package com.faas.core.base.framework.scenario.element.automation.content;

import com.faas.core.base.model.db.automation.content.AutomationTempDBModel;
import com.faas.core.base.model.db.scenario.element.automation.AutomationElementDBModel;
import com.faas.core.base.model.ws.scenario.element.automation.content.dto.AutomationElementWSDTO;
import com.faas.core.base.repo.automation.content.AutomationTempRepository;
import com.faas.core.base.repo.scenario.element.automation.AutomationElementRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AutomationElementFramework {


    @Autowired
    AutomationElementRepository automationElementRepository;

    @Autowired
    AutomationTempRepository automationTempRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomationElementWSDTO> getScenarioAutomationElementsService(String scenarioId) {

        List<AutomationElementWSDTO> automationElementWSDTOS = new ArrayList<>();
        List<AutomationElementDBModel> automationElementDBModels = automationElementRepository.findByScenarioId(scenarioId);
        for (AutomationElementDBModel automationElementDBModel : automationElementDBModels) {
            automationElementWSDTOS.add(new AutomationElementWSDTO(automationElementDBModel));
        }
        return automationElementWSDTOS;
    }


    public AutomationElementWSDTO getAutomationElementService(String elementId) {

        Optional<AutomationElementDBModel> automationElementDBModel = automationElementRepository.findById(elementId);
        if (automationElementDBModel.isPresent()){
            AutomationElementWSDTO automationElementWSDTO = new AutomationElementWSDTO();
            automationElementWSDTO.setAutomationElement(automationElementDBModel.get());

            return automationElementWSDTO;
        }
        return null;
    }


    public AutomationElementWSDTO createAutomationElementService(String scenarioId,String automationName,String automationDesc,long automationTempId,int order) {

        Optional<AutomationTempDBModel> automationTempDBModel = automationTempRepository.findById(automationTempId);
        if (automationTempDBModel.isPresent()){

            AutomationElementDBModel automationElementDBModel = new AutomationElementDBModel();

            automationElementDBModel.setScenarioId(scenarioId);
            automationElementDBModel.setAutomationName(automationName);
            automationElementDBModel.setAutomationDesc(automationDesc);
            automationElementDBModel.setAutomationTempId(automationTempId);
            automationElementDBModel.setAutomationTemp(automationTempDBModel.get().getAutomationTemp());
            automationElementDBModel.setAutomationTypeId(automationTempDBModel.get().getTypeId());
            automationElementDBModel.setAutomationType(automationTempDBModel.get().getAutomationType());
            automationElementDBModel.setBaseType(automationTempDBModel.get().getBaseType());
            automationElementDBModel.setElementDatas(new ArrayList<>());
            automationElementDBModel.setOrder(order);
            automationElementDBModel.setuDate(appUtils.getCurrentTimeStamp());
            automationElementDBModel.setcDate(appUtils.getCurrentTimeStamp());
            automationElementDBModel.setStatus(1);

            return new AutomationElementWSDTO(automationElementRepository.save(automationElementDBModel));
        }
        return null;
    }


    public AutomationElementWSDTO updateAutomationElementService(String elementId,String automationName,String automationDesc,long automationTempId,int order) {

        Optional<AutomationTempDBModel> automationTempDBModel = automationTempRepository.findById(automationTempId);
        Optional<AutomationElementDBModel> automationElementDBModel = automationElementRepository.findById(elementId);
        if (automationElementDBModel.isPresent() && automationTempDBModel.isPresent()){

            automationElementDBModel.get().setAutomationName(automationName);
            automationElementDBModel.get().setAutomationDesc(automationDesc);
            automationElementDBModel.get().setAutomationTempId(automationTempId);
            automationElementDBModel.get().setAutomationTemp(automationTempDBModel.get().getAutomationTemp());
            automationElementDBModel.get().setAutomationTypeId(automationTempDBModel.get().getTypeId());
            automationElementDBModel.get().setAutomationType(automationTempDBModel.get().getAutomationType());
            automationElementDBModel.get().setBaseType(automationTempDBModel.get().getBaseType());
            automationElementDBModel.get().setOrder(order);
            automationElementDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            automationElementDBModel.get().setStatus(1);

            return new AutomationElementWSDTO(automationElementRepository.save(automationElementDBModel.get()));
        }
        return null;
    }


    public AutomationElementWSDTO removeAutomationElementService(String elementId) {

        Optional<AutomationElementDBModel> automationElementDBModel = automationElementRepository.findById(elementId);
        if (automationElementDBModel.isPresent()){
            automationElementRepository.delete(automationElementDBModel.get());
            return new AutomationElementWSDTO(automationElementDBModel.get());
        }
        return null;
    }




}
