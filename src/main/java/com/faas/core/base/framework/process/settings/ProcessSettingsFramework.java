package com.faas.core.base.framework.process.settings;

import com.faas.core.base.model.db.process.settings.ProcessTypeDBModel;
import com.faas.core.base.model.db.scenario.settings.ScenarioTypeDBModel;
import com.faas.core.base.model.ws.process.settings.dto.ProcessTypeWSDTO;
import com.faas.core.base.model.ws.scenario.settings.dto.ScenarioTypeWSDTO;
import com.faas.core.base.repo.process.settings.ProcessTypeRepository;
import com.faas.core.base.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ProcessSettingsFramework {


    @Autowired
    ProcessTypeRepository processTypeRepository;

    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessTypeWSDTO fillProcessTypeWSDTO(ProcessTypeDBModel processTypeDBModel) {

        ProcessTypeWSDTO processTypeWSDTO = new ProcessTypeWSDTO();
        processTypeWSDTO.setProcessType(processTypeDBModel);
        return processTypeWSDTO;
    }

    public ProcessTypeDBModel createProcessTypeService(String processType,String baseType) {

        ProcessTypeDBModel processTypeDBModel = new ProcessTypeDBModel();
        processTypeDBModel.setProcessType(processType);
        processTypeDBModel.setBaseType(baseType);
        processTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        processTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        processTypeDBModel.setStatus(1);

        return processTypeRepository.save(processTypeDBModel);
    }

    public ProcessTypeDBModel updateProcessTypeService(long typeId, String processType,String baseType) {

        Optional<ProcessTypeDBModel> processTypeDBModel = processTypeRepository.findById(typeId);
        if (processTypeDBModel.isPresent()) {
            processTypeDBModel.get().setProcessType(processType);
            processTypeDBModel.get().setBaseType(baseType);
            processTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processTypeDBModel.get().setStatus(1);

            return processTypeRepository.save(processTypeDBModel.get());
        }
        return null;
    }

    public ProcessTypeDBModel removeProcessTypeService(long typeId) {

        Optional<ProcessTypeDBModel> processTypeDBModel = processTypeRepository.findById(typeId);
        if (processTypeDBModel.isPresent()) {
            processTypeRepository.delete(processTypeDBModel.get());
            return processTypeDBModel.get();
        }
        return null;
    }




}
