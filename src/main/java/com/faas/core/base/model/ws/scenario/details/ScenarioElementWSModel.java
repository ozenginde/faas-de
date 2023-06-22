package com.faas.core.base.model.ws.scenario.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.dto.ScenarioElementWSDTO;

public class ScenarioElementWSModel {

    private GeneralWSModel general;
    private ScenarioElementWSDTO scenarioElement;

    public ScenarioElementWSModel() {
    }

    public ScenarioElementWSModel(GeneralWSModel general, ScenarioElementWSDTO scenarioElement) {
        this.general = general;
        this.scenarioElement = scenarioElement;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ScenarioElementWSDTO getScenarioElement() {
        return scenarioElement;
    }

    public void setScenarioElement(ScenarioElementWSDTO scenarioElement) {
        this.scenarioElement = scenarioElement;
    }
}
