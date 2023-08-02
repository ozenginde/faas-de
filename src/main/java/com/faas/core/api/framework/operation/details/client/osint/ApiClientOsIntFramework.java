package com.faas.core.api.framework.operation.details.client.osint;

import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiClientOsIntWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiClientOsIntFramework {

    @Autowired
    AppUtils appUtils;


    public ApiClientOsIntWSDTO apiGetClientOsIntService(){

        ApiClientOsIntWSDTO clientOsIntWSDTO = new ApiClientOsIntWSDTO();
        return clientOsIntWSDTO;
    }


}
