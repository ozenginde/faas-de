package com.faas.core.base.model.ws.operation.details.scenario;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.scenario.dto.ScenarioExecuteWSDTO;

import java.util.List;

public class ScenarioExecuteWSModel {

    private GeneralWSModel general;
    private List<ScenarioExecuteWSDTO>scenarioExecutes;

    public ScenarioExecuteWSModel() {
    }

    public ScenarioExecuteWSModel(GeneralWSModel general, List<ScenarioExecuteWSDTO> scenarioExecutes) {
        this.general = general;
        this.scenarioExecutes = scenarioExecutes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ScenarioExecuteWSDTO> getScenarioExecutes() {
        return scenarioExecutes;
    }

    public void setScenarioExecutes(List<ScenarioExecuteWSDTO> scenarioExecutes) {
        this.scenarioExecutes = scenarioExecutes;
    }
}
