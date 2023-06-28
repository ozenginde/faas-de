package com.faas.core.base.endpoint.controller.flow.details;

import com.faas.core.base.middleware.flow.details.FlowDetailsMiddleware;
import com.faas.core.base.model.ws.flow.content.FlowWSModel;
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
public class FlowDetailsController {


    @Autowired
    FlowDetailsMiddleware flowDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_FLOW_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowDetails(@RequestParam long userId,
                                            @RequestParam int reqPage,
                                            @RequestParam int reqSize) {

        FlowWSModel response = flowDetailsMiddleware.getFlowDetails(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
