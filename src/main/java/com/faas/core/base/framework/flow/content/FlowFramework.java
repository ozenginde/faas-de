package com.faas.core.base.framework.flow.content;

import com.faas.core.base.model.ws.flow.content.dto.FlowCampaignWSDTO;
import com.faas.core.base.model.ws.flow.content.dto.FlowWSDTO;
import com.faas.core.base.repo.flow.FlowRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FlowFramework {


    @Autowired
    FlowRepository flowRepository;

    @Autowired
    AppUtils appUtils;


    public List<FlowWSDTO> getAllFlowsService(long userId, int reqPage, int reqSize) {

        return null;
    }

    public List<FlowWSDTO> getFlowsByStateService(long userId,String flowState, int reqPage, int reqSize) {

        return null;
    }


    public List<FlowCampaignWSDTO> getFlowCampaignsService(long userId) {

        return null;
    }

    public FlowCampaignWSDTO getFlowCampaignService(long userId,String campaignId) {

        return null;
    }


    public FlowWSDTO getFlowService(long userId,long flowId,long clientId) {

        return null;
    }

    public FlowWSDTO createFlowService(long userId, long clientId,String campaignId) {

        return null;
    }

    public FlowWSDTO updateFlowService(long userId,long flowId,long clientId) {

        return null;
    }

    public FlowWSDTO removeFlowService(long userId,long flowId,long clientId) {

        return null;
    }


}
