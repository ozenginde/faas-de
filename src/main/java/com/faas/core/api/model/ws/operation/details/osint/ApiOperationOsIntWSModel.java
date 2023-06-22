package com.faas.core.api.model.ws.operation.details.osint;

import com.faas.core.api.model.ws.operation.details.osint.dto.ApiOperationOsIntWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationOsIntWSModel {

    private GeneralWSModel general;
    private ApiOperationOsIntWSDTO operationOSInt;

    public ApiOperationOsIntWSModel() {
    }

    public ApiOperationOsIntWSModel(GeneralWSModel general, ApiOperationOsIntWSDTO operationOSInt) {
        this.general = general;
        this.operationOSInt = operationOSInt;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationOsIntWSDTO getOperationOSInt() {
        return operationOSInt;
    }

    public void setOperationOSInt(ApiOperationOsIntWSDTO operationOSInt) {
        this.operationOSInt = operationOSInt;
    }
}
