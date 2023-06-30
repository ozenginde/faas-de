package com.faas.core.base.model.ws.process.details.scenario;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioVariableWSDTO;

import java.util.List;

public class ProcessScenarioVariableWSModel {

    private GeneralWSModel general;
    private List<ProcessScenarioVariableWSDTO>scenarioVariables;

    public ProcessScenarioVariableWSModel() {
    }

    public ProcessScenarioVariableWSModel(GeneralWSModel general, List<ProcessScenarioVariableWSDTO> scenarioVariables) {
        this.general = general;
        this.scenarioVariables = scenarioVariables;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessScenarioVariableWSDTO> getScenarioVariables() {
        return scenarioVariables;
    }

    public void setScenarioVariables(List<ProcessScenarioVariableWSDTO> scenarioVariables) {
        this.scenarioVariables = scenarioVariables;
    }
}
