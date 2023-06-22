package com.faas.core.base.endpoint.controller.operation.channel;

import com.faas.core.base.middleware.operation.channel.OperationChannelMiddleware;
import com.faas.core.base.model.ws.session.content.SessionWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/channel/")
public class OperationChannelController {


    @Autowired
    OperationChannelMiddleware operationChannelMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllSessions(@RequestParam long userId,
                                            @RequestParam int reqPage,
                                            @RequestParam int reqSize) {

        SessionWSModel response = operationChannelMiddleware.getAllSessions(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
