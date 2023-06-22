package com.faas.core.api.framework.operation.details.note;

import com.faas.core.api.model.ws.operation.details.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.base.model.db.client.details.ClientNoteDBModel;
import com.faas.core.base.repo.client.details.ClientNoteRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationNoteFramework {

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    AppUtils appUtils;

    public ApiOperationNoteWSDTO apiGetClientNotesService(long agentId,long clientId) {

        ApiOperationNoteWSDTO operationNoteWSDTO = new ApiOperationNoteWSDTO();
        List<ClientNoteDBModel> clientNoteDBModels = clientNoteRepository.findByClientId(clientId);
        operationNoteWSDTO.setClientNotes(clientNoteDBModels);
        return operationNoteWSDTO;
    }


    public ApiOperationNoteWSDTO apiGetOperationNotesService(long agentId, long sessionId, long clientId) {

        ApiOperationNoteWSDTO operationNoteWSDTO = new ApiOperationNoteWSDTO();
        List<ClientNoteDBModel> clientNoteDBModels = clientNoteRepository.findBySessionIdAndClientId(sessionId,clientId);
        operationNoteWSDTO.setClientNotes(clientNoteDBModels);
        return operationNoteWSDTO;
    }


    public ApiOperationNoteWSDTO apiGetOperationNoteService(long agentId, long sessionId, long clientId,long noteId) {

        List<ClientNoteDBModel> clientNoteDBModels = clientNoteRepository.findByIdAndSessionIdAndClientId(noteId,sessionId,clientId);
        if (clientNoteDBModels.size()>0){
            ApiOperationNoteWSDTO operationNoteWSDTO = new ApiOperationNoteWSDTO();
            operationNoteWSDTO.setClientNotes(clientNoteDBModels);
            return operationNoteWSDTO;
        }
        return null;
    }


    public ApiOperationNoteWSDTO apiCreateOperationNoteService(long agentId, long sessionId, long clientId,String noteTitle,String noteText,String noteAsset) {

        ApiOperationNoteWSDTO operationNoteWSDTO =  new ApiOperationNoteWSDTO();
        ClientNoteDBModel clientNoteDBModel = new ClientNoteDBModel();
        clientNoteDBModel.setClientId(clientId);
        clientNoteDBModel.setSessionId(sessionId);
        clientNoteDBModel.setCreatorId(agentId);
        clientNoteDBModel.setNoteTitle(noteTitle);
        clientNoteDBModel.setNoteText(noteText);
        clientNoteDBModel.setNoteAsset(noteAsset);
        clientNoteDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientNoteDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientNoteDBModel.setStatus(1);

        ClientNoteDBModel createdNote = clientNoteRepository.save(clientNoteDBModel);
        List<ClientNoteDBModel>clientNoteDBModels = new ArrayList<>();
        clientNoteDBModels.add(createdNote);
        operationNoteWSDTO.setClientNotes(clientNoteDBModels);

        return operationNoteWSDTO;
    }


    public ApiOperationNoteWSDTO apiUpdateOperationNoteService(long agentId, long sessionId, long clientId,long noteId,String noteTitle,String noteText,String noteAsset) {

        List<ClientNoteDBModel> clientNoteDBModel = clientNoteRepository.findByIdAndSessionIdAndClientId(noteId,sessionId,clientId);
        if (clientNoteDBModel.size()>0){

            ApiOperationNoteWSDTO operationNoteWSDTO =  new ApiOperationNoteWSDTO();
            clientNoteDBModel.get(0).setCreatorId(agentId);
            clientNoteDBModel.get(0).setNoteTitle(noteTitle);
            clientNoteDBModel.get(0).setNoteText(noteText);
            clientNoteDBModel.get(0).setNoteAsset(noteAsset);
            clientNoteDBModel.get(0).setuDate(appUtils.getCurrentTimeStamp());
            clientNoteDBModel.get(0).setStatus(1);

            ClientNoteDBModel updatedNote = clientNoteRepository.save(clientNoteDBModel.get(0));
            List<ClientNoteDBModel>clientNoteDBModels = new ArrayList<>();
            clientNoteDBModels.add(updatedNote);
            operationNoteWSDTO.setClientNotes(clientNoteDBModels);

            return operationNoteWSDTO;
        }
        return null;
    }



    public ApiOperationNoteWSDTO apiRemoveOperationNoteService(long agentId, long sessionId, long clientId,long noteId) {

        List<ClientNoteDBModel> clientNoteDBModels = clientNoteRepository.findByIdAndSessionIdAndClientId(noteId,sessionId,clientId);
        if (clientNoteDBModels.size()>0){
            ApiOperationNoteWSDTO operationNoteWSDTO =  new ApiOperationNoteWSDTO();
            clientNoteRepository.delete(clientNoteDBModels.get(0));
            operationNoteWSDTO.setClientNotes(clientNoteDBModels);

            return operationNoteWSDTO;
        }
        return null;
    }


}
