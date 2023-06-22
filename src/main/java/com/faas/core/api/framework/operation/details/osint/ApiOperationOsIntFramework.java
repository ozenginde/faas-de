package com.faas.core.api.framework.operation.details.osint;

import com.faas.core.api.model.ws.operation.details.osint.dto.ApiOperationOsIntWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationOsIntFramework {

    @Autowired
    AppUtils appUtils;

    public ApiOperationOsIntWSDTO apiGetOperationOsIntService(){

        ApiOperationOsIntWSDTO operationClientOsIntWSDTO = new ApiOperationOsIntWSDTO();
        return operationClientOsIntWSDTO;
    }




}
