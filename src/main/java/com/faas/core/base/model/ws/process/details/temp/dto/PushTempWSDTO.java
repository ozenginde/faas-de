package com.faas.core.base.model.ws.process.details.temp.dto;

import com.faas.core.base.model.db.process.details.temp.PushTempDBModel;

public class PushTempWSDTO {

    private PushTempDBModel pushTemp;

    public PushTempWSDTO() {
    }

    public PushTempWSDTO(PushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }

    public PushTempDBModel getPushTemp() {
        return pushTemp;
    }

    public void setPushTemp(PushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }
}
