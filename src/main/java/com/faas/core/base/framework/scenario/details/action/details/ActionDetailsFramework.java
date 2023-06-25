package com.faas.core.base.framework.scenario.details.action.details;

import com.faas.core.base.model.db.scenario.details.action.ActionDBModel;
import com.faas.core.base.model.db.scenario.details.action.dao.ActionDataDAO;
import com.faas.core.base.model.db.utils.variables.DataTypeDBModel;
import com.faas.core.base.model.ws.scenario.details.action.details.dto.ActionDataWSDTO;
import com.faas.core.base.repo.scenario.details.action.ActionRepository;
import com.faas.core.base.repo.utils.variables.DataTypeRepository;
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
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ActionDataWSDTO> getActionDatasService(String actionId) {

        List<ActionDataWSDTO> actionDataWSDTOS = new ArrayList<>();
        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent() && actionDBModel.get().getActionDatas() != null){
            for (int i=0;i<actionDBModel.get().getActionDatas().size();i++){
                actionDataWSDTOS.add(new ActionDataWSDTO(actionDBModel.get().getActionDatas().get(i)));
            }
        }
        return actionDataWSDTOS;
    }


    public ActionDataWSDTO getActionDataService(String actionId, String dataId) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent() && actionDBModel.get().getActionDatas() != null){
            for (int i=0;i<actionDBModel.get().getActionDatas().size();i++){
                if (actionDBModel.get().getActionDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new ActionDataWSDTO(actionDBModel.get().getActionDatas().get(i));
                }
            }
        }
        return null;
    }


    public ActionDataWSDTO createActionDataService(String actionId, long dataTypeId, String value) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (actionDBModel.isPresent() && dataTypeDBModel.isPresent()){

            ActionDataDAO actionDataDAO = new ActionDataDAO();
            actionDataDAO.setDataId(appUtils.generateUUID());
            actionDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            actionDataDAO.setValue(value);
            actionDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            actionDataDAO.setStatus(1);

            if (actionDBModel.get().getActionDatas() == null){
                List<ActionDataDAO> actionDataDAOS = new ArrayList<>();
                actionDataDAOS.add(actionDataDAO);
                actionDBModel.get().setActionDatas(actionDataDAOS);
            }else {
                actionDBModel.get().getActionDatas().add(actionDataDAO);
            }
            actionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            actionRepository.save(actionDBModel.get());

            return new ActionDataWSDTO(actionDataDAO);
        }
        return null;
    }


    public ActionDataWSDTO updateActionDataService(String actionId, String dataId, long dataTypeId, String value) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (actionDBModel.isPresent() && actionDBModel.get().getActionDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<actionDBModel.get().getActionDatas().size();i++){
                if (actionDBModel.get().getActionDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    actionDBModel.get().getActionDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    actionDBModel.get().getActionDatas().get(i).setValue(value);
                    actionDBModel.get().getActionDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    actionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    actionRepository.save(actionDBModel.get());

                    return new ActionDataWSDTO(actionDBModel.get().getActionDatas().get(i));
                }
            }
        }
        return null;
    }


    public ActionDataWSDTO removeActionDataService(String actionId, String dataId) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent() && actionDBModel.get().getActionDatas() != null){
            for (int i=0;i<actionDBModel.get().getActionDatas().size();i++){
                if (actionDBModel.get().getActionDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    ActionDataDAO actionDataDAO = actionDBModel.get().getActionDatas().get(i);
                    actionDBModel.get().getActionDatas().remove(actionDataDAO);
                    actionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

                    return new ActionDataWSDTO(actionDataDAO);
                }
            }
        }
        return null;
    }

}
