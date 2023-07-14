package com.faas.core.api.model.ws.dashboard;

import com.faas.core.api.model.ws.dashboard.dto.ApiDashSummaryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiDashSummaryWSModel {

    private GeneralWSModel general;
    private List<ApiDashSummaryWSDTO> dashSummaries;

    public ApiDashSummaryWSModel() {
    }

    public ApiDashSummaryWSModel(GeneralWSModel general, List<ApiDashSummaryWSDTO> dashSummaries) {
        this.general = general;
        this.dashSummaries = dashSummaries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiDashSummaryWSDTO> getDashSummaries() {
        return dashSummaries;
    }

    public void setDashSummaries(List<ApiDashSummaryWSDTO> dashSummaries) {
        this.dashSummaries = dashSummaries;
    }
}
