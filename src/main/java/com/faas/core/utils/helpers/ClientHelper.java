package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.client.content.dto.ApiClientWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ClientHelper {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    AppUtils appUtils;


    public ApiClientWSDTO createApiClientWSDTO(Page<ClientDBModel> clientsPage) {

        ApiClientWSDTO apiClientWSDTO = new ApiClientWSDTO();
        apiClientWSDTO.setClients(clientsPage.getContent());
        PaginationWSDTO paginationWSDTO = clientMapper.createClientPaginationWSDTO(clientsPage);
        if (paginationWSDTO != null){
            apiClientWSDTO.setPagination(paginationWSDTO);
        }
        return apiClientWSDTO;
    }


}
