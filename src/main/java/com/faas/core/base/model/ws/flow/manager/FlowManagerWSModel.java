package com.faas.core.base.model.ws.flow.manager;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;

import java.util.List;

public class FlowManagerWSModel {

    private GeneralWSModel general;
    private List<InquiryWSDTO> inquiries;

    public FlowManagerWSModel() {
    }

    public FlowManagerWSModel(GeneralWSModel general, List<InquiryWSDTO> inquiries) {
        this.general = general;
        this.inquiries = inquiries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<InquiryWSDTO> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<InquiryWSDTO> inquiries) {
        this.inquiries = inquiries;
    }
}
