package com.faas.core.api.framework.operation.details.hook;

import com.faas.core.api.model.ws.operation.details.hook.dto.ApiOperationHookWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationHookFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationHookWSDTO apiGetOperationHookService(){

        ApiOperationHookWSDTO operationRemoteWSDTO = new ApiOperationHookWSDTO();

        return operationRemoteWSDTO;
    }



}
