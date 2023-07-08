package com.faas.core.base.endpoint.controller.flow.details;

import com.faas.core.base.middleware.flow.details.ClientFlowDetailsMiddleware;
import com.faas.core.base.model.ws.flow.content.ClientFlowWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/flow/details/")
public class ClientFlowDetailsController {


    @Autowired
    ClientFlowDetailsMiddleware clientFlowDetailsMiddleware;

    @RequestMapping(value = BaseRoute.GET_CLIENT_FLOW_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientFlowDetails(@RequestParam long userId,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        ClientFlowWSModel response = clientFlowDetailsMiddleware.getClientFlowDetails(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
