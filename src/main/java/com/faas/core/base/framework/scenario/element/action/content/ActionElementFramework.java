package com.faas.core.base.framework.scenario.element.action.content;

import com.faas.core.base.model.db.action.content.ActionTempDBModel;
import com.faas.core.base.model.db.scenario.element.action.ActionElementDBModel;
import com.faas.core.base.model.ws.scenario.element.action.content.dto.ActionElementWSDTO;
import com.faas.core.base.repo.action.content.ActionTempRepository;
import com.faas.core.base.repo.scenario.element.action.ActionElementRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ActionElementFramework {

    @Autowired
    ActionElementRepository actionElementRepository;

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AppUtils appUtils;


    public List<ActionElementWSDTO> getScenarioActionElementsService(String scenarioId) {

        List<ActionElementWSDTO> actionElementWSDTOS = new ArrayList<>();
        List<ActionElementDBModel> actionElementDBModels = actionElementRepository.findByScenarioId(scenarioId);
        for (ActionElementDBModel actionElementDBModel : actionElementDBModels) {
            actionElementWSDTOS.add(new ActionElementWSDTO(actionElementDBModel));
        }
        return actionElementWSDTOS;
    }


    public ActionElementWSDTO getActionElementService(String elementId) {

        Optional<ActionElementDBModel> actionElementDBModel = actionElementRepository.findById(elementId);
        if (actionElementDBModel.isPresent()){
            ActionElementWSDTO actionElementWSDTO = new ActionElementWSDTO();
            actionElementWSDTO.setActionElement(actionElementDBModel.get());

            return actionElementWSDTO;
        }
        return null;
    }


    public ActionElementWSDTO createActionElementService(String scenarioId,String actionName,String actionDesc,long actionTempId,int order) {

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(actionTempId);
        if (actionTempDBModel.isPresent()){

            ActionElementDBModel actionElementDBModel = new ActionElementDBModel();

            actionElementDBModel.setScenarioId(scenarioId);
            actionElementDBModel.setActionName(actionName);
            actionElementDBModel.setActionDesc(actionDesc);
            actionElementDBModel.setActionTempId(actionTempId);
            actionElementDBModel.setActionTemp(actionTempDBModel.get().getActionTemp());
            actionElementDBModel.setActionTypeId(actionTempDBModel.get().getTypeId());
            actionElementDBModel.setActionType(actionTempDBModel.get().getActionType());
            actionElementDBModel.setElementDatas(new ArrayList<>());
            actionElementDBModel.setOrder(order);
            actionElementDBModel.setuDate(appUtils.getCurrentTimeStamp());
            actionElementDBModel.setcDate(appUtils.getCurrentTimeStamp());
            actionElementDBModel.setStatus(1);

            return new ActionElementWSDTO(actionElementRepository.save(actionElementDBModel));
        }
        return null;
    }


    public ActionElementWSDTO updateActionElementService(String elementId,String actionName,String actionDesc,long actionTempId,int order) {

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(actionTempId);
        Optional<ActionElementDBModel>actionElementDBModel = actionElementRepository.findById(elementId);
        if (actionElementDBModel.isPresent() && actionTempDBModel.isPresent()){

            actionElementDBModel.get().setActionName(actionName);
            actionElementDBModel.get().setActionDesc(actionDesc);
            actionElementDBModel.get().setActionTempId(actionTempId);
            actionElementDBModel.get().setActionTemp(actionTempDBModel.get().getActionTemp());
            actionElementDBModel.get().setActionTypeId(actionTempDBModel.get().getTypeId());
            actionElementDBModel.get().setActionType(actionTempDBModel.get().getActionType());
            actionElementDBModel.get().setOrder(order);
            actionElementDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            actionElementDBModel.get().setStatus(1);

            return new ActionElementWSDTO(actionElementRepository.save(actionElementDBModel.get()));

        }
        return null;
    }


    public ActionElementWSDTO removeActionElementService(String elementId) {

        Optional<ActionElementDBModel>actionElementDBModel = actionElementRepository.findById(elementId);
        if (actionElementDBModel.isPresent()){
            actionElementRepository.delete(actionElementDBModel.get());
            return new ActionElementWSDTO(actionElementDBModel.get());
        }
        return null;
    }



}
