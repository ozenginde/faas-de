package com.faas.core.base.middleware.scenario.settings;

import com.faas.core.base.framework.scenario.settings.ScenarioSettingsFramework;
import com.faas.core.base.model.db.scenario.settings.ScenarioTypeDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.settings.ScenarioTypeWSModel;
import com.faas.core.base.model.ws.scenario.settings.dto.ScenarioTypeWSDTO;
import com.faas.core.base.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ScenarioSettingsMiddleware {

    @Autowired
    ScenarioSettingsFramework scenarioSettingsFramework;

    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ScenarioTypeWSModel getAllScenarioTypes(long userId) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        List<ScenarioTypeDBModel> scenarioTypeDBModels = scenarioTypeRepository.findByStatus(1);
        for (ScenarioTypeDBModel scenarioTypeDBModel : scenarioTypeDBModels) {
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel));
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("getAllScenarioTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel getScenarioType(long userId, long typeId) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
        if (scenarioTypeDBModel.isPresent()){
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel.get()));
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("getScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel createScenarioType(long userId,String scenarioType,String baseType) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        ScenarioTypeDBModel scenarioTypeDBModel = scenarioSettingsFramework.createScenarioTypeService(scenarioType,baseType);
        if (scenarioTypeDBModel != null){
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel));
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("createScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel updateScenarioType(long userId,long typeId,String scenarioType,String baseType) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        ScenarioTypeDBModel scenarioTypeDBModel = scenarioSettingsFramework.updateScenarioTypeService(typeId,scenarioType,baseType);
        if (scenarioTypeDBModel != null){
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel));
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("updateScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel removeScenarioType(long userId,long typeId) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        ScenarioTypeDBModel scenarioTypeDBModel = scenarioSettingsFramework.removeScenarioTypeService(typeId);
        if (scenarioTypeDBModel != null){
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel));
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("removeScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
