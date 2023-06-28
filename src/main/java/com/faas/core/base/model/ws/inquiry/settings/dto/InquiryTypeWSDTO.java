package com.faas.core.base.model.ws.inquiry.settings.dto;

import com.faas.core.base.model.db.inquiry.settings.InquiryTypeDBModel;

public class InquiryTypeWSDTO {

    private InquiryTypeDBModel inquiryType;

    public InquiryTypeWSDTO() {
    }

    public InquiryTypeWSDTO(InquiryTypeDBModel inquiryType) {
        this.inquiryType = inquiryType;
    }

    public InquiryTypeDBModel getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(InquiryTypeDBModel inquiryType) {
        this.inquiryType = inquiryType;
    }
}
