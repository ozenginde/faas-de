package com.faas.core.base.endpoint.controller.direktor.content;

import com.faas.core.base.middleware.direktor.content.DirektorMiddleware;
import com.faas.core.base.model.ws.client.content.AllClientsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/direktor/")
public class DirektorController {


    @Autowired
    DirektorMiddleware direktorMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllClients(@RequestParam long userId,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        AllClientsWSModel response = direktorMiddleware.getAllClients(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
