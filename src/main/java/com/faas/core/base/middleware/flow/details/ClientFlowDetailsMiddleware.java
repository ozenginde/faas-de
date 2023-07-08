package com.faas.core.base.middleware.flow.details;

import com.faas.core.base.framework.flow.details.ClientFlowDetailsFramework;
import com.faas.core.base.model.ws.flow.content.ClientFlowWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientFlowDetailsMiddleware {


    @Autowired
    ClientFlowDetailsFramework clientFlowDetailsFramework;


    public ClientFlowWSModel getClientFlowDetails(long userId, int reqPage, int reqSize) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getClientFlowDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
