package com.faas.core.api.model.ws.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiClientInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiClientInquiryWSModel {

    private GeneralWSModel general;
    private List<ApiClientInquiryWSDTO>clientInquiries;

    public ApiClientInquiryWSModel() {
    }

    public ApiClientInquiryWSModel(GeneralWSModel general, List<ApiClientInquiryWSDTO> clientInquiries) {
        this.general = general;
        this.clientInquiries = clientInquiries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiClientInquiryWSDTO> getClientInquiries() {
        return clientInquiries;
    }

    public void setClientInquiries(List<ApiClientInquiryWSDTO> clientInquiries) {
        this.clientInquiries = clientInquiries;
    }
}
