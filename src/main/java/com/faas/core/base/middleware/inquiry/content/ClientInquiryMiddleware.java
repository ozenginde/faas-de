package com.faas.core.base.middleware.inquiry.content;

import com.faas.core.base.framework.inquiry.content.InquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.InquiryCampaignWSModel;
import com.faas.core.base.model.ws.inquiry.content.ClientInquiryWSModel;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryCampaignWSDTO;
import com.faas.core.base.model.ws.inquiry.content.dto.ClientInquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientInquiryMiddleware {


    @Autowired
    InquiryFramework inquiryFramework;


    public ClientInquiryWSModel getAllClientInquiries(long userId, int reqPage, int reqSize) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientInquiryWSDTO> clientInquiryWSDTOS =  inquiryFramework.getAllClientInquiriesService(userId,reqPage,reqSize);
        if (clientInquiryWSDTOS != null){
            response.setClientInquiries(clientInquiryWSDTOS);
        }

        general.setOperation("getAllClientInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel getClientInquiriesByState(long userId, String inquiryState, int reqPage, int reqSize) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientInquiryWSDTO> clientInquiryWSDTOS =  inquiryFramework.getClientInquiriesByStateService(userId,inquiryState,reqPage,reqSize);
        if (clientInquiryWSDTOS != null){
            response.setClientInquiries(clientInquiryWSDTOS);
        }

        general.setOperation("getClientInquiriesByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryCampaignWSModel getInquiryCampaigns(long userId,int reqPage,int reqSize) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS =  inquiryFramework.getInquiryCampaignsService(userId,reqPage,reqSize);
        if (inquiryCampaignWSDTOS != null){
            response.setInquiryCampaigns(inquiryCampaignWSDTOS);
        }

        general.setOperation("getInquiryCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryCampaignWSModel getInquiryCampaign(long userId,String campaignId,int reqPage,int reqSize) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS = new ArrayList<>();

        InquiryCampaignWSDTO inquiryCampaignWSDTO =  inquiryFramework.getInquiryCampaignService(userId,campaignId,reqPage,reqSize);
        if (inquiryCampaignWSDTO != null){
            inquiryCampaignWSDTOS.add(inquiryCampaignWSDTO);
        }

        response.setInquiryCampaigns(inquiryCampaignWSDTOS);
        general.setOperation("getInquiryCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel getClientInquiry(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO =  inquiryFramework.getClientInquiryService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("getClientInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel createClientInquiry(long userId, String campaignId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO =  inquiryFramework.createClientInquiryService(userId,campaignId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("createClientInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel updateClientInquiry(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO =  inquiryFramework.updateClientInquiryService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("updateClientInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel removeClientInquiry(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO =  inquiryFramework.removeClientInquiryService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("removeClientInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
