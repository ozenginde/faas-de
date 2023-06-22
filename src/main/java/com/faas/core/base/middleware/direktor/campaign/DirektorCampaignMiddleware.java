package com.faas.core.base.middleware.direktor.campaign;

import com.faas.core.base.framework.direktor.campaign.DirektorCampaignFramework;
import com.faas.core.base.framework.direktor.inquiry.DirektorInquiryFramework;
import com.faas.core.base.model.ws.client.content.AllClientsWSModel;
import com.faas.core.base.model.ws.client.content.dto.AllClientsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DirektorCampaignMiddleware {


    @Autowired
    DirektorCampaignFramework direktorCampaignFramework;


    public AllClientsWSModel getAllClients(long userId, int reqPage, int reqSize) {

        AllClientsWSModel response = new AllClientsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        AllClientsWSDTO allClientsWSDTO = new AllClientsWSDTO();


        general.setOperation("getAllClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
