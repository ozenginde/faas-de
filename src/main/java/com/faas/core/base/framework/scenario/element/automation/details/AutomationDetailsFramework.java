package com.faas.core.base.framework.scenario.element.automation.details;

import com.faas.core.base.model.db.scenario.element.automation.AutomationDBModel;
import com.faas.core.base.model.db.scenario.element.automation.dao.AutomationVariableDAO;
import com.faas.core.base.model.db.scenario.settings.VariableTypeDBModel;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.scenario.element.automation.details.dto.AutomationVariableWSDTO;
import com.faas.core.base.repo.scenario.element.automation.AutomationRepository;
import com.faas.core.base.repo.scenario.settings.VariableTypeRepository;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
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
    VariableTypeRepository variableTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<AutomationVariableWSDTO> getAutomationVariablesService(String automationId) {

        List<AutomationVariableWSDTO> automationVariableWSDTOS = new ArrayList<>();
        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent() && automationDBModel.get().getAutomationVariables() != null){
            for (int i=0;i<automationDBModel.get().getAutomationVariables().size();i++){
                automationVariableWSDTOS.add(new AutomationVariableWSDTO(automationDBModel.get().getAutomationVariables().get(i)));
            }
        }
        return automationVariableWSDTOS;
    }


    public AutomationVariableWSDTO getAutomationVariableService(String automationId, String variableId) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent() && automationDBModel.get().getAutomationVariables() != null){
            for (int i=0;i<automationDBModel.get().getAutomationVariables().size();i++){
                if (automationDBModel.get().getAutomationVariables().get(i).getVariableId().equalsIgnoreCase(variableId)){
                    return new AutomationVariableWSDTO(automationDBModel.get().getAutomationVariables().get(i));
                }
            }
        }
        return null;
    }


    public AutomationVariableWSDTO createAutomationVariableService(String automationId, long typeId, String value) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (automationDBModel.isPresent() && variableTypeDBModel.isPresent()){
            AutomationVariableDAO automationVariableDAO = new AutomationVariableDAO();
            automationVariableDAO.setVariableId(appUtils.generateUUID());
            automationVariableDAO.setVariableType(variableTypeDBModel.get().getVariableType());
            automationVariableDAO.setValue(value);
            automationVariableDAO.setcDate(appUtils.getCurrentTimeStamp());
            automationVariableDAO.setStatus(1);

            if (automationDBModel.get().getAutomationVariables() == null){
                List<AutomationVariableDAO> automationVariableDAOS = new ArrayList<>();
                automationVariableDAOS.add(automationVariableDAO);
                automationDBModel.get().setAutomationVariables(automationVariableDAOS);
            }else {
                automationDBModel.get().getAutomationVariables().add(automationVariableDAO);
            }
            automationDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            automationRepository.save(automationDBModel.get());

            return new AutomationVariableWSDTO(automationVariableDAO);
        }
        return null;
    }


    public AutomationVariableWSDTO updateAutomationVariableService(String automationId, String variableId, long typeId, String value) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (automationDBModel.isPresent() && automationDBModel.get().getAutomation() != null && variableTypeDBModel.isPresent()){
            for (int i=0;i<automationDBModel.get().getAutomationVariables().size();i++){
                if (automationDBModel.get().getAutomationVariables().get(i).getVariableId().equalsIgnoreCase(variableId)){
                    automationDBModel.get().getAutomationVariables().get(i).setVariableType(variableTypeDBModel.get().getVariableType());
                    automationDBModel.get().getAutomationVariables().get(i).setValue(value);
                    automationDBModel.get().getAutomationVariables().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    automationDBModel.get().getAutomationVariables().get(i).setStatus(1);
                    automationDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    automationRepository.save(automationDBModel.get());

                    return new AutomationVariableWSDTO(automationDBModel.get().getAutomationVariables().get(i));
                }
            }
        }
        return null;
    }


    public AutomationVariableWSDTO removeAutomationVariableService(String automationId, String variableId) {

        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (automationDBModel.isPresent() && automationDBModel.get().getAutomationVariables() != null){
            for (int i=0;i<automationDBModel.get().getAutomationVariables().size();i++){
                if (automationDBModel.get().getAutomationVariables().get(i).getVariableId().equalsIgnoreCase(variableId)){
                    AutomationVariableDAO automationVariableDAO = automationDBModel.get().getAutomationVariables().get(i);
                    automationDBModel.get().getAutomationVariables().remove(automationVariableDAO);
                    automationDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    automationRepository.save(automationDBModel.get());

                    return new AutomationVariableWSDTO(automationVariableDAO);
                }
            }
        }
        return null;
    }




}
