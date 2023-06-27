package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientAddressRepository;
import com.faas.core.base.repo.client.details.ClientDataRepository;
import com.faas.core.base.repo.client.details.ClientEmailRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


@Component
public class ClientMapper {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignClientWSDTO mapCampaignClientWSDTO(Page<ClientDBModel>clientDBModels){

        CampaignClientWSDTO campaignClientWSDTO = new CampaignClientWSDTO();


        return campaignClientWSDTO;
    }


    public PaginationWSDTO createClientPaginationWSDTO(Page<ClientDBModel> clientPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(clientPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(clientPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(clientPage.getTotalPages());
        paginationWSDTO.setTotalElements(clientPage.getTotalElements());

        return paginationWSDTO;
    }



}
