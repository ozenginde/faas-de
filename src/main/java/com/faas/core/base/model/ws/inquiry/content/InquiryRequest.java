package com.faas.core.base.model.ws.inquiry.content;

import com.faas.core.base.model.ws.inquiry.content.dto.InquiryRequestDTO;
import com.faas.core.base.model.ws.session.content.dto.SessionRequestDTO;

import java.util.List;

public class InquiryRequest {

    private List<InquiryRequestDTO>inquiryRequests;

    public InquiryRequest() {
    }

    public InquiryRequest(List<InquiryRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }

    public List<InquiryRequestDTO> getInquiryRequests() {
        return inquiryRequests;
    }

    public void setInquiryRequests(List<InquiryRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }
}
