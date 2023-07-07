package com.faas.core.base.model.ws.inquiry.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;
import com.faas.core.base.model.ws.inquiry.details.dto.InquiryDetailsWSDTO;

import java.util.List;

public class InquiryDetailsWSModel {

    private GeneralWSModel general;
    private InquiryDetailsWSDTO inquiryDetails;

    public InquiryDetailsWSModel() {
    }

    public InquiryDetailsWSModel(GeneralWSModel general, InquiryDetailsWSDTO inquiryDetails) {
        this.general = general;
        this.inquiryDetails = inquiryDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public InquiryDetailsWSDTO getInquiryDetails() {
        return inquiryDetails;
    }

    public void setInquiryDetails(InquiryDetailsWSDTO inquiryDetails) {
        this.inquiryDetails = inquiryDetails;
    }
}
