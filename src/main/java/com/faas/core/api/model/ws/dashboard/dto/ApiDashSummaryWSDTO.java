package com.faas.core.api.model.ws.dashboard.dto;

public class ApiDashSummaryWSDTO {

    private String summaryType;
    private String summaryValue;

    public ApiDashSummaryWSDTO() {
    }

    public ApiDashSummaryWSDTO(String summaryType, String summaryValue) {
        this.summaryType = summaryType;
        this.summaryValue = summaryValue;
    }

    public String getSummaryType() {
        return summaryType;
    }

    public void setSummaryType(String summaryType) {
        this.summaryType = summaryType;
    }

    public String getSummaryValue() {
        return summaryValue;
    }

    public void setSummaryValue(String summaryValue) {
        this.summaryValue = summaryValue;
    }
}
