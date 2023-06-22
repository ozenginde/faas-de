package com.faas.core.api.model.ws.operation.details.hook;

import com.faas.core.api.model.ws.operation.details.hook.dto.ApiOperationHookWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationHookWSModel {

    private GeneralWSModel general;
    private ApiOperationHookWSDTO operationHook;


    public ApiOperationHookWSModel() {
    }

    public ApiOperationHookWSModel(GeneralWSModel general, ApiOperationHookWSDTO operationHook) {
        this.general = general;
        this.operationHook = operationHook;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationHookWSDTO getOperationHook() {
        return operationHook;
    }

    public void setOperationHook(ApiOperationHookWSDTO operationHook) {
        this.operationHook = operationHook;
    }
}
