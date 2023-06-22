package com.faas.core.api.endpoint.controller.agent.profile;

import com.faas.core.utils.config.ApiRoute;
import com.faas.core.api.middleware.agent.profile.ApiAgentProfileMiddleware;
import com.faas.core.api.model.ws.agent.content.ApiAgentWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/profile/")
public class ApiAgentProfileController {


    @Autowired
    ApiAgentProfileMiddleware apiAgentProfileMiddleware;


    @RequestMapping(value = ApiRoute.API_AGENT_LOGIN, method = RequestMethod.POST)
    public ResponseEntity<?> agentLogin(@RequestParam String userEmail,
                                        @RequestParam String password) {

        ApiAgentWSModel response = apiAgentProfileMiddleware.agentLogin(userEmail, password);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
