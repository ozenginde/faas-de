package com.faas.core.api.model.ws.session.content.dto;

import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiSessionWSDTO {

    private PaginationWSDTO pagination;
    private List<SessionDBModel> sessions;

    public ApiSessionWSDTO() {
    }

    public ApiSessionWSDTO(PaginationWSDTO pagination, List<SessionDBModel> sessions) {
        this.pagination = pagination;
        this.sessions = sessions;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<SessionDBModel> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDBModel> sessions) {
        this.sessions = sessions;
    }
}
