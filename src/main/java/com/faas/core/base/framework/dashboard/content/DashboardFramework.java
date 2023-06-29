package com.faas.core.base.framework.dashboard.content;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.client.content.dto.ClientsByStateWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


@Component
public class DashboardFramework {


    @Autowired
    AppUtils appUtils;


    public ClientsByStateWSDTO getDashboardService() {

        ClientsByStateWSDTO clientsByStateWSDTO = new ClientsByStateWSDTO();


        return clientsByStateWSDTO;
    }



}