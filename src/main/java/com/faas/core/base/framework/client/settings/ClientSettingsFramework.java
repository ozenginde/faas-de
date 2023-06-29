package com.faas.core.base.framework.client.settings;

import com.faas.core.base.model.db.client.settings.ClientTypeDBModel;
import com.faas.core.base.model.db.client.settings.SessionTypeDBModel;
import com.faas.core.base.model.ws.client.settings.dto.ClientTypeWSDTO;
import com.faas.core.base.model.ws.client.settings.dto.SessionTypeWSDTO;
import com.faas.core.base.repo.client.settings.ClientTypeRepository;
import com.faas.core.base.repo.client.settings.SessionTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ClientSettingsFramework {


    @Autowired
    ClientTypeRepository clientTypeRepository;

    @Autowired
    SessionTypeRepository sessionTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ClientTypeWSDTO fillClientTypeWSDTO(ClientTypeDBModel clientTypeDBModel) {

        ClientTypeWSDTO clientTypeWSDTO = new ClientTypeWSDTO();
        clientTypeWSDTO.setClientType(clientTypeDBModel);
        return clientTypeWSDTO;
    }


    public ClientTypeDBModel createClientTypeService(String clientType) {

        ClientTypeDBModel clientTypeDBModel = new ClientTypeDBModel();
        clientTypeDBModel.setClientType(clientType);
        clientTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientTypeDBModel.setStatus(1);

        return clientTypeRepository.save(clientTypeDBModel);
    }

    public ClientTypeDBModel updateClientTypeService(long typeId, String clientType) {

        Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(typeId);
        if (clientTypeDBModel.isPresent()) {
            clientTypeDBModel.get().setClientType(clientType);
            clientTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientTypeDBModel.get().setStatus(1);

            return clientTypeRepository.save(clientTypeDBModel.get());
        }
        return null;
    }


    public ClientTypeDBModel removeClientTypeService(long clientTypeId) {

        Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(clientTypeId);
        if (clientTypeDBModel.isPresent()) {
            clientTypeRepository.delete(clientTypeDBModel.get());
            return clientTypeDBModel.get();
        }
        return null;
    }


    public List<SessionTypeWSDTO> getAllSessionTypesService(long userId) {

        List<SessionTypeWSDTO> sessionTypeWSDTOS = new ArrayList<>();
        List<SessionTypeDBModel> sessionTypeDBModels = sessionTypeRepository.findByStatus(1);
        for (SessionTypeDBModel sessionTypeDBModel : sessionTypeDBModels) {
            sessionTypeWSDTOS.add(new SessionTypeWSDTO(sessionTypeDBModel));
        }
        return sessionTypeWSDTOS;
    }


    public SessionTypeWSDTO getSessionTypeService(long userId,long typeId) {

        Optional<SessionTypeDBModel> sessionTypeDBModel = sessionTypeRepository.findById(typeId);
        if (sessionTypeDBModel.isPresent()) {
            return new SessionTypeWSDTO(sessionTypeDBModel.get());
        }
        return null;
    }

    public SessionTypeWSDTO createSessionTypeService(long userId,String sessionType) {

        SessionTypeDBModel sessionTypeDBModel = new SessionTypeDBModel();
        sessionTypeDBModel.setSessionType(sessionType);
        sessionTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sessionTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        sessionTypeDBModel.setStatus(1);

        return new SessionTypeWSDTO(sessionTypeRepository.save(sessionTypeDBModel));
    }

    public SessionTypeWSDTO updateSessionTypeService(long userId,long typeId,String sessionType) {

        Optional<SessionTypeDBModel> sessionTypeDBModel = sessionTypeRepository.findById(typeId);
        if (sessionTypeDBModel.isPresent()){

            sessionTypeDBModel.get().setSessionType(sessionType);
            sessionTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            sessionTypeDBModel.get().setStatus(1);

            return new SessionTypeWSDTO(sessionTypeRepository.save(sessionTypeDBModel.get()));
        }
        return null;
    }

    public SessionTypeWSDTO removeSessionTypeService(long userId,long typeId) {

        Optional<SessionTypeDBModel> sessionTypeDBModel = sessionTypeRepository.findById(typeId);
        if (sessionTypeDBModel.isPresent()){
            sessionTypeRepository.delete(sessionTypeDBModel.get());
            return new SessionTypeWSDTO(sessionTypeDBModel.get());
        }
        return null;
    }


}
