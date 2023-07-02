package com.faas.core.base.framework.scenario.action;

import com.faas.core.base.model.db.scenario.action.ActionTempDBModel;
import com.faas.core.base.model.db.scenario.settings.ActionTypeDBModel;
import com.faas.core.base.model.ws.scenario.action.dto.ActionTempWSDTO;
import com.faas.core.base.repo.scenario.action.ActionTempRepository;
import com.faas.core.base.repo.scenario.settings.ActionTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ActionTempFramework {

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    ActionTypeRepository actionTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ActionTempWSDTO fillActionTempWSDTO(ActionTempDBModel actionTempDBModel) {

        ActionTempWSDTO actionTempWSDTO = new ActionTempWSDTO();
        actionTempWSDTO.setActionTemp(actionTempDBModel);
        return actionTempWSDTO;
    }


    public ActionTempDBModel createActionTempService(String actionTemp, long typeId) {

        ActionTempDBModel actionTempDBModel = new ActionTempDBModel();
        actionTempDBModel.setActionTemp(actionTemp);
        Optional<ActionTypeDBModel> actionTypeDBModel = actionTypeRepository.findById(typeId);
        if (actionTypeDBModel.isPresent()){
            actionTempDBModel.setTypeId(typeId);
            actionTempDBModel.setActionType(actionTypeDBModel.get().getActionType());
        }
        actionTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
        actionTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
        actionTempDBModel.setStatus(1);

        return actionTempRepository.save(actionTempDBModel);
    }


    public ActionTempDBModel updateActionTempService(long tempId, String actionTemp, long typeId) {

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(tempId);
        if (actionTempDBModel.isPresent()){
            actionTempDBModel.get().setActionTemp(actionTemp);
            Optional<ActionTypeDBModel> actionTypeDBModel = actionTypeRepository.findById(typeId);
            if (actionTypeDBModel.isPresent()){
                actionTempDBModel.get().setTypeId(typeId);
                actionTempDBModel.get().setActionType(actionTypeDBModel.get().getActionType());
            }
            actionTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            actionTempDBModel.get().setStatus(1);

            return actionTempRepository.save(actionTempDBModel.get());
        }
        return null;
    }


    public ActionTempDBModel removeActionTempService(long tempId) {

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(tempId);
        if (actionTempDBModel.isPresent()){
            actionTempRepository.delete(actionTempDBModel.get());
            return actionTempDBModel.get();
        }
        return null;
    }



}
