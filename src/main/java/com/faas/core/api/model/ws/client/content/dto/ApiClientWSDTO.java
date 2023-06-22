package com.faas.core.api.model.ws.client.content.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiClientWSDTO {

    private PaginationWSDTO pagination;
    private List<ClientDBModel>clients;

    public ApiClientWSDTO() {
    }

    public ApiClientWSDTO(PaginationWSDTO pagination, List<ClientDBModel> clients) {
        this.pagination = pagination;
        this.clients = clients;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<ClientDBModel> getClients() {
        return clients;
    }

    public void setClients(List<ClientDBModel> clients) {
        this.clients = clients;
    }
}
