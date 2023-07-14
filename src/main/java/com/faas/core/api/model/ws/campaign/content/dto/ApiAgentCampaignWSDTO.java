package com.faas.core.api.model.ws.campaign.content.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;

import java.util.List;

public class ApiAgentCampaignWSDTO {

    private List<ApiCampaignWSDTO> manualCampaigns;
    private List<ApiCampaignWSDTO> inquiryCampaigns;
    private List<ApiSummaryWSDTO> campaignSummary;

    public ApiAgentCampaignWSDTO() {
    }

    public ApiAgentCampaignWSDTO(List<ApiCampaignWSDTO> manualCampaigns, List<ApiCampaignWSDTO> inquiryCampaigns, List<ApiSummaryWSDTO> campaignSummary) {
        this.manualCampaigns = manualCampaigns;
        this.inquiryCampaigns = inquiryCampaigns;
        this.campaignSummary = campaignSummary;
    }

    public List<ApiCampaignWSDTO> getManualCampaigns() {
        return manualCampaigns;
    }

    public void setManualCampaigns(List<ApiCampaignWSDTO> manualCampaigns) {
        this.manualCampaigns = manualCampaigns;
    }

    public List<ApiCampaignWSDTO> getInquiryCampaigns() {
        return inquiryCampaigns;
    }

    public void setInquiryCampaigns(List<ApiCampaignWSDTO> inquiryCampaigns) {
        this.inquiryCampaigns = inquiryCampaigns;
    }

    public List<ApiSummaryWSDTO> getCampaignSummary() {
        return campaignSummary;
    }

    public void setCampaignSummary(List<ApiSummaryWSDTO> campaignSummary) {
        this.campaignSummary = campaignSummary;
    }
}
