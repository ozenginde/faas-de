package com.faas.core.base.model.ws.campaign.details.session.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.session.content.dto.SessionWSDTO;

import java.util.List;

public class CampaignSessionWSDTO {

    private PaginationWSDTO pagination;
    private List<SessionWSDTO> sessions;

    public CampaignSessionWSDTO() {
    }

    public CampaignSessionWSDTO(PaginationWSDTO pagination, List<SessionWSDTO> sessions) {
        this.pagination = pagination;
        this.sessions = sessions;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<SessionWSDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionWSDTO> sessions) {
        this.sessions = sessions;
    }
}
