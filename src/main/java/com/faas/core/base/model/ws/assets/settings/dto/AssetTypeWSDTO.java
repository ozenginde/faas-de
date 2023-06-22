package com.faas.core.base.model.ws.assets.settings.dto;

import com.faas.core.base.model.db.assets.settings.AssetTypeDBModel;

public class AssetTypeWSDTO {

    private AssetTypeDBModel assetType;

    public AssetTypeWSDTO() {
    }

    public AssetTypeWSDTO(AssetTypeDBModel assetType) {
        this.assetType = assetType;
    }

    public AssetTypeDBModel getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetTypeDBModel assetType) {
        this.assetType = assetType;
    }
}
