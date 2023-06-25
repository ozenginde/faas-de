package com.faas.core.base.framework.scenario.element.action.details;

import com.faas.core.base.model.db.scenario.element.action.ActionDBModel;
import com.faas.core.base.model.db.scenario.element.action.dao.ActionVariableDAO;
import com.faas.core.base.model.db.scenario.settings.VariableTypeDBModel;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.scenario.element.action.details.dto.ActionVariableWSDTO;
import com.faas.core.base.repo.scenario.element.action.ActionRepository;
import com.faas.core.base.repo.scenario.settings.VariableTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ActionDetailsFramework {


    @Autowired
    ActionRepository actionRepository;

    @Autowired
    VariableTypeRepository variableTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ActionVariableWSDTO> getActionVariablesService(String actionId) {

        List<ActionVariableWSDTO> actionVariableWSDTOS = new ArrayList<>();
        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent() && actionDBModel.get().getActionVariables() != null) {
            for (int i = 0; i < actionDBModel.get().getActionVariables().size(); i++) {
                actionVariableWSDTOS.add(new ActionVariableWSDTO(actionDBModel.get().getActionVariables().get(i)));
            }
        }
        return actionVariableWSDTOS;
    }


    public ActionVariableWSDTO getActionVariableService(String actionId, String variableId) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent() && actionDBModel.get().getActionVariables() != null) {
            for (int i = 0; i < actionDBModel.get().getActionVariables().size(); i++) {
                if (actionDBModel.get().getActionVariables().get(i).getVariableId().equalsIgnoreCase(variableId)) {
                    return new ActionVariableWSDTO(actionDBModel.get().getActionVariables().get(i));
                }
            }
        }
        return null;
    }


    public ActionVariableWSDTO createActionVariableService(String actionId, long typeId, String value) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (actionDBModel.isPresent() && variableTypeDBModel.isPresent()) {

            ActionVariableDAO actionVariableDAO = new ActionVariableDAO();
            actionVariableDAO.setVariableId(appUtils.generateUUID());
            actionVariableDAO.setVariableType(variableTypeDBModel.get().getVariableType());
            actionVariableDAO.setValue(value);
            actionVariableDAO.setcDate(appUtils.getCurrentTimeStamp());
            actionVariableDAO.setStatus(1);

            if (actionDBModel.get().getActionVariables() == null) {
                List<ActionVariableDAO> actionVariableDAOS = new ArrayList<>();
                actionVariableDAOS.add(actionVariableDAO);
                actionDBModel.get().setActionVariables(actionVariableDAOS);
            } else {
                actionDBModel.get().getActionVariables().add(actionVariableDAO);
            }
            actionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            actionRepository.save(actionDBModel.get());

            return new ActionVariableWSDTO(actionVariableDAO);
        }
        return null;
    }


    public ActionVariableWSDTO updateActionVariableService(String actionId, String variableId, long typeId, String value) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (actionDBModel.isPresent() && actionDBModel.get().getActionVariables() != null && variableTypeDBModel.isPresent()) {
            for (int i = 0; i < actionDBModel.get().getActionVariables().size(); i++) {
                if (actionDBModel.get().getActionVariables().get(i).getVariableId().equalsIgnoreCase(variableId)) {

                    actionDBModel.get().getActionVariables().get(i).setVariableType(variableTypeDBModel.get().getVariableType());
                    actionDBModel.get().getActionVariables().get(i).setValue(value);
                    actionDBModel.get().getActionVariables().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    actionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    actionRepository.save(actionDBModel.get());

                    return new ActionVariableWSDTO(actionDBModel.get().getActionVariables().get(i));
                }
            }
        }
        return null;
    }


    public ActionVariableWSDTO removeActionVariableService(String actionId, String variableId) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent() && actionDBModel.get().getActionVariables() != null) {
            for (int i = 0; i < actionDBModel.get().getActionVariables().size(); i++) {
                if (actionDBModel.get().getActionVariables().get(i).getVariableId().equalsIgnoreCase(variableId)) {

                    ActionVariableDAO actionVariableDAO = actionDBModel.get().getActionVariables().get(i);
                    actionDBModel.get().getActionVariables().remove(actionVariableDAO);
                    actionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    actionRepository.save(actionDBModel.get());

                    return new ActionVariableWSDTO(actionVariableDAO);
                }
            }
        }
        return null;
    }

}
