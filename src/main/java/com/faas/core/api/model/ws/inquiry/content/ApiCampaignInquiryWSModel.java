package com.faas.core.api.model.ws.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiCampaignInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiCampaignInquiryWSModel {

    private GeneralWSModel general;
    private ApiCampaignInquiryWSDTO campaignInquiry;

    public ApiCampaignInquiryWSModel() {
    }

    public ApiCampaignInquiryWSModel(GeneralWSModel general, ApiCampaignInquiryWSDTO campaignInquiry) {
        this.general = general;
        this.campaignInquiry = campaignInquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiCampaignInquiryWSDTO getCampaignInquiry() {
        return campaignInquiry;
    }

    public void setCampaignInquiry(ApiCampaignInquiryWSDTO campaignInquiry) {
        this.campaignInquiry = campaignInquiry;
    }
}
