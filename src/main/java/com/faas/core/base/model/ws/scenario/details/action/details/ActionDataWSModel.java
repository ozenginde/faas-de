package com.faas.core.base.model.ws.scenario.details.action.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.action.details.dto.ActionDataWSDTO;

import java.util.List;

public class ActionDataWSModel {

    private GeneralWSModel general;
    private List<ActionDataWSDTO>actionDatas;

    public ActionDataWSModel() {
    }

    public ActionDataWSModel(GeneralWSModel general, List<ActionDataWSDTO> actionDatas) {
        this.general = general;
        this.actionDatas = actionDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ActionDataWSDTO> getActionDatas() {
        return actionDatas;
    }

    public void setActionDatas(List<ActionDataWSDTO> actionDatas) {
        this.actionDatas = actionDatas;
    }
}
