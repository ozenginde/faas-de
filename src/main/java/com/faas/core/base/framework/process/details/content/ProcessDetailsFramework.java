package com.faas.core.base.framework.process.details.content;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessPathDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessUrlDAO;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessUrlWSDTO;
import com.faas.core.base.model.ws.process.details.path.dto.ProcessPathWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessDetailsFramework {

    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessDetailsWSDTO getProcessDetailsService(String processId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        return processDBModel.map(dbModel -> processHelper.createProcessDetailsWSDTO(dbModel)).orElse(null);
    }


    public ProcessDataWSDTO fillProcessDataWSDTO(ProcessDataDAO processDataDAO) {

        ProcessDataWSDTO processDataWSDTO = new ProcessDataWSDTO();
        processDataWSDTO.setProcessData(processDataDAO);
        return processDataWSDTO;
    }


    public ProcessDataDAO createProcessDataService(String processId, long dataTypeId, String value) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (processDBModel.isPresent() && dataTypeDBModel.isPresent()) {

            ProcessDataDAO processDataDAO = new ProcessDataDAO();
            processDataDAO.setDataId(appUtils.generateUUID());
            processDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            processDataDAO.setValue(value);
            processDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            processDataDAO.setStatus(1);

            processDBModel.get().getProcessDatas().add(processDataDAO);
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return processDataDAO;
        }
        return null;
    }


    public ProcessDataDAO updateProcessDataService(String processId, String dataId, long dataTypeId, String value) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (processDBModel.isPresent() && dataTypeDBModel.isPresent()) {
            for (int i = 0; i < processDBModel.get().getProcessDatas().size(); i++) {
                if (processDBModel.get().getProcessDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    processDBModel.get().getProcessDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    processDBModel.get().getProcessDatas().get(i).setValue(value);
                    processDBModel.get().getProcessDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return processDBModel.get().getProcessDatas().get(i);
                }
            }
        }
        return null;
    }


    public ProcessDataDAO removeProcessDataService(String processId, String dataId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessDatas() != null) {
            for (int i = 0; i < processDBModel.get().getProcessDatas().size(); i++) {
                if (processDBModel.get().getProcessDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {
                    ProcessDataDAO processDataDAO = processDBModel.get().getProcessDatas().get(i);
                    processDBModel.get().getProcessDatas().remove(processDataDAO);
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return processDataDAO;
                }
            }
        }
        return null;
    }


    public ProcessUrlWSDTO fillProcessUrlWSDTO(ProcessUrlDAO processUrlDAO) {

        ProcessUrlWSDTO processUrlWSDTO = new ProcessUrlWSDTO();
        processUrlWSDTO.setProcessUrl(processUrlDAO);
        return processUrlWSDTO;
    }


    public ProcessUrlDAO createProcessUrlService(String processId, String urlType, String url) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()) {

            ProcessUrlDAO processUrlDAO = new ProcessUrlDAO();
            processUrlDAO.setUrlId(appUtils.generateUUID());
            processUrlDAO.setUrlType(urlType);
            processUrlDAO.setUrl(url);
            processUrlDAO.setcDate(appUtils.getCurrentTimeStamp());
            processUrlDAO.setStatus(1);

            processDBModel.get().getProcessUrls().add(processUrlDAO);
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return processUrlDAO;
        }
        return null;
    }


    public ProcessUrlDAO updateProcessUrlService(String processId, String urlId, String urlType, String url) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()) {
            for (int i = 0; i < processDBModel.get().getProcessUrls().size(); i++) {
                if (processDBModel.get().getProcessUrls().get(i).getUrlId().equalsIgnoreCase(urlId)) {
                    processDBModel.get().getProcessUrls().get(i).setUrlType(urlType);
                    processDBModel.get().getProcessUrls().get(i).setUrl(url);
                    processDBModel.get().getProcessUrls().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return processDBModel.get().getProcessUrls().get(i);
                }
            }
        }
        return null;
    }


    public ProcessUrlDAO removeProcessUrlService(String processId, String urlId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessUrls() != null) {
            for (int i = 0; i < processDBModel.get().getProcessUrls().size(); i++) {
                if (processDBModel.get().getProcessUrls().get(i).getUrlId().equalsIgnoreCase(urlId)) {
                    ProcessUrlDAO processUrlDAO = processDBModel.get().getProcessUrls().get(i);
                    processDBModel.get().getProcessUrls().remove(processUrlDAO);
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return processUrlDAO;
                }
            }
        }
        return null;
    }


    public List<ProcessPathWSDTO> getProcessPathsService(String processId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessPaths() != null) {
            List<ProcessPathWSDTO> processPathWSDTOS = new ArrayList<>();
            for (int i=0;i<processDBModel.get().getProcessPaths().size();i++){
                processPathWSDTOS.add(new ProcessPathWSDTO(processDBModel.get().getProcessPaths().get(i)));
            }
            return processPathWSDTOS;
        }
        return null;
    }


    public ProcessPathWSDTO getProcessPathService(String processId,String pathId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessPaths() != null) {
            for (int i=0;i<processDBModel.get().getProcessPaths().size();i++){
                if (processDBModel.get().getProcessPaths().get(i).getPathId().equalsIgnoreCase(pathId)){
                    return new ProcessPathWSDTO(processDBModel.get().getProcessPaths().get(i));
                }
            }
        }
        return null;
    }


    public ProcessPathWSDTO createProcessPathService(String processId,int pathOrder,String processPath) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()) {
            ProcessPathDAO processPathDAO = new ProcessPathDAO();
            processPathDAO.setPathId(appUtils.generateUUID());
            processPathDAO.setPathOrder(pathOrder);
            processPathDAO.setProcessPath(processPath);
            processPathDAO.setuDate(appUtils.getCurrentTimeStamp());
            processPathDAO.setcDate(appUtils.getCurrentTimeStamp());
            processPathDAO.setStatus(1);

            if (processDBModel.get().getProcessPaths() != null){
                processDBModel.get().getProcessPaths().add(processPathDAO);
            }else {
                List<ProcessPathDAO> processPathDAOS = new ArrayList<>();
                processPathDAOS.add(processPathDAO);
                processDBModel.get().setProcessPaths(processPathDAOS);
            }
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return new ProcessPathWSDTO(processPathDAO);
        }
        return null;
    }


    public ProcessPathWSDTO updateProcessPathService(String processId, String pathId,int pathOrder,String processPath) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessPaths() != null) {
            for (int i=0;i<processDBModel.get().getProcessPaths().size();i++){
                if (processDBModel.get().getProcessPaths().get(i).getPathId().equalsIgnoreCase(pathId)){
                    processDBModel.get().getProcessPaths().get(i).setPathOrder(pathOrder);
                    processDBModel.get().getProcessPaths().get(i).setProcessPath(processPath);
                    processDBModel.get().getProcessPaths().get(i).setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessPathWSDTO(processDBModel.get().getProcessPaths().get(i));
                }
            }
        }
        return null;
    }


    public ProcessPathWSDTO removeProcessPathService(String processId, String pathId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessPaths() != null) {
            for (int i=0;i<processDBModel.get().getProcessPaths().size();i++){
                if (processDBModel.get().getProcessPaths().get(i).getPathId().equalsIgnoreCase(pathId)){
                    ProcessPathDAO processPathDAO = processDBModel.get().getProcessPaths().get(i);
                    processDBModel.get().getProcessPaths().remove(processPathDAO);
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessPathWSDTO(processPathDAO);
                }
            }
        }
        return null;
    }


}
