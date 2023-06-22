package com.faas.core.api.framework.client.details;

import com.faas.core.api.model.ws.client.details.dto.ApiClientDetailsWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientHookWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.session.details.dto.ApiSessionDetailsWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.session.details.dto.SessionDetailsWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientAddressRepository;
import com.faas.core.base.repo.client.details.ClientDataRepository;
import com.faas.core.base.repo.client.details.ClientEmailRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiClientDetailsFramework {


    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    AppUtils appUtils;


    public ApiClientDetailsWSDTO apiGetClientDetailsService(long agentId, long clientId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()){

            ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();
            List<ApiSessionDetailsWSDTO>clientSessions = new ArrayList<>();

            clientDetailsWSDTO.setClient(clientDBModel.get());
            clientDetailsWSDTO.setClientDatas(clientDataRepository.findByClientId(clientId));
            clientDetailsWSDTO.setClientAddresses(clientAddressRepository.findByClientId(clientId));
            clientDetailsWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientId));
            clientDetailsWSDTO.setClientEmails(clientEmailRepository.findByClientId(clientId));

            List<SessionDBModel> sessionDBModels = sessionRepository.findByClientId(clientId);
            for (SessionDBModel sessionDBModel : sessionDBModels) {
                clientSessions.add(sessionMapper.mapApiSessionDetailsWSDTO(sessionDBModel));
            }
            clientDetailsWSDTO.setClientSessions(clientSessions);

            return clientDetailsWSDTO;
        }
        return null;
    }


    public List<ApiSummaryWSDTO> apiGetClientSummaryService(long agentId) {

        return null;
    }


    public List<ApiClientHookWSDTO> apiGetClientHookService(long agentId, long clientId) {

        return null;
    }


    public List<ApiClientOsIntWSDTO> apiGetClientOsIntService(long agentId, long clientId) {

        return null;
    }



}
