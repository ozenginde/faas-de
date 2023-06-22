package com.faas.core.base.middleware.campaign.details.client;

import com.faas.core.base.framework.campaign.details.client.CampaignClientFramework;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.campaign.details.client.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CampaignClientMiddleware {

    @Autowired
    CampaignClientFramework campaignClientFramework;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;



    public CampaignClientWSModel getCampaignClients(long userId,String campaignId,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignClientWSDTO>campaignClientWSDTOS = new ArrayList<>();


        general.setOperation("getCampaignClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignClientWSModel getCampaignClientsByState(long userId,String campaignId,String clientState,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignClientWSDTO>campaignClientWSDTOS = new ArrayList<>();


        general.setOperation("getCampaignClientsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CampaignClientWSModel getCampaignClient(long userId,long clientId) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignClientWSDTO>campaignClientWSDTOS = new ArrayList<>();



        general.setOperation("getCampaignClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
