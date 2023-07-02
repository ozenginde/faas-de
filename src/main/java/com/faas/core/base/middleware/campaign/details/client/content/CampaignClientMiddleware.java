package com.faas.core.base.middleware.campaign.details.client.content;

import com.faas.core.base.framework.campaign.details.client.content.CampaignClientFramework;
import com.faas.core.base.model.ws.campaign.details.client.content.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignClientMiddleware {


    @Autowired
    CampaignClientFramework campaignClientFramework;



    public CampaignClientWSModel searchClients(long userId, String city, String country, String clientState, int reqPage, int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignClientFramework.searchClientsService(city,country,clientState,reqPage,reqSize);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("searchClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CampaignClientWSModel getCampaignClients(long userId, String campaignId,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignClientFramework.getCampaignClientsService(userId,campaignId,reqPage,reqSize);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("getCampaignClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientWSModel getCampaignClient(long userId, long clientId) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO>clientWSDTOS = new ArrayList<>();

        ClientWSDTO clientWSDTO = campaignClientFramework.getCampaignClientService(userId,clientId);
        if (clientWSDTO != null){
            clientWSDTOS.add(clientWSDTO);
        }

        response.setClients(clientWSDTOS);
        general.setOperation("getCampaignClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientWSModel updateCampaignClient(long userId, long clientId,String clientState) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO>clientWSDTOS = new ArrayList<>();

        ClientWSDTO clientWSDTO = campaignClientFramework.updateCampaignClientService(userId,clientId,clientState);
        if (clientWSDTO != null){
            clientWSDTOS.add(clientWSDTO);
        }

        response.setClients(clientWSDTOS);
        general.setOperation("updateCampaignClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
