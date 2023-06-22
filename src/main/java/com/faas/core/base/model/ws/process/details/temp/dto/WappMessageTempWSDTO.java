package com.faas.core.base.model.ws.process.details.temp.dto;

import com.faas.core.base.model.db.process.details.temp.WappMessageTempDBModel;

public class WappMessageTempWSDTO {

    private WappMessageTempDBModel wappMessageTemp;

    public WappMessageTempWSDTO() {
    }

    public WappMessageTempWSDTO(WappMessageTempDBModel wappMessageTemp) {
        this.wappMessageTemp = wappMessageTemp;
    }

    public WappMessageTempDBModel getWappMessageTemp() {
        return wappMessageTemp;
    }

    public void setWappMessageTemp(WappMessageTempDBModel wappMessageTemp) {
        this.wappMessageTemp = wappMessageTemp;
    }
}
