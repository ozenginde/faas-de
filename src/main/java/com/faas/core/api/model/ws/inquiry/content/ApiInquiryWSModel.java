package com.faas.core.api.model.ws.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWrapper;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiInquiryWSModel {

    private GeneralWSModel general;
    private ApiInquiryWrapper inquiry;

    public ApiInquiryWSModel() {
    }

    public ApiInquiryWSModel(GeneralWSModel general, ApiInquiryWrapper inquiry) {
        this.general = general;
        this.inquiry = inquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiInquiryWrapper getInquiry() {
        return inquiry;
    }

    public void setInquiry(ApiInquiryWrapper inquiry) {
        this.inquiry = inquiry;
    }
}
