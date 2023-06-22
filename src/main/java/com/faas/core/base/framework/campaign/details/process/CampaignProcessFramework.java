package com.faas.core.base.framework.campaign.details.process;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.campaign.details.process.dto.CampaignProcessWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignProcessFramework {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignProcessWSDTO fillCampaignProcessWSDTO(ProcessDBModel processDBModel) {

        CampaignProcessWSDTO campaignProcessWSDTO = new CampaignProcessWSDTO();
        campaignProcessWSDTO.setCampaignProcess(processDBModel);
        return campaignProcessWSDTO;
    }


    public CampaignProcessWSDTO getCampaignProcessService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.get().getProcessId());
            if (processDBModel.isPresent()){
                return fillCampaignProcessWSDTO(processDBModel.get());
            }
        }
        return null;
    }



    public CampaignProcessWSDTO updateCampaignProcessService(String campaignId, String processId) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignState(campaignId, AppConstant.ACTIVE_CAMPAIGN);
        List<ProcessDBModel> processDBModels = processRepository.findByIdAndProcessState(processId,AppConstant.ACTIVE_PROCESS);
        if (campaignDBModels.size()>0 && processDBModels.size()>0){
            campaignDBModels.get(0).setProcessId(processId);
            campaignDBModels.get(0).setProcess(processDBModels.get(0).getProcess());
            campaignDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignRepository.save(campaignDBModels.get(0));

            return fillCampaignProcessWSDTO(processDBModels.get(0));
        }
        return null;
    }


    public CampaignProcessWSDTO removeCampaignProcessService(String campaignId, String processId) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndProcessId(campaignId,processId);
        if (campaignDBModels.size()>0){
            campaignDBModels.get(0).setProcessId("");
            campaignDBModels.get(0).setProcess("");
            campaignDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            campaignRepository.save(campaignDBModels.get(0));

            Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
            if (processDBModel.isPresent()){
                return fillCampaignProcessWSDTO(processDBModel.get());
            }
        }
        return null;
    }



    public List<ProcessDBModel> getCampaignAssignableProcessesService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            List<ProcessDBModel> processDBModels = processRepository.findByProcessState(AppConstant.ACTIVE_PROCESS);
            for (int i=0;i<processDBModels.size();i++){
                if (processDBModels.get(i).getId().equalsIgnoreCase(campaignDBModel.get().getProcessId())){
                    processDBModels.remove(processDBModels.get(i));
                }
            }
            return processDBModels;
        }
        return null;
    }



}
