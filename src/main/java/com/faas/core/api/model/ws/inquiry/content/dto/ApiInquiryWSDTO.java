package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiInquiryWSDTO {

    private List<InquiryDBModel> inquiries;
    private PaginationWSDTO pagination;

    public ApiInquiryWSDTO() {
    }

    public ApiInquiryWSDTO(List<InquiryDBModel> inquiries, PaginationWSDTO pagination) {
        this.inquiries = inquiries;
        this.pagination = pagination;
    }

    public List<InquiryDBModel> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<InquiryDBModel> inquiries) {
        this.inquiries = inquiries;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
