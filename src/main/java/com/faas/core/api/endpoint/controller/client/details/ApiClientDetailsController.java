package com.faas.core.api.endpoint.controller.client.details;

import com.faas.core.api.middleware.client.details.ApiClientDetailsMiddleware;
import com.faas.core.api.model.ws.client.details.ApiClientDetailsWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientHookWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientOsIntWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/client/details/")
public class ApiClientDetailsController {


    @Autowired
    ApiClientDetailsMiddleware apiClientDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientDetails(@RequestParam long agentId,
                                                 @RequestParam long clientId) {

        ApiClientDetailsWSModel response = apiClientDetailsMiddleware.apiGetClientDetails(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_HOOK, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientHook(@RequestParam long agentId,
                                              @RequestParam long clientId) {

        ApiClientHookWSModel response = apiClientDetailsMiddleware.apiGetClientHook(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_OS_INT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientOsInt(@RequestParam long agentId,
                                               @RequestParam long clientId) {

        ApiClientOsIntWSModel response = apiClientDetailsMiddleware.apiGetClientOsInt(agentId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
