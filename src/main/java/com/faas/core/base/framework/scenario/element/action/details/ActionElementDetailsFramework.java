package com.faas.core.base.framework.scenario.element.action.details;

import com.faas.core.base.model.db.scenario.element.action.ActionElementDBModel;
import com.faas.core.base.model.db.scenario.element.action.dao.ActionElementDataDAO;
import com.faas.core.base.model.db.utils.variables.DataTypeDBModel;
import com.faas.core.base.model.ws.scenario.element.action.details.dto.ActionElementDataWSDTO;
import com.faas.core.base.repo.scenario.element.action.ActionElementRepository;
import com.faas.core.base.repo.utils.variables.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ActionElementDetailsFramework {


    @Autowired
    ActionElementRepository actionElementRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ActionElementDataWSDTO> getActionElementDatasService(String elementId) {

        List<ActionElementDataWSDTO> elementDataWSDTOS = new ArrayList<>();
        Optional<ActionElementDBModel> actionElementDBModel = actionElementRepository.findById(elementId);
        if (actionElementDBModel.isPresent() && actionElementDBModel.get().getElementDatas() != null){
            for (int i=0;i<actionElementDBModel.get().getElementDatas().size();i++){
                elementDataWSDTOS.add(new ActionElementDataWSDTO(actionElementDBModel.get().getElementDatas().get(i)));
            }
        }
        return elementDataWSDTOS;
    }


    public ActionElementDataWSDTO getActionElementDataService(String elementId,String dataId) {

        Optional<ActionElementDBModel> actionElementDBModel = actionElementRepository.findById(elementId);
        if (actionElementDBModel.isPresent() && actionElementDBModel.get().getElementDatas() != null){
            for (int i=0;i<actionElementDBModel.get().getElementDatas().size();i++){
                if (actionElementDBModel.get().getElementDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new ActionElementDataWSDTO(actionElementDBModel.get().getElementDatas().get(i));
                }
            }
        }
        return null;
    }


    public ActionElementDataWSDTO createActionElementDataService(String elementId,long dataTypeId,String value) {

        Optional<ActionElementDBModel> actionElementDBModel = actionElementRepository.findById(elementId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (actionElementDBModel.isPresent() && dataTypeDBModel.isPresent()){

            ActionElementDataDAO actionElementDataDAO = new ActionElementDataDAO();
            actionElementDataDAO.setDataId(appUtils.generateUUID());
            actionElementDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            actionElementDataDAO.setValue(value);
            actionElementDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            actionElementDataDAO.setStatus(1);

            if (actionElementDBModel.get().getElementDatas() == null){
                List<ActionElementDataDAO> actionElementDataDAOS = new ArrayList<>();
                actionElementDataDAOS.add(actionElementDataDAO);
                actionElementDBModel.get().setElementDatas(actionElementDataDAOS);
            }else {
                actionElementDBModel.get().getElementDatas().add(actionElementDataDAO);
            }
            actionElementDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            actionElementRepository.save(actionElementDBModel.get());

            return new ActionElementDataWSDTO(actionElementDataDAO);
        }
        return null;
    }


    public ActionElementDataWSDTO updateActionElementDataService(String elementId,String dataId,long dataTypeId,String value) {

        Optional<ActionElementDBModel> actionElementDBModel = actionElementRepository.findById(elementId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (actionElementDBModel.isPresent() && actionElementDBModel.get().getElementDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<actionElementDBModel.get().getElementDatas().size();i++){
                if (actionElementDBModel.get().getElementDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    actionElementDBModel.get().getElementDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    actionElementDBModel.get().getElementDatas().get(i).setValue(value);
                    actionElementDBModel.get().getElementDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    actionElementDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    actionElementRepository.save(actionElementDBModel.get());

                    return new ActionElementDataWSDTO(actionElementDBModel.get().getElementDatas().get(i));
                }
            }
        }
        return null;
    }


    public ActionElementDataWSDTO removeActionElementDataService(String elementId,String dataId) {

        Optional<ActionElementDBModel> actionElementDBModel = actionElementRepository.findById(elementId);
        if (actionElementDBModel.isPresent() && actionElementDBModel.get().getElementDatas() != null){
            for (int i=0;i<actionElementDBModel.get().getElementDatas().size();i++){
                if (actionElementDBModel.get().getElementDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    ActionElementDataDAO actionElementDataDAO = actionElementDBModel.get().getElementDatas().get(i);
                    actionElementDBModel.get().getElementDatas().remove(actionElementDataDAO);
                    actionElementDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

                    return new ActionElementDataWSDTO(actionElementDataDAO);
                }
            }
        }
        return null;
    }




}
