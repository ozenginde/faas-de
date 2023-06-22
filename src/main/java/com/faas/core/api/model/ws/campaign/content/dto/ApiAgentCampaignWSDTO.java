package com.faas.core.api.model.ws.campaign.content.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;

import java.util.List;

public class ApiAgentCampaignWSDTO {

    private List<ApiCampaignWSDTO> manualCampaigns;
    private List<ApiCampaignWSDTO> automaticCampaigns;
    private List<ApiSummaryWSDTO> campaignSummary;
    private List<ApiInquiryWSDTO> campaignInquiries;

    public ApiAgentCampaignWSDTO() {
    }


    public ApiAgentCampaignWSDTO(List<ApiCampaignWSDTO> manualCampaigns, List<ApiCampaignWSDTO> automaticCampaigns, List<ApiSummaryWSDTO> campaignSummary, List<ApiInquiryWSDTO> campaignInquiries) {
        this.manualCampaigns = manualCampaigns;
        this.automaticCampaigns = automaticCampaigns;
        this.campaignSummary = campaignSummary;
        this.campaignInquiries = campaignInquiries;
    }

    public List<ApiCampaignWSDTO> getManualCampaigns() {
        return manualCampaigns;
    }

    public void setManualCampaigns(List<ApiCampaignWSDTO> manualCampaigns) {
        this.manualCampaigns = manualCampaigns;
    }

    public List<ApiCampaignWSDTO> getAutomaticCampaigns() {
        return automaticCampaigns;
    }

    public void setAutomaticCampaigns(List<ApiCampaignWSDTO> automaticCampaigns) {
        this.automaticCampaigns = automaticCampaigns;
    }

    public List<ApiSummaryWSDTO> getCampaignSummary() {
        return campaignSummary;
    }

    public void setCampaignSummary(List<ApiSummaryWSDTO> campaignSummary) {
        this.campaignSummary = campaignSummary;
    }

    public List<ApiInquiryWSDTO> getCampaignInquiries() {
        return campaignInquiries;
    }

    public void setCampaignInquiries(List<ApiInquiryWSDTO> campaignInquiries) {
        this.campaignInquiries = campaignInquiries;
    }
}
