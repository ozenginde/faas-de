package com.faas.core.base.framework.scenario.settings;

import com.faas.core.base.model.db.scenario.settings.ScenarioTypeDBModel;
import com.faas.core.base.model.ws.scenario.settings.dto.ScenarioTypeWSDTO;
import com.faas.core.base.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ScenarioSettingsFramework {


    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ScenarioTypeWSDTO fillScenarioTypeWSDTO(ScenarioTypeDBModel scenarioTypeDBModel) {

        ScenarioTypeWSDTO scenarioTypeWSDTO = new ScenarioTypeWSDTO();
        scenarioTypeWSDTO.setScenarioType(scenarioTypeDBModel);
        return scenarioTypeWSDTO;
    }


    public ScenarioTypeDBModel createScenarioTypeService(String scenarioType,String  baseType) {

        ScenarioTypeDBModel scenarioTypeDBModel = new ScenarioTypeDBModel();
        scenarioTypeDBModel.setScenarioType(scenarioType);
        scenarioTypeDBModel.setBaseType(baseType);
        scenarioTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        scenarioTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        scenarioTypeDBModel.setStatus(1);

        return scenarioTypeRepository.save(scenarioTypeDBModel);
    }


    public ScenarioTypeDBModel updateScenarioTypeService(long typeId,String scenarioType,String baseType) {

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
        if (scenarioTypeDBModel.isPresent()){
            scenarioTypeDBModel.get().setScenarioType(scenarioType);
            scenarioTypeDBModel.get().setBaseType(baseType);
            scenarioTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            scenarioTypeDBModel.get().setStatus(1);

            return scenarioTypeRepository.save(scenarioTypeDBModel.get());
        }
        return null;
    }


    public ScenarioTypeDBModel removeScenarioTypeService(long typeId) {

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
        if (scenarioTypeDBModel.isPresent()){
            scenarioTypeRepository.delete(scenarioTypeDBModel.get());
            return scenarioTypeDBModel.get();
        }
        return null;
    }




}
