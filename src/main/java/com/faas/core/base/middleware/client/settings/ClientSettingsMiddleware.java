package com.faas.core.base.middleware.client.settings;

import com.faas.core.base.framework.client.settings.ClientSettingsFramework;
import com.faas.core.base.model.db.client.settings.ClientTypeDBModel;
import com.faas.core.base.model.ws.client.settings.ClientTypeWSModel;
import com.faas.core.base.model.ws.client.settings.FlowTypeWSModel;
import com.faas.core.base.model.ws.client.settings.InquiryTypeWSModel;
import com.faas.core.base.model.ws.client.settings.SessionTypeWSModel;
import com.faas.core.base.model.ws.client.settings.dto.ClientTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.client.settings.ClientTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientSettingsMiddleware {


    @Autowired
    ClientSettingsFramework clientSettingsFramework;

    @Autowired
    ClientTypeRepository clientTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ClientTypeWSModel getAllClientTypes(long userId) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        List<ClientTypeDBModel> clientTypeDBModels = clientTypeRepository.findByStatus(1);
        for (ClientTypeDBModel clientTypeDBModel : clientTypeDBModels) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("getAllClientTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientTypeWSModel getClientType(long userId, long typeId) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(typeId);
        if (clientTypeDBModel.isPresent()) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel.get()));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("getClientType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientTypeWSModel createClientType(long userId, String clientType) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        ClientTypeDBModel clientTypeDBModel = clientSettingsFramework.createClientTypeService(clientType);
        if (clientTypeDBModel != null) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("createClientType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientTypeWSModel updateClientType(long userId, long typeId, String clientType) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        ClientTypeDBModel clientTypeDBModel = clientSettingsFramework.updateClientTypeService(typeId, clientType);
        if (clientTypeDBModel != null) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("updateClientType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientTypeWSModel removeClientType(long userId, long typeId) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        ClientTypeDBModel clientTypeDBModel = clientSettingsFramework.removeClientTypeService(typeId);
        if (clientTypeDBModel != null) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("removeClientType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public SessionTypeWSModel getAllSessionTypes(long userId) {

        SessionTypeWSModel response = new SessionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllSessionTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionTypeWSModel getSessionType(long userId) {

        SessionTypeWSModel response = new SessionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getSessionType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionTypeWSModel createSessionType(long userId) {

        SessionTypeWSModel response = new SessionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("createSessionType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionTypeWSModel updateSessionType(long userId) {

        SessionTypeWSModel response = new SessionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("updateSessionType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionTypeWSModel removeSessionType(long userId) {

        SessionTypeWSModel response = new SessionTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("removeSessionType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





    public InquiryTypeWSModel getAllInquiryTypes(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllInquiryTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel getInquiryType(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel createInquiryType(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("createInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel updateInquiryType(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("updateInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel removeInquiryType(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("removeInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public FlowTypeWSModel getAllFlowTypes(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getAllFlowTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel getFlowType(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel createFlowType(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("createFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel updateFlowType(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("updateFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel removeFlowType(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("removeFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
