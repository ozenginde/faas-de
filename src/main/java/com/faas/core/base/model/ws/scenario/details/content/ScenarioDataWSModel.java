package com.faas.core.base.model.ws.scenario.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.content.dto.ScenarioDataWSDTO;

import java.util.List;

public class ScenarioDataWSModel {

    private GeneralWSModel general;
    private List<ScenarioDataWSDTO> scenarioDatas;

    public ScenarioDataWSModel() {
    }

    public ScenarioDataWSModel(GeneralWSModel general, List<ScenarioDataWSDTO> scenarioDatas) {
        this.general = general;
        this.scenarioDatas = scenarioDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ScenarioDataWSDTO> getScenarioDatas() {
        return scenarioDatas;
    }

    public void setScenarioDatas(List<ScenarioDataWSDTO> scenarioDatas) {
        this.scenarioDatas = scenarioDatas;
    }
}
