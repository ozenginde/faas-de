package com.faas.core.api.endpoint.controller.session.details;

import com.faas.core.api.middleware.session.details.ApiSessionDetailsMiddleware;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.session.details.ApiSessionDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/session/details/")
public class ApiSessionDetailsController {


    @Autowired
    ApiSessionDetailsMiddleware apiSessionDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_SESSION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSessionDetails(@RequestParam long agentId,
                                                  @RequestParam long sessionId) {

        ApiSessionDetailsWSModel response = apiSessionDetailsMiddleware.apiGetSessionDetails(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SESSION_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetSessionSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiSessionDetailsMiddleware.apiGetSessionSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
