package com.faas.core.base.model.ws.campaign.details.content.dto;


import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.campaign.details.agent.dto.CampaignAgentWSDTO;
import com.faas.core.base.model.ws.campaign.details.process.dto.CampaignProcessWSDTO;
import com.faas.core.base.model.ws.campaign.details.session.dto.CampaignSessionWSDTO;

import java.util.List;

public class CampaignDetailsWSDTO {

    private CampaignDBModel campaign;
    private CampaignProcessWSDTO campaignProcess;
    private List<CampaignAgentWSDTO> campaignAgents;
    private CampaignSessionWSDTO campaignSession;

    public CampaignDetailsWSDTO() {
    }

    public CampaignDetailsWSDTO(CampaignDBModel campaign, CampaignProcessWSDTO campaignProcess, List<CampaignAgentWSDTO> campaignAgents, CampaignSessionWSDTO campaignSession) {
        this.campaign = campaign;
        this.campaignProcess = campaignProcess;
        this.campaignAgents = campaignAgents;
        this.campaignSession = campaignSession;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignProcessWSDTO getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(CampaignProcessWSDTO campaignProcess) {
        this.campaignProcess = campaignProcess;
    }

    public List<CampaignAgentWSDTO> getCampaignAgents() {
        return campaignAgents;
    }

    public void setCampaignAgents(List<CampaignAgentWSDTO> campaignAgents) {
        this.campaignAgents = campaignAgents;
    }

    public CampaignSessionWSDTO getCampaignSession() {
        return campaignSession;
    }

    public void setCampaignSession(CampaignSessionWSDTO campaignSession) {
        this.campaignSession = campaignSession;
    }
}
