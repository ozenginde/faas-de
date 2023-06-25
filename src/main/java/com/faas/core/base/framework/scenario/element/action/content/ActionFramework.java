package com.faas.core.base.framework.scenario.element.action.content;

import com.faas.core.base.model.db.action.content.ActionTempDBModel;
import com.faas.core.base.model.db.scenario.element.action.ActionDBModel;
import com.faas.core.base.model.ws.scenario.element.action.content.dto.ActionWSDTO;
import com.faas.core.base.repo.action.content.ActionTempRepository;
import com.faas.core.base.repo.scenario.element.action.ActionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ActionFramework {

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AppUtils appUtils;


    public List<ActionWSDTO> getScenarioActionsService(String scenarioId) {

        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();
        List<ActionDBModel> actionDBModels = actionRepository.findByScenarioId(scenarioId);
        for (ActionDBModel actionDBModel : actionDBModels) {
            actionWSDTOS.add(new ActionWSDTO(actionDBModel));
        }
        return actionWSDTOS;
    }


    public ActionWSDTO getActionService(String actionId) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent()){
            ActionWSDTO actionWSDTO = new ActionWSDTO();
            actionWSDTO.setAction(actionDBModel.get());
            return actionWSDTO;
        }
        return null;
    }


    public ActionWSDTO createActionService(String scenarioId, String action, String actionDesc, long actionTempId, int order) {

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(actionTempId);
        if (actionTempDBModel.isPresent()){

            ActionDBModel actionDBModel = new ActionDBModel();

            actionDBModel.setScenarioId(scenarioId);
            actionDBModel.setAction(action);
            actionDBModel.setActionDesc(actionDesc);
            actionDBModel.setActionTempId(actionTempId);
            actionDBModel.setActionTemp(actionTempDBModel.get().getActionTemp());
            actionDBModel.setActionTypeId(actionTempDBModel.get().getTypeId());
            actionDBModel.setActionType(actionTempDBModel.get().getActionType());
            actionDBModel.setActionVariables(new ArrayList<>());
            actionDBModel.setOrder(order);
            actionDBModel.setuDate(appUtils.getCurrentTimeStamp());
            actionDBModel.setcDate(appUtils.getCurrentTimeStamp());
            actionDBModel.setStatus(1);

            return new ActionWSDTO(actionRepository.save(actionDBModel));
        }
        return null;
    }


    public ActionWSDTO updateActionService(String actionId, String action, String actionDesc, long actionTempId, int order) {

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(actionTempId);
        Optional<ActionDBModel>actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent() && actionTempDBModel.isPresent()){

            actionDBModel.get().setAction(action);
            actionDBModel.get().setActionDesc(actionDesc);
            actionDBModel.get().setActionTempId(actionTempId);
            actionDBModel.get().setActionTemp(actionTempDBModel.get().getActionTemp());
            actionDBModel.get().setActionTypeId(actionTempDBModel.get().getTypeId());
            actionDBModel.get().setActionType(actionTempDBModel.get().getActionType());
            actionDBModel.get().setOrder(order);
            actionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            actionDBModel.get().setStatus(1);

            return new ActionWSDTO(actionRepository.save(actionDBModel.get()));

        }
        return null;
    }


    public ActionWSDTO removeActionService(String actionId) {

        Optional<ActionDBModel>actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent()){
            actionRepository.delete(actionDBModel.get());
            return new ActionWSDTO(actionDBModel.get());
        }
        return null;
    }



}
