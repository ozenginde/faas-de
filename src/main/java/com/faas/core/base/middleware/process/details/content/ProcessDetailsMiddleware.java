package com.faas.core.base.middleware.process.details.content;

import com.faas.core.base.framework.process.details.content.ProcessDetailsFramework;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessUrlDAO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDetailsWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessUrlWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessUrlWSDTO;
import com.faas.core.base.model.ws.process.details.content.ProcessCallScriptWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessCallScriptWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessDetailsMiddleware {

    @Autowired
    ProcessDetailsFramework processDetailsFramework;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessDetailsWSModel getProcessDetails(long userId, String processId) {

        ProcessDetailsWSModel response = new ProcessDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessDetailsWSDTO processDetailsWSDTO = processDetailsFramework.getProcessDetailsService(processId);
        if (processDetailsWSDTO != null){
            response.setProcessDetails(processDetailsWSDTO);
        }

        general.setOperation("getProcessDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel getProcessDatas(long userId, String processId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);


        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("getProcessDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel getProcessData(long userId, String processId, String dataId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);


        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("getProcessData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel createProcessData(long userId,String processId,long dataTypeId,String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataDAO processDataDAO = processDetailsFramework.createProcessDataService(processId,dataTypeId,value);
        if (processDataDAO != null) {
            processDataWSDTOS.add(processDetailsFramework.fillProcessDataWSDTO(processDataDAO));
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("createProcessData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessDataWSModel updateProcessData(long userId,String processId,String dataId,long dataTypeId,String value) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataDAO processDataDAO = processDetailsFramework.updateProcessDataService(processId,dataId,dataTypeId,value);
        if (processDataDAO != null) {
            processDataWSDTOS.add(processDetailsFramework.fillProcessDataWSDTO(processDataDAO));
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("updateProcessData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessDataWSModel removeProcessData(long userId,String processId,String dataId) {

        ProcessDataWSModel response = new ProcessDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();

        ProcessDataDAO processDataDAO = processDetailsFramework.removeProcessDataService(processId,dataId);
        if (processDataDAO != null) {
            processDataWSDTOS.add(processDetailsFramework.fillProcessDataWSDTO(processDataDAO));
        }

        response.setProcessDatas(processDataWSDTOS);
        general.setOperation("removeProcessData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ProcessUrlWSModel getProcessUrls(long userId,String processId) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);

        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("getProcessUrls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessUrlWSModel getProcessUrl(long userId,String processId,String urlId) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);


        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("getProcessUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessUrlWSModel createProcessUrl(long userId,String processId,String urlType,String url) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();

        ProcessUrlDAO processUrlDAO = processDetailsFramework.createProcessUrlService(processId,urlType,url);
        if (processUrlDAO != null){
            processUrlWSDTOS.add(processDetailsFramework.fillProcessUrlWSDTO(processUrlDAO));
        }

        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("createProcessUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessUrlWSModel updateProcessUrl(long userId,String processId,String urlId,String urlType,String url) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();

        ProcessUrlDAO processUrlDAO = processDetailsFramework.updateProcessUrlService(processId,urlId,urlType,url);
        if (processUrlDAO != null){
            processUrlWSDTOS.add(processDetailsFramework.fillProcessUrlWSDTO(processUrlDAO));
        }

        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("updateProcessUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessUrlWSModel removeProcessUrl(long userId,String processId, String urlId) {

        ProcessUrlWSModel response = new ProcessUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessUrlWSDTO>processUrlWSDTOS = new ArrayList<>();

        ProcessUrlDAO processUrlDAO = processDetailsFramework.removeProcessUrlService(processId,urlId);
        if (processUrlDAO != null){
            processUrlWSDTOS.add(processDetailsFramework.fillProcessUrlWSDTO(processUrlDAO));
        }

        response.setProcessUrls(processUrlWSDTOS);
        general.setOperation("removeProcessUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ProcessCallScriptWSModel getProcessCallScripts(long userId, String processId) {

        ProcessCallScriptWSModel response = new ProcessCallScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessCallScriptWSDTO> callScriptWSDTOS = processDetailsFramework.getProcessCallScriptsService(processId);
        if (callScriptWSDTOS != null){
            response.setCallScripts(callScriptWSDTOS);
        }

        general.setOperation("getProcessCallScripts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessCallScriptWSModel getProcessCallScript(long userId,String processId, String scriptId) {

        ProcessCallScriptWSModel response = new ProcessCallScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessCallScriptWSDTO> callScriptWSDTOS = new ArrayList<>();

        ProcessCallScriptWSDTO callScriptWSDTO = processDetailsFramework.getProcessCallScriptService(processId,scriptId);
        if (callScriptWSDTO != null){
            callScriptWSDTOS.add(callScriptWSDTO);
        }

        response.setCallScripts(callScriptWSDTOS);
        general.setOperation("getProcessCallScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessCallScriptWSModel createProcessCallScript(long userId,String processId,int scriptOrder,String scriptTitle,String scriptBody) {

        ProcessCallScriptWSModel response = new ProcessCallScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessCallScriptWSDTO> callScriptWSDTOS = new ArrayList<>();

        ProcessCallScriptWSDTO callScriptWSDTO = processDetailsFramework.createProcessCallScriptService(processId,scriptOrder,scriptTitle,scriptBody);
        if (callScriptWSDTO != null){
            callScriptWSDTOS.add(callScriptWSDTO);
        }

        response.setCallScripts(callScriptWSDTOS);
        general.setOperation("createProcessCallScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessCallScriptWSModel updateProcessCallScript(long userId,String processId,String scriptId,int scriptOrder,String scriptTitle,String scriptBody) {

        ProcessCallScriptWSModel response = new ProcessCallScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessCallScriptWSDTO> callScriptWSDTOS = new ArrayList<>();

        ProcessCallScriptWSDTO callScriptWSDTO = processDetailsFramework.updateProcessCallScriptService(processId,scriptId,scriptOrder,scriptTitle,scriptBody);
        if (callScriptWSDTO != null){
            callScriptWSDTOS.add(callScriptWSDTO);
        }

        response.setCallScripts(callScriptWSDTOS);
        general.setOperation("updateProcessCallScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessCallScriptWSModel removeProcessCallScript(long userId,String processId,String scriptId) {

        ProcessCallScriptWSModel response = new ProcessCallScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessCallScriptWSDTO> callScriptWSDTOS = new ArrayList<>();

        ProcessCallScriptWSDTO callScriptWSDTO = processDetailsFramework.removeProcessCallScriptService(processId,scriptId);
        if (callScriptWSDTO != null){
            callScriptWSDTOS.add(callScriptWSDTO);
        }

        response.setCallScripts(callScriptWSDTOS);
        general.setOperation("removeProcessCallScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
