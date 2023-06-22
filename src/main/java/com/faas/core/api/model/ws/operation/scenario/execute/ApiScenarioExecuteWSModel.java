package com.faas.core.api.model.ws.operation.scenario.execute;

import com.faas.core.api.model.ws.operation.scenario.execute.dto.ApiScenarioExecuteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiScenarioExecuteWSModel {

    private GeneralWSModel general;
    private List<ApiScenarioExecuteWSDTO>scenarioExecutes;


    public ApiScenarioExecuteWSModel() {
    }

    public ApiScenarioExecuteWSModel(GeneralWSModel general, List<ApiScenarioExecuteWSDTO> scenarioExecutes) {
        this.general = general;
        this.scenarioExecutes = scenarioExecutes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiScenarioExecuteWSDTO> getScenarioExecutes() {
        return scenarioExecutes;
    }

    public void setScenarioExecutes(List<ApiScenarioExecuteWSDTO> scenarioExecutes) {
        this.scenarioExecutes = scenarioExecutes;
    }
}
