package com.faas.core.base.middleware.action.settings;

import com.faas.core.base.framework.action.settings.ActionSettingsFramework;
import com.faas.core.base.model.db.action.settings.ActionTypeDBModel;
import com.faas.core.base.model.ws.action.settings.ActionTypeWSModel;
import com.faas.core.base.model.ws.action.settings.dto.ActionTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.action.settings.ActionTypeRepository;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ActionSettingsMiddleware {


    @Autowired
    ActionSettingsFramework actionSettingsFramework;

    @Autowired
    ActionTypeRepository actionTypeRepository;


    public ActionTypeWSModel getActionTypes(long userId) {

        ActionTypeWSModel response = new ActionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTypeWSDTO> actionTypeWSDTOS = new ArrayList<>();

        List<ActionTypeDBModel> actionTypeDBModels = actionTypeRepository.findByStatus(1);
        for (ActionTypeDBModel actionTypeDBModel : actionTypeDBModels) {
            actionTypeWSDTOS.add(actionSettingsFramework.fillActionTypeWSDTO(actionTypeDBModel));
        }

        response.setActionTypes(actionTypeWSDTOS);
        general.setOperation("getAllActionTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ActionTypeWSModel getActionType(long userId,long typeId) {

        ActionTypeWSModel response = new ActionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTypeWSDTO> actionTypeWSDTOS = new ArrayList<>();

        Optional<ActionTypeDBModel> actionTypeDBModel = actionTypeRepository.findById(typeId);
        if (actionTypeDBModel.isPresent()) {
            actionTypeWSDTOS.add(actionSettingsFramework.fillActionTypeWSDTO(actionTypeDBModel.get()));
        }

        response.setActionTypes(actionTypeWSDTOS);
        general.setOperation("getActionType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionTypeWSModel createActionType(long userId,String actionType) {

        ActionTypeWSModel response = new ActionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTypeWSDTO> actionTypeWSDTOS = new ArrayList<>();

        ActionTypeDBModel actionTypeDBModel = actionSettingsFramework.createActionTypeService(actionType);
        if (actionTypeDBModel != null) {
            actionTypeWSDTOS.add(actionSettingsFramework.fillActionTypeWSDTO(actionTypeDBModel));
        }

        response.setActionTypes(actionTypeWSDTOS);
        general.setOperation("createActionType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionTypeWSModel updateActionType(long userId,long typeId,String actionType) {

        ActionTypeWSModel response = new ActionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTypeWSDTO> actionTypeWSDTOS = new ArrayList<>();

        ActionTypeDBModel actionTypeDBModel = actionSettingsFramework.updateActionTypeService(typeId,actionType);
        if (actionTypeDBModel != null) {
            actionTypeWSDTOS.add(actionSettingsFramework.fillActionTypeWSDTO(actionTypeDBModel));
        }

        response.setActionTypes(actionTypeWSDTOS);
        general.setOperation("updateActionType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionTypeWSModel removeActionType(long userId, long typeId) {

        ActionTypeWSModel response = new ActionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTypeWSDTO> actionTypeWSDTOS = new ArrayList<>();

        ActionTypeDBModel actionTypeDBModel = actionSettingsFramework.removeActionTypeService(typeId);
        if (actionTypeDBModel != null) {
            actionTypeWSDTOS.add(actionSettingsFramework.fillActionTypeWSDTO(actionTypeDBModel));
        }

        response.setActionTypes(actionTypeWSDTOS);
        general.setOperation("removeActionType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
