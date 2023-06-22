package com.faas.core.api.framework.client.content;

import com.faas.core.api.model.ws.client.content.dto.ApiClientWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiClientFramework {

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public ApiClientWSDTO apiGetClientsService(long agentId,int reqPage, int reqSize) {

        ApiClientWSDTO clientWSDTO = new ApiClientWSDTO();
        clientWSDTO.setClients(new ArrayList<>());
        Page<SessionDBModel> sessionsPage = sessionRepository.findAllByAgentId(agentId, PageRequest.of(reqPage,reqSize));
        clientWSDTO.setPagination(sessionMapper.createSessionPaginationWSDTO(sessionsPage));
        if (sessionsPage.getContent().size()>0){
            for (int i=0;i<sessionsPage.getContent().size();i++){
                Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionsPage.getContent().get(i).getClientId());
                if (clientDBModel.isPresent()){
                    clientWSDTO.getClients().add(clientDBModel.get());
                }
            }
        }
        return clientWSDTO;
    }



    public ApiClientWSDTO apiGetClientService(long agentId,long clientId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()){
            ApiClientWSDTO clientWSDTO = new ApiClientWSDTO();
            List<ClientDBModel> clientDBModels = new ArrayList<>();
            clientDBModels.add(clientDBModel.get());
            clientWSDTO.setClients(clientDBModels);
            return clientWSDTO;
        }
        return null;
    }



}
