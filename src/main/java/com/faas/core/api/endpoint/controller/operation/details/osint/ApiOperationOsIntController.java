package com.faas.core.api.endpoint.controller.operation.details.osint;

import com.faas.core.api.middleware.operation.details.osint.ApiOperationOsIntMiddleware;
import com.faas.core.api.model.ws.operation.details.osint.ApiOperationOsIntWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/osint/")
public class ApiOperationOsIntController {


    @Autowired
    ApiOperationOsIntMiddleware apiOperationOsIntMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_OS_INT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationOsInt(@RequestParam long agentId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam long clientId) {

        ApiOperationOsIntWSModel response = apiOperationOsIntMiddleware.apiGetOperationOsInt(agentId,sessionId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
