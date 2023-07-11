
package com.faas.core.api.endpoint.controller.assets;

import com.faas.core.api.middleware.assets.ApiAssetMiddleware;
import com.faas.core.api.model.ws.assets.ApiAssetWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/asset/")
public class ApiAssetController {


    @Autowired
    ApiAssetMiddleware apiAssetMiddleware;

    @RequestMapping(value = ApiRoute.API_GET_AGENT_ASSETS, method = RequestMethod.POST)
    public ResponseEntity<?> getAgentAssets(@RequestParam long agentId) {

        ApiAssetWSModel response = apiAssetMiddleware.getAgentAssets(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
