package com.faas.core.base.framework.process.details.scenario;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.process.details.scenario.dao.ProcessScenarioVariableDAO;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.settings.VariableTypeDBModel;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioVariableWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.scenario.settings.VariableTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessScenarioFramework {


    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    VariableTypeRepository variableTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessScenarioWSDTO fillProcessScenarioWSDTO(ProcessScenarioDBModel processScenarioDBModel) {

        ProcessScenarioWSDTO processScenarioWSDTO = new ProcessScenarioWSDTO();
        processScenarioWSDTO.setProcessScenario(processScenarioDBModel);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
        if (scenarioDBModel.isPresent()) {
            processScenarioWSDTO.setProcessScenarioDetails(scenarioDBModel.get());
        }
        return processScenarioWSDTO;
    }


    public List<ProcessScenarioWSDTO> getProcessScenariosService(String processId) {

        List<ProcessScenarioWSDTO> processScenarioWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processId);
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            processScenarioWSDTOS.add(fillProcessScenarioWSDTO(processScenarioDBModel));
        }
        return processScenarioWSDTOS;
    }


    public ProcessScenarioWSDTO getProcessScenarioService(String processId, String scenarioId) {

        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (processScenarioDBModels.size() > 0) {
            return fillProcessScenarioWSDTO(processScenarioDBModels.get(0));
        }
        return null;
    }


    public ProcessScenarioWSDTO createProcessScenarioService(String processId, String scenarioId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (!processScenarioRepository.existsByProcessIdAndScenarioId(processId,scenarioId) && processDBModel.isPresent() && scenarioDBModel.isPresent()) {

            ProcessScenarioDBModel processScenarioDBModel = new ProcessScenarioDBModel();
            processScenarioDBModel.setProcessId(processId);
            processScenarioDBModel.setScenarioId(scenarioId);
            processScenarioDBModel.setProcessScenarioVariables(new ArrayList<>());
            processScenarioDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processScenarioDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processScenarioDBModel.setStatus(1);

            return fillProcessScenarioWSDTO(processScenarioRepository.save(processScenarioDBModel));
        }
        return null;
    }


    public ProcessScenarioWSDTO removeProcessScenarioService(String processId, String scenarioId) {

        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (processScenarioDBModels.size() > 0) {
            processScenarioRepository.deleteAll(processScenarioDBModels);
            return fillProcessScenarioWSDTO(processScenarioDBModels.get(0));
        }
        return null;
    }


    public List<ProcessScenarioVariableWSDTO> getProcessScenarioVariablesService(String processId, String scenarioId) {

        List<ProcessScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (scenarioDBModels.size() > 0 && scenarioDBModels.get(0).getProcessScenarioVariables() != null) {
            for (int i = 0; i < scenarioDBModels.get(0).getProcessScenarioVariables().size(); i++) {
                scenarioVariableWSDTOS.add(new ProcessScenarioVariableWSDTO(scenarioDBModels.get(0).getProcessScenarioVariables().get(i)));
            }
        }
        return scenarioVariableWSDTOS;
    }


    public ProcessScenarioVariableWSDTO getProcessScenarioVariableService(String processId, String scenarioId, String variableId) {

        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (scenarioDBModels.size() > 0 && scenarioDBModels.get(0).getProcessScenarioVariables() != null) {
            for (int i = 0; i < scenarioDBModels.get(0).getProcessScenarioVariables().size(); i++) {
                if (scenarioDBModels.get(0).getProcessScenarioVariables().get(i).getVariableId().equalsIgnoreCase(variableId)) {
                    return new ProcessScenarioVariableWSDTO(scenarioDBModels.get(0).getProcessScenarioVariables().get(i));
                }
            }
        }
        return null;
    }


    public ProcessScenarioVariableWSDTO createProcessScenarioVariableService(String processId, String scenarioId, long typeId, String value) {

        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (scenarioDBModels.size() > 0 && variableTypeDBModel.isPresent()) {

            ProcessScenarioVariableDAO scenarioVariableDAO = new ProcessScenarioVariableDAO();
            scenarioVariableDAO.setVariableId(appUtils.generateUUID());
            scenarioVariableDAO.setVariableType(variableTypeDBModel.get().getVariableType());
            scenarioVariableDAO.setValue(value);
            scenarioVariableDAO.setcDate(appUtils.getCurrentTimeStamp());
            scenarioVariableDAO.setStatus(1);

            if (scenarioDBModels.get(0).getProcessScenarioVariables() != null) {
                scenarioDBModels.get(0).getProcessScenarioVariables().add(scenarioVariableDAO);
            } else {
                List<ProcessScenarioVariableDAO> scenarioVariableDAOS = new ArrayList<>();
                scenarioVariableDAOS.add(scenarioVariableDAO);
                scenarioDBModels.get(0).setProcessScenarioVariables(scenarioVariableDAOS);
            }
            scenarioDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            processScenarioRepository.save(scenarioDBModels.get(0));

            return new ProcessScenarioVariableWSDTO(scenarioVariableDAO);
        }
        return null;
    }

    public ProcessScenarioVariableWSDTO updateProcessScenarioVariableService(String processId, String scenarioId, String variableId, long typeId, String value) {

        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (scenarioDBModels.size() > 0 && scenarioDBModels.get(0).getScenarioId() != null && variableTypeDBModel.isPresent()) {
            for (int i = 0; i < scenarioDBModels.get(0).getProcessScenarioVariables().size(); i++) {
                if (scenarioDBModels.get(0).getProcessScenarioVariables().get(i).getVariableId().equalsIgnoreCase(variableId)) {

                    scenarioDBModels.get(0).getProcessScenarioVariables().get(i).setVariableId(variableTypeDBModel.get().getVariableType());
                    scenarioDBModels.get(0).getProcessScenarioVariables().get(i).setValue(value);
                    scenarioDBModels.get(0).getProcessScenarioVariables().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processScenarioRepository.save(scenarioDBModels.get(0));

                    return new ProcessScenarioVariableWSDTO(scenarioDBModels.get(0).getProcessScenarioVariables().get(i));
                }
            }
        }
        return null;
    }


    public ProcessScenarioVariableWSDTO removeProcessScenarioVariableService(String processId, String scenarioId, String variableId) {

        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (scenarioDBModels.size() > 0 && scenarioDBModels.get(0).getProcessScenarioVariables() != null) {
            for (int i = 0; i < scenarioDBModels.get(0).getProcessScenarioVariables().size(); i++) {
                if (scenarioDBModels.get(0).getProcessScenarioVariables().get(i).getVariableId().equalsIgnoreCase(variableId)) {
                    ProcessScenarioVariableDAO scenarioVariableDAO = scenarioDBModels.get(0).getProcessScenarioVariables().get(i);
                    scenarioDBModels.get(0).getProcessScenarioVariables().remove(scenarioVariableDAO);
                    scenarioDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processScenarioRepository.save(scenarioDBModels.get(0));

                    return new ProcessScenarioVariableWSDTO(scenarioVariableDAO);
                }
            }
        }
        return null;
    }


}
