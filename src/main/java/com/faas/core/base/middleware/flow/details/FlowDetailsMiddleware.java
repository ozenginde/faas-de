package com.faas.core.base.middleware.flow.details;

import com.faas.core.base.framework.flow.details.FlowDetailsFramework;
import com.faas.core.base.model.ws.flow.content.FlowWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FlowDetailsMiddleware {


    @Autowired
    FlowDetailsFramework flowDetailsFramework;


    public FlowWSModel getFlowDetails(long userId, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
