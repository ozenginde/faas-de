package com.faas.core.base.middleware.campaign.details.process;

import com.faas.core.base.framework.campaign.details.process.CampaignProcessFramework;
import com.faas.core.base.framework.process.content.ProcessFramework;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.campaign.details.process.CampaignProcessWSModel;
import com.faas.core.base.model.ws.campaign.details.process.dto.CampaignProcessWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.content.ProcessWSModel;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignProcessMiddleware {


    @Autowired
    CampaignProcessFramework campaignProcessFramework;

    @Autowired
    ProcessFramework processFramework;

    @Autowired
    AppUtils appUtils;



    public CampaignProcessWSModel getCampaignProcess(long userId, String campaignId) {

        CampaignProcessWSModel response = new CampaignProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignProcessWSDTO campaignProcessWSDTO = campaignProcessFramework.getCampaignProcessService(campaignId);
        if (campaignProcessWSDTO != null){
            response.setCampaignProcess(campaignProcessWSDTO);
        }

        general.setOperation("getCampaignProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignProcessWSModel updateCampaignProcess(long userId, String campaignId, String processId) {

        CampaignProcessWSModel response = new CampaignProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignProcessWSDTO campaignProcessWSDTO = campaignProcessFramework.updateCampaignProcessService(campaignId,processId);
        if (campaignProcessWSDTO != null){
            response.setCampaignProcess(campaignProcessWSDTO);
        }

        general.setOperation("updateCampaignProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignProcessWSModel removeCampaignProcess(long userId, String campaignId, String processId) {

        CampaignProcessWSModel response = new CampaignProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignProcessWSDTO campaignProcessWSDTO = campaignProcessFramework.removeCampaignProcessService(campaignId,processId);
        if (campaignProcessWSDTO != null){
            response.setCampaignProcess(campaignProcessWSDTO);
        }

        general.setOperation("removeCampaignProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessWSModel getCampaignAssignableProcesses(long userId,String campaignId) {

        ProcessWSModel response = new ProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessWSDTO>processWSDTOS = new ArrayList<>();

        List<ProcessDBModel> processDBModels = campaignProcessFramework.getCampaignAssignableProcessesService(campaignId);
        for (ProcessDBModel processDBModel : processDBModels) {
            processWSDTOS.add(processFramework.fillProcessWSDTO(processDBModel));
        }

        response.setProcesses(processWSDTOS);
        general.setOperation("getCampaignAssignableProcesses");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
