package com.faas.core.base.model.ws.utils.variables.dto;

import com.faas.core.base.model.db.utils.variables.DataTypeDBModel;


public class DataTypeWSDTO {

    private DataTypeDBModel dataType;

    public DataTypeWSDTO() {
    }

    public DataTypeWSDTO(DataTypeDBModel dataType) {
        this.dataType = dataType;
    }

    public DataTypeDBModel getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeDBModel dataType) {
        this.dataType = dataType;
    }
}
