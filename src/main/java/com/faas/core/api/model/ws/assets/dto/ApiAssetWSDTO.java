package com.faas.core.api.model.ws.assets.dto;

import com.faas.core.base.model.db.assets.content.AssetDBModel;

public class ApiAssetWSDTO {

    private AssetDBModel asset;

    public ApiAssetWSDTO() {
    }

    public ApiAssetWSDTO(AssetDBModel asset) {
        this.asset = asset;
    }

    public AssetDBModel getAsset() {
        return asset;
    }

    public void setAsset(AssetDBModel asset) {
        this.asset = asset;
    }
}
