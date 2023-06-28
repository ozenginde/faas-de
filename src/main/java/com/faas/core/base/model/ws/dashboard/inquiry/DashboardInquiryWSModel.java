package com.faas.core.base.model.ws.dashboard.inquiry;

import com.faas.core.base.model.ws.dashboard.inquiry.dto.DashboardInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class DashboardInquiryWSModel {

    private GeneralWSModel general;
    private List<DashboardInquiryWSDTO>dashboardInquiries;

    public DashboardInquiryWSModel() {
    }

    public DashboardInquiryWSModel(GeneralWSModel general, List<DashboardInquiryWSDTO> dashboardInquiries) {
        this.general = general;
        this.dashboardInquiries = dashboardInquiries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<DashboardInquiryWSDTO> getDashboardInquiries() {
        return dashboardInquiries;
    }

    public void setDashboardInquiries(List<DashboardInquiryWSDTO> dashboardInquiries) {
        this.dashboardInquiries = dashboardInquiries;
    }
}
