package com.faas.core.base.framework.action.settings;

import com.faas.core.base.model.db.action.settings.ActionTypeDBModel;
import com.faas.core.base.model.ws.action.settings.dto.ActionTypeWSDTO;
import com.faas.core.base.repo.action.settings.ActionTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ActionSettingsFramework {

    @Autowired
    ActionTypeRepository actionTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ActionTypeWSDTO fillActionTypeWSDTO(ActionTypeDBModel actionTypeDBModel) {

        ActionTypeWSDTO actionTypeWSDTO = new ActionTypeWSDTO();
        actionTypeWSDTO.setActionType(actionTypeDBModel);
        return actionTypeWSDTO;
    }


    public ActionTypeDBModel createActionTypeService(String actionType) {

        ActionTypeDBModel actionTypeDBModel = new ActionTypeDBModel();
        actionTypeDBModel.setActionType(actionType);
        actionTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        actionTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        actionTypeDBModel.setStatus(1);

        return actionTypeRepository.save(actionTypeDBModel);
    }


    public ActionTypeDBModel updateActionTypeService(long typeId, String actionType) {

        Optional<ActionTypeDBModel> actionTypeDBModel = actionTypeRepository.findById(typeId);
        if (actionTypeDBModel.isPresent()) {
            actionTypeDBModel.get().setActionType(actionType);
            actionTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            actionTypeDBModel.get().setStatus(1);

            return actionTypeRepository.save(actionTypeDBModel.get());
        }
        return null;
    }


    public ActionTypeDBModel removeActionTypeService(long typeId) {

        Optional<ActionTypeDBModel> actionTypeDBModel = actionTypeRepository.findById(typeId);
        if (actionTypeDBModel.isPresent()) {
            actionTypeRepository.delete(actionTypeDBModel.get());
            return actionTypeDBModel.get();
        }
        return null;
    }




}
