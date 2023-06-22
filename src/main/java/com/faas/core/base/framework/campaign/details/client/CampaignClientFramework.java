package com.faas.core.base.framework.campaign.details.client;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
public class CampaignClientFramework {

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;





}
