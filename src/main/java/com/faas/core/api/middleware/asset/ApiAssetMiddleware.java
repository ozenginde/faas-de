package com.faas.core.api.middleware.asset;

import com.faas.core.api.framework.asset.ApiAssetFramework;
import com.faas.core.api.model.ws.asset.ApiAssetWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiAssetMiddleware {

    @Autowired
    ApiAssetFramework apiAssetFramework;

    @Autowired
    AppUtils appUtils;


    public ApiAssetWSModel getAgentAssets(long agentId) {

        ApiAssetWSModel response = new ApiAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();

        general.setOperation("getAgentAssets");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
