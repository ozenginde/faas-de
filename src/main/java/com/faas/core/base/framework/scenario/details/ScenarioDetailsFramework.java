package com.faas.core.base.framework.scenario.details;

import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;
import com.faas.core.base.model.db.scenario.element.action.ActionElementDBModel;
import com.faas.core.base.model.db.scenario.element.automation.AutomationElementDBModel;
import com.faas.core.base.model.db.utils.variables.DataTypeDBModel;
import com.faas.core.base.model.ws.scenario.details.dto.ScenarioDataWSDTO;
import com.faas.core.base.model.ws.scenario.details.dto.ScenarioElementWSDTO;
import com.faas.core.base.model.ws.scenario.element.action.content.dto.ActionElementWSDTO;
import com.faas.core.base.model.ws.scenario.element.automation.content.dto.AutomationElementWSDTO;
import com.faas.core.base.repo.action.content.ActionTempRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.scenario.element.action.ActionElementRepository;
import com.faas.core.base.repo.scenario.element.automation.AutomationElementRepository;
import com.faas.core.base.repo.utils.variables.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ScenarioDetailsFramework {

    @Autowired
    ActionElementRepository actionElementRepository;

    @Autowired
    AutomationElementRepository automationElementRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AppUtils appUtils;


    public ScenarioElementWSDTO getScenarioElementService(String scenarioId) {

        ScenarioElementWSDTO scenarioElementWSDTO = new ScenarioElementWSDTO();
        List<ActionElementWSDTO>actionElementWSDTOS = new ArrayList<>();
        List<AutomationElementWSDTO> automationElementWSDTOS = new ArrayList<>();
        List<ActionElementDBModel> actionElementDBModels = actionElementRepository.findByScenarioId(scenarioId);
        for (ActionElementDBModel actionElementDBModel : actionElementDBModels) {
            actionElementWSDTOS.add(new ActionElementWSDTO(actionElementDBModel));
        }
        scenarioElementWSDTO.setActionElements(actionElementWSDTOS);
        List<AutomationElementDBModel> automationElementDBModels = automationElementRepository.findByScenarioId(scenarioId);
        for (AutomationElementDBModel automationElementDBModel : automationElementDBModels) {
            automationElementWSDTOS.add(new AutomationElementWSDTO(automationElementDBModel));
        }
        scenarioElementWSDTO.setAutomationElements(automationElementWSDTOS);

        return scenarioElementWSDTO;
    }


    public ScenarioDataWSDTO fillScenarioDataWSDTO(ScenarioDataDAO scenarioDataDAO) {

        ScenarioDataWSDTO scenarioDataWSDTO = new ScenarioDataWSDTO();
        scenarioDataWSDTO.setScenarioData(scenarioDataDAO);
        return scenarioDataWSDTO;
    }


    public List<ScenarioDataWSDTO> getScenarioDatasService(String scenarioId) {

        List<ScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioDatas() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioDatas().size();i++){
                scenarioDataWSDTOS.add(fillScenarioDataWSDTO(scenarioDBModel.get().getScenarioDatas().get(i)));
            }
        }
        return scenarioDataWSDTOS;
    }


    public ScenarioDataWSDTO getScenarioDataService(String scenarioId,String dataId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioDatas() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioDatas().size();i++){
                if (scenarioDBModel.get().getScenarioDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return fillScenarioDataWSDTO(scenarioDBModel.get().getScenarioDatas().get(i));
                }
            }
        }
        return null;
    }


    public ScenarioDataWSDTO createScenarioDataService(String scenarioId, long dataTypeId, String value) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (scenarioDBModel.isPresent() && dataTypeDBModel.isPresent()){

            ScenarioDataDAO scenarioDataDAO = new ScenarioDataDAO();
            scenarioDataDAO.setDataId(appUtils.generateUUID());
            scenarioDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            scenarioDataDAO.setValue(value);
            scenarioDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            scenarioDataDAO.setStatus(1);

            if (scenarioDBModel.get().getScenarioDatas() == null){
                List<ScenarioDataDAO> scenarioDataDAOS = new ArrayList<>();
                scenarioDataDAOS.add(scenarioDataDAO);
                scenarioDBModel.get().setScenarioDatas(scenarioDataDAOS);
            }else {
                scenarioDBModel.get().getScenarioDatas().add(scenarioDataDAO);
            }

            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            scenarioRepository.save(scenarioDBModel.get());

            return fillScenarioDataWSDTO(scenarioDataDAO);
        }
        return null;
    }


    public ScenarioDataWSDTO updateScenarioDataService(String scenarioId,String dataId, long dataTypeId, String value) {

        return null;
    }


    public ScenarioDataWSDTO removeScenarioDataService(String scenarioId, String dataId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioDatas() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioDatas().size();i++){
                if (scenarioDBModel.get().getScenarioDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    ScenarioDataDAO scenarioDataDAO = scenarioDBModel.get().getScenarioDatas().get(i);
                    scenarioDBModel.get().getScenarioDatas().remove(scenarioDataDAO);
                    scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioRepository.save(scenarioDBModel.get());

                    return fillScenarioDataWSDTO(scenarioDataDAO);
                }
            }
        }
        return null;
    }





}
