package com.faas.core.base.framework.scenario.details.content;

import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;
import com.faas.core.base.model.db.scenario.details.action.ActionDBModel;
import com.faas.core.base.model.db.scenario.details.automation.AutomationDBModel;
import com.faas.core.base.model.db.utils.variables.DataTypeDBModel;
import com.faas.core.base.model.ws.scenario.details.content.dto.ScenarioDataWSDTO;
import com.faas.core.base.model.ws.scenario.details.content.dto.ScenarioDetailsWSDTO;
import com.faas.core.base.model.ws.scenario.details.action.content.dto.ActionWSDTO;
import com.faas.core.base.model.ws.scenario.details.automation.content.dto.AutomationWSDTO;
import com.faas.core.base.repo.action.content.ActionTempRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.scenario.details.action.ActionRepository;
import com.faas.core.base.repo.scenario.details.automation.AutomationRepository;
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
    ActionRepository actionRepository;

    @Autowired
    AutomationRepository automationRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AppUtils appUtils;


    public ScenarioDetailsWSDTO getScenarioDetailsService(String scenarioId) {

        ScenarioDetailsWSDTO scenarioDetailsWSDTO = new ScenarioDetailsWSDTO();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();
        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();
        List<ActionDBModel> actionDBModels = actionRepository.findByScenarioId(scenarioId);
        for (ActionDBModel actionDBModel : actionDBModels) {
            actionWSDTOS.add(new ActionWSDTO(actionDBModel));
        }
        scenarioDetailsWSDTO.setScenarioActions(actionWSDTOS);
        List<AutomationDBModel> automationDBModels = automationRepository.findByScenarioId(scenarioId);
        for (AutomationDBModel automationDBModel : automationDBModels) {
            automationWSDTOS.add(new AutomationWSDTO(automationDBModel));
        }
        scenarioDetailsWSDTO.setScenarioAutomations(automationWSDTOS);

        return scenarioDetailsWSDTO;
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
