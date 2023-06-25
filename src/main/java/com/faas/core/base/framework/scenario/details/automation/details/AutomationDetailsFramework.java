package com.faas.core.base.framework.scenario.details.automation.details;

import com.faas.core.base.model.db.scenario.details.automation.AutomationDBModel;
import com.faas.core.base.model.db.scenario.details.automation.dao.AutomationDataDAO;
import com.faas.core.base.model.db.utils.variables.DataTypeDBModel;
import com.faas.core.base.model.ws.scenario.details.automation.details.dto.AutomationDataWSDTO;
import com.faas.core.base.repo.scenario.details.automation.AutomationRepository;
import com.faas.core.base.repo.utils.variables.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AutomationDetailsFramework {


    @Autowired
    AutomationRepository automationRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomationDataWSDTO> getAutomationDatasService(String automationId) {

        List<AutomationDataWSDTO> automationDataWSDTOS = new ArrayList<>();
        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent() && automationDBModel.get().getAutomationDatas() != null){
            for (int i=0;i<automationDBModel.get().getAutomationDatas().size();i++){
                automationDataWSDTOS.add(new AutomationDataWSDTO(automationDBModel.get().getAutomationDatas().get(i)));
            }
        }
        return automationDataWSDTOS;
    }


    public AutomationDataWSDTO getAutomationDataService(String automationId, String dataId) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent() && automationDBModel.get().getAutomationDatas() != null){
            for (int i=0;i<automationDBModel.get().getAutomationDatas().size();i++){
                if (automationDBModel.get().getAutomationDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new AutomationDataWSDTO(automationDBModel.get().getAutomationDatas().get(i));
                }
            }
        }
        return null;
    }


    public AutomationDataWSDTO createAutomationDataService(String automationId, long dataTypeId, String value) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (automationDBModel.isPresent() && dataTypeDBModel.isPresent()){
            AutomationDataDAO automationDataDAO = new AutomationDataDAO();
            automationDataDAO.setDataId(appUtils.generateUUID());
            automationDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            automationDataDAO.setValue(value);
            automationDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            automationDataDAO.setStatus(1);

            if (automationDBModel.get().getAutomationDatas() == null){
                List<AutomationDataDAO> automationDataDAOS = new ArrayList<>();
                automationDataDAOS.add(automationDataDAO);
                automationDBModel.get().setAutomationDatas(automationDataDAOS);
            }else {
                automationDBModel.get().getAutomationDatas().add(automationDataDAO);
            }
            automationDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            automationRepository.save(automationDBModel.get());

            return new AutomationDataWSDTO(automationDataDAO);
        }
        return null;
    }


    public AutomationDataWSDTO updateAutomationDataService(String automationId, String dataId, long dataTypeId, String value) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (automationDBModel.isPresent() && automationDBModel.get().getAutomation() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<automationDBModel.get().getAutomationDatas().size();i++){
                if (automationDBModel.get().getAutomationDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    automationDBModel.get().getAutomationDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    automationDBModel.get().getAutomationDatas().get(i).setValue(value);
                    automationDBModel.get().getAutomationDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    automationDBModel.get().getAutomationDatas().get(i).setStatus(1);
                    automationDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    automationRepository.save(automationDBModel.get());

                    return new AutomationDataWSDTO(automationDBModel.get().getAutomationDatas().get(i));
                }
            }
        }
        return null;
    }


    public AutomationDataWSDTO removeAutomationDataService(String automationId, String dataId) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent() && automationDBModel.get().getAutomationDatas() != null){
            for (int i=0;i<automationDBModel.get().getAutomationDatas().size();i++){
                if (automationDBModel.get().getAutomationDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    AutomationDataDAO automationDataDAO = automationDBModel.get().getAutomationDatas().get(i);
                    automationDBModel.get().getAutomationDatas().remove(automationDataDAO);
                    automationDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    automationRepository.save(automationDBModel.get());

                    return new AutomationDataWSDTO(automationDataDAO);
                }
            }
        }
        return null;
    }




}
