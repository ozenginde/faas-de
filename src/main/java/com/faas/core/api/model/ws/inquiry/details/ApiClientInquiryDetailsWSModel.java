package com.faas.core.api.model.ws.inquiry.details;

import com.faas.core.api.model.ws.inquiry.details.dto.ApiClientInquiryDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiClientInquiryDetailsWSModel {

    private GeneralWSModel general;
    private ApiClientInquiryDetailsWSDTO clientInquiryDetails;

    public ApiClientInquiryDetailsWSModel() {
    }

    public ApiClientInquiryDetailsWSModel(GeneralWSModel general, ApiClientInquiryDetailsWSDTO clientInquiryDetails) {
        this.general = general;
        this.clientInquiryDetails = clientInquiryDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiClientInquiryDetailsWSDTO getClientInquiryDetails() {
        return clientInquiryDetails;
    }

    public void setClientInquiryDetails(ApiClientInquiryDetailsWSDTO clientInquiryDetails) {
        this.clientInquiryDetails = clientInquiryDetails;
    }
}
