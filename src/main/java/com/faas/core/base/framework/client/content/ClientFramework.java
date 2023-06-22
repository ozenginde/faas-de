package com.faas.core.base.framework.client.content;

import com.faas.core.base.framework.client.details.ClientDetailsFramework;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.settings.ClientTypeDBModel;
import com.faas.core.base.model.db.utils.location.CityDBModel;
import com.faas.core.base.model.db.utils.location.CountryDBModel;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientsByStateWSDTO;
import com.faas.core.base.model.ws.client.content.dto.CreateClientRequestWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientAddressRepository;
import com.faas.core.base.repo.client.details.ClientDataRepository;
import com.faas.core.base.repo.client.details.ClientEmailRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.client.settings.ClientTypeRepository;
import com.faas.core.base.repo.operation.channel.*;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.utils.location.CityRepository;
import com.faas.core.base.repo.utils.location.CountryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ClientFramework {


    @Autowired
    ClientMapper clientMapper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsFramework clientDetailsFramework;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientTypeRepository clientTypeRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    EmailMessageRepository emailMessageRepository;

    @Autowired
    PushMessageRepository pushMessageRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    AppUtils appUtils;


    public ClientsByStateWSDTO fillClientsWSDTO(Page<ClientDBModel> clientDBModelPage) {

        ClientsByStateWSDTO clientsByStateWSDTO = new ClientsByStateWSDTO();
        List<ClientWSDTO>clientWSDTOS = new ArrayList<>();
        for (int i=0;i<clientDBModelPage.getContent().size();i++){
            clientWSDTOS.add(fillClientWSDTO(clientDBModelPage.getContent().get(i)));
        }
        clientsByStateWSDTO.setClients(clientWSDTOS);
        clientsByStateWSDTO.setPagination(clientMapper.createClientPaginationWSDTO(clientDBModelPage));

        return clientsByStateWSDTO;
    }


    public ClientsByStateWSDTO getClientsByStateService(long userId, String clientState, int reqPage, int reqSize) {

        if (clientState.equalsIgnoreCase(AppConstant.ALL_CLIENTS)){
            return fillClientsWSDTO(clientRepository.findAllByStatus(1,PageRequest.of(reqPage,reqSize))) ;
        }
            return fillClientsWSDTO(clientRepository.findAllByClientStateAndStatus(clientState,1,PageRequest.of(reqPage,reqSize)));
    }


    public ClientWSDTO fillClientWSDTO(ClientDBModel clientDBModel) {

        ClientWSDTO clientWSDTO = new ClientWSDTO();
        clientWSDTO.setClient(clientDBModel);
        return clientWSDTO;
    }


    public ClientDBModel createClientService(String clientTitle,String clientName,String nationalId,String phoneNumber,String emailAddress,String clientCity,String clientCountry,long clientTypeId) {

        if (clientRepository.findByPhoneNumber(phoneNumber).size() == 0){

            ClientDBModel clientDBModel = new ClientDBModel();
            clientDBModel.setClientTitle(clientTitle);
            clientDBModel.setClientName(clientName);
            clientDBModel.setNationalId(nationalId);
            clientDBModel.setPhoneNumber(phoneNumber);
            clientDBModel.setEmailAddress(emailAddress);
            clientDBModel.setClientCity(clientCity);
            clientDBModel.setClientCountry(clientCountry);
            Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(clientTypeId);
            if (clientTypeDBModel.isPresent()) {
                clientDBModel.setClientTypeId(clientTypeId);
                clientDBModel.setClientType(clientTypeDBModel.get().getClientType());
            }
            clientDBModel.setClientState(AppConstant.READY_CLIENT);
            clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setcDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setStatus(1);

            ClientDBModel createdClient = clientRepository.save(clientDBModel);
            createClientDetailsService(createdClient);
            checkAndInsertCityAndCountry(createdClient);

            return createdClient;
        }
        return null;
    }


    public ClientDBModel createVolumeClientService(CreateClientRequestWSDTO clientRequestWSDTO) {

        if (clientRepository.findByPhoneNumber(clientRequestWSDTO.getPhoneNumber()).size() == 0){

            ClientDBModel clientDBModel = new ClientDBModel();
            clientDBModel.setClientTitle(clientRequestWSDTO.getClientTitle());
            clientDBModel.setClientName(clientRequestWSDTO.getClientName());
            clientDBModel.setNationalId(clientRequestWSDTO.getNationalId());
            clientDBModel.setPhoneNumber(clientRequestWSDTO.getPhoneNumber());
            clientDBModel.setEmailAddress(clientRequestWSDTO.getEmailAddress());
            clientDBModel.setClientCity(clientRequestWSDTO.getClientCity());
            clientDBModel.setClientCountry(clientRequestWSDTO.getClientCountry());
            List<ClientTypeDBModel> clientTypeDBModels = clientTypeRepository.findByClientType(clientRequestWSDTO.getClientType());
            if (clientTypeDBModels.size()>0) {
                clientDBModel.setClientTypeId(clientTypeDBModels.get(0).getId());
                clientDBModel.setClientType(clientTypeDBModels.get(0).getClientType());
            }

            clientDBModel.setClientState(AppConstant.READY_CLIENT);
            clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setcDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setStatus(1);

            ClientDBModel createdClient = clientRepository.save(clientDBModel);
            createClientDetailsService(createdClient);
            checkAndInsertCityAndCountry(createdClient);

            return createdClient;
        }
        return null;
    }


    public void checkAndInsertCityAndCountry(ClientDBModel clientDBModel){

        if (!cityRepository.existsByCityAndCountry(clientDBModel.getClientCity().toLowerCase(),clientDBModel.getClientCountry().toLowerCase())){

            CityDBModel cityDBModel = new CityDBModel();
            cityDBModel.setCity(clientDBModel.getClientCity().toLowerCase());
            cityDBModel.setCountry(clientDBModel.getClientCountry().toLowerCase());
            cityDBModel.setuDate(appUtils.getCurrentTimeStamp());
            cityDBModel.setcDate(appUtils.getCurrentTimeStamp());
            cityDBModel.setStatus(1);

            cityRepository.save(cityDBModel);
        }
        if (!countryRepository.existsByCountry(clientDBModel.getClientCountry().toLowerCase())){

            CountryDBModel countryDBModel = new CountryDBModel();
            countryDBModel.setCountry(clientDBModel.getClientCountry().toLowerCase());
            countryDBModel.setuDate(appUtils.getCurrentTimeStamp());
            countryDBModel.setcDate(appUtils.getCurrentTimeStamp());
            countryDBModel.setStatus(1);

            countryRepository.save(countryDBModel);
        }
    }




    public void createClientDetailsService(ClientDBModel clientDBModel){

        if (clientDBModel.getPhoneNumber() != null &&
                !clientDBModel.getPhoneNumber().equalsIgnoreCase("")){
            clientDetailsFramework.createClientPhoneService(clientDBModel.getId(),clientDBModel.getPhoneNumber());
        }
        if (clientDBModel.getEmailAddress() != null &&
                !clientDBModel.getEmailAddress().equalsIgnoreCase("")){
            clientDetailsFramework.createClientEmailService(clientDBModel.getId(),clientDBModel.getEmailAddress());
        }
    }


    public ClientDBModel updateClientService(long clientId,String clientTitle,String clientName,String nationalId,String phoneNumber,String emailAddress,String clientCity,String clientCountry,long clientTypeId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()) {

            clientDBModel.get().setClientTitle(clientTitle);
            clientDBModel.get().setClientName(clientName);
            clientDBModel.get().setNationalId(nationalId);
            clientDBModel.get().setPhoneNumber(phoneNumber);
            clientDBModel.get().setEmailAddress(emailAddress);
            clientDBModel.get().setClientCity(clientCity);
            clientDBModel.get().setClientCountry(clientCountry);
            Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(clientTypeId);
            if (clientTypeDBModel.isPresent()) {
                clientDBModel.get().setClientTypeId(clientTypeId);
                clientDBModel.get().setClientType(clientTypeDBModel.get().getClientType());
            }
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientDBModel.get().setcDate(appUtils.getCurrentTimeStamp());
            clientDBModel.get().setStatus(1);

            return clientRepository.save(clientDBModel.get());
        }
        return null;
    }


    public void removeClientService(long clientId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()){

            clientRepository.delete(clientDBModel.get());
            clientDataRepository.deleteAll(clientDataRepository.findByClientId(clientId));
            clientAddressRepository.deleteAll(clientAddressRepository.findByClientId(clientId));
            clientPhoneRepository.deleteAll(clientPhoneRepository.findByClientId(clientId));
            clientEmailRepository.deleteAll(clientEmailRepository.findByClientId(clientId));
            sessionRepository.deleteAll(sessionRepository.findByClientId(clientId));
            operationRepository.deleteAll(operationRepository.findByClientId(clientId));
            emailMessageRepository.deleteAll(emailMessageRepository.findByClientId(clientId));
            pushMessageRepository.deleteAll(pushMessageRepository.findByClientId(clientId));
            sipCallRepository.deleteAll(sipCallRepository.findByClientId(clientId));
            smsMessageRepository.deleteAll(smsMessageRepository.findByClientId(clientId));
            wappCallRepository.deleteAll(wappCallRepository.findByClientId(clientId));
            wappMessageRepository.deleteAll(wappMessageRepository.findByClientId(clientId));
        }
    }






}
