package com.faas.core.api.middleware.operation.details.note;

import com.faas.core.api.framework.operation.details.note.ApiOperationNoteFramework;
import com.faas.core.api.model.ws.operation.details.note.ApiOperationNoteWSModel;
import com.faas.core.api.model.ws.operation.details.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationNoteMiddleware {


    @Autowired
    ApiOperationNoteFramework apiOperationNoteFramework;


    public ApiOperationNoteWSModel apiGetClientNotes(long agentId,long clientId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationNoteFramework.apiGetClientNotesService(agentId,clientId);
        if (operationNoteWSDTO != null){
            response.setOperationNote(operationNoteWSDTO);
        }

        general.setOperation("apiGetOperationNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationNoteWSModel apiGetOperationNotes(long agentId, long sessionId, long clientId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationNoteFramework.apiGetOperationNotesService(agentId,sessionId,clientId);
        if (operationNoteWSDTO != null){
            response.setOperationNote(operationNoteWSDTO);
        }

        general.setOperation("apiGetOperationNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationNoteWSModel apiGetOperationNote(long agentId, long sessionId, long clientId,long noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationNoteWSDTO  operationNoteWSDTO = apiOperationNoteFramework.apiGetOperationNoteService(agentId,sessionId,clientId,noteId);
        if (operationNoteWSDTO != null){
            response.setOperationNote(operationNoteWSDTO);
        }

        general.setOperation("apiGetOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationNoteWSModel apiCreateOperationNote(long agentId, long sessionId, long clientId,String noteTitle,String noteText,String noteAsset) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationNoteFramework.apiCreateOperationNoteService(agentId,sessionId,clientId,noteTitle,noteText,noteAsset);
        if (operationNoteWSDTO != null){
            response.setOperationNote(operationNoteWSDTO);
        }

        general.setOperation("apiCreateOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationNoteWSModel apiUpdateOperationNote(long agentId, long sessionId, long clientId,long noteId,String noteTitle,String noteText,String noteAsset) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationNoteFramework.apiUpdateOperationNoteService(agentId,sessionId,clientId,noteId,noteTitle,noteText,noteAsset);
        if (operationNoteWSDTO != null){
            response.setOperationNote(operationNoteWSDTO);
        }

        general.setOperation("apiUpdateOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationNoteWSModel apiRemoveOperationNote(long agentId, long sessionId, long clientId,long noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationNoteFramework.apiRemoveOperationNoteService(agentId,sessionId,clientId,noteId);
        if (operationNoteWSDTO != null){
            response.setOperationNote(operationNoteWSDTO);
        }

        general.setOperation("apiRemoveOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
