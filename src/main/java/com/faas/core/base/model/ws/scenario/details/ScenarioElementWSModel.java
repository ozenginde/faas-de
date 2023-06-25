package com.faas.core.base.model.ws.scenario.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.dto.ScenarioElementWSDTO;

import java.util.List;

public class ScenarioElementWSModel {

    private GeneralWSModel general;
    private List<ScenarioElementWSDTO> elements;

    public ScenarioElementWSModel() {
    }

    public ScenarioElementWSModel(GeneralWSModel general, List<ScenarioElementWSDTO> elements) {
        this.general = general;
        this.elements = elements;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ScenarioElementWSDTO> getElements() {
        return elements;
    }

    public void setElements(List<ScenarioElementWSDTO> elements) {
        this.elements = elements;
    }
}
