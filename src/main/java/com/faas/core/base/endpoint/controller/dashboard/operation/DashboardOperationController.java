package com.faas.core.base.endpoint.controller.dashboard.operation;

import com.faas.core.base.middleware.dashboard.operation.DashboardOperationMiddleware;
import com.faas.core.base.model.ws.client.content.AllClientsWSModel;
import com.faas.core.base.model.ws.dashboard.operation.DashboardOperationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/dashboard/operation/")
public class DashboardOperationController {


    @Autowired
    DashboardOperationMiddleware dashboardOperationMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getDashboardOperations(@RequestParam long userId,
                                                    @RequestParam int reqPage,
                                                    @RequestParam int reqSize) {

        DashboardOperationWSModel response = dashboardOperationMiddleware.getDashboardOperations(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
