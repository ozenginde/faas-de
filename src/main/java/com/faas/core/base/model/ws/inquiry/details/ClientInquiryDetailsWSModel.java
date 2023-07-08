package com.faas.core.base.model.ws.inquiry.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.details.dto.ClientInquiryDetailsWSDTO;

public class ClientInquiryDetailsWSModel {

    private GeneralWSModel general;
    private ClientInquiryDetailsWSDTO inquiryDetails;

    public ClientInquiryDetailsWSModel() {
    }

    public ClientInquiryDetailsWSModel(GeneralWSModel general, ClientInquiryDetailsWSDTO inquiryDetails) {
        this.general = general;
        this.inquiryDetails = inquiryDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientInquiryDetailsWSDTO getInquiryDetails() {
        return inquiryDetails;
    }

    public void setInquiryDetails(ClientInquiryDetailsWSDTO inquiryDetails) {
        this.inquiryDetails = inquiryDetails;
    }
}
