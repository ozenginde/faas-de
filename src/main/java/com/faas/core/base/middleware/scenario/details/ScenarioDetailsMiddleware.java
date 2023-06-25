package com.faas.core.base.middleware.scenario.details;

import com.faas.core.base.framework.scenario.details.ScenarioDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.ScenarioDataWSModel;
import com.faas.core.base.model.ws.scenario.details.ScenarioElementWSModel;
import com.faas.core.base.model.ws.scenario.details.dto.ScenarioDataWSDTO;
import com.faas.core.base.model.ws.scenario.details.dto.ScenarioElementWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScenarioDetailsMiddleware {


    @Autowired
    ScenarioDetailsFramework scenarioDetailsFramework;



    public ScenarioElementWSModel getScenarioElements(long userId, String scenarioId) {

        ScenarioElementWSModel response = new ScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioElementWSDTO>scenarioElementWSDTOS = scenarioDetailsFramework.getScenarioElementsService(scenarioId);
        if (scenarioElementWSDTOS != null){
            response.setScenarioElements(scenarioElementWSDTOS);
        }

        general.setOperation("getScenarioElements");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioDataWSModel getScenarioDatas(long userId, String scenarioId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioDataWSDTO> scenarioDataWSDTOS = scenarioDetailsFramework.getScenarioDatasService(scenarioId);
        if (scenarioDataWSDTOS != null){
            response.setScenarioDatas(scenarioDataWSDTOS);
        }

        general.setOperation("getScenarioDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioDataWSModel getScenarioData(long userId,String scenarioId,String dataId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioDetailsFramework.getScenarioDataService(scenarioId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("getScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioDataWSModel createScenarioData(long userId,String scenarioId, long dataTypeId, String value) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioDetailsFramework.createScenarioDataService(scenarioId,dataTypeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("createScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioDataWSModel updateScenarioData(long userId,String scenarioId,String dataId, long dataTypeId, String value) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioDetailsFramework.updateScenarioDataService(scenarioId,dataId,dataTypeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("updateScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ScenarioDataWSModel removeScenarioData(long userId,String scenarioId, String dataId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioDetailsFramework.removeScenarioDataService(scenarioId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("removeScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
