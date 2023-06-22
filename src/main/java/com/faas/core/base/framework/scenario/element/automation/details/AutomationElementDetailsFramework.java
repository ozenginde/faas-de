package com.faas.core.base.framework.scenario.element.automation.details;

import com.faas.core.base.model.db.scenario.element.automation.AutomationElementDBModel;
import com.faas.core.base.model.db.scenario.element.automation.dao.AutomationElementDataDAO;
import com.faas.core.base.model.db.utils.variables.DataTypeDBModel;
import com.faas.core.base.model.ws.scenario.element.automation.details.dto.AutomationElementDataWSDTO;
import com.faas.core.base.repo.scenario.element.automation.AutomationElementRepository;
import com.faas.core.base.repo.utils.variables.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AutomationElementDetailsFramework {


    @Autowired
    AutomationElementRepository automationElementRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomationElementDataWSDTO> getAutomationElementDatasService(String elementId) {

        List<AutomationElementDataWSDTO> elementDataWSDTOS = new ArrayList<>();
        Optional<AutomationElementDBModel> automationElementDBModel = automationElementRepository.findById(elementId);
        if (automationElementDBModel.isPresent() && automationElementDBModel.get().getElementDatas() != null){
            for (int i=0;i<automationElementDBModel.get().getElementDatas().size();i++){
                elementDataWSDTOS.add(new AutomationElementDataWSDTO(automationElementDBModel.get().getElementDatas().get(i)));
            }
        }
        return elementDataWSDTOS;
    }


    public AutomationElementDataWSDTO getAutomationElementDataService(String elementId,String dataId) {

        Optional<AutomationElementDBModel> automationElementDBModel = automationElementRepository.findById(elementId);
        if (automationElementDBModel.isPresent() && automationElementDBModel.get().getElementDatas() != null){
            for (int i=0;i<automationElementDBModel.get().getElementDatas().size();i++){
                if (automationElementDBModel.get().getElementDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new AutomationElementDataWSDTO(automationElementDBModel.get().getElementDatas().get(i));
                }
            }
        }
        return null;
    }


    public AutomationElementDataWSDTO createAutomationElementDataService(String elementId,long dataTypeId,String value) {

        Optional<AutomationElementDBModel> automationElementDBModel = automationElementRepository.findById(elementId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (automationElementDBModel.isPresent() && dataTypeDBModel.isPresent()){

            AutomationElementDataDAO elementDataDAO = new AutomationElementDataDAO();
            elementDataDAO.setDataId(appUtils.generateUUID());
            elementDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            elementDataDAO.setValue(value);
            elementDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            elementDataDAO.setStatus(1);

            if (automationElementDBModel.get().getElementDatas() == null){
                List<AutomationElementDataDAO> elementDataDAOS = new ArrayList<>();
                elementDataDAOS.add(elementDataDAO);
                automationElementDBModel.get().setElementDatas(elementDataDAOS);
            }else {
                automationElementDBModel.get().getElementDatas().add(elementDataDAO);
            }
            automationElementDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            automationElementRepository.save(automationElementDBModel.get());

            return new AutomationElementDataWSDTO(elementDataDAO);
        }
        return null;
    }


    public AutomationElementDataWSDTO updateAutomationElementDataService(String elementId,String dataId,long dataTypeId,String value) {

        Optional<AutomationElementDBModel> automationElementDBModel = automationElementRepository.findById(elementId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (automationElementDBModel.isPresent() && automationElementDBModel.get().getElementDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<automationElementDBModel.get().getElementDatas().size();i++){
                if (automationElementDBModel.get().getElementDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    automationElementDBModel.get().getElementDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    automationElementDBModel.get().getElementDatas().get(i).setValue(value);
                    automationElementDBModel.get().getElementDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    automationElementDBModel.get().getElementDatas().get(i).setStatus(1);
                    automationElementDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    automationElementRepository.save(automationElementDBModel.get());

                    return new AutomationElementDataWSDTO(automationElementDBModel.get().getElementDatas().get(i));
                }
            }
        }
        return null;
    }


    public AutomationElementDataWSDTO removeAutomationElementDataService(String elementId,String dataId) {

        Optional<AutomationElementDBModel> automationElementDBModel = automationElementRepository.findById(elementId);
        if (automationElementDBModel.isPresent() && automationElementDBModel.get().getElementDatas() != null){
            for (int i=0;i<automationElementDBModel.get().getElementDatas().size();i++){
                if (automationElementDBModel.get().getElementDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    AutomationElementDataDAO elementDataDAO = automationElementDBModel.get().getElementDatas().get(i);
                    automationElementDBModel.get().getElementDatas().remove(elementDataDAO);
                    automationElementDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    automationElementRepository.save(automationElementDBModel.get());

                    return new AutomationElementDataWSDTO(elementDataDAO);
                }
            }
        }
        return null;
    }




}
