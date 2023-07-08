package com.faas.core.base.middleware.process.details.flow;

import com.faas.core.base.framework.process.details.flow.ProcessFlowFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDetailsWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProcessFlowMiddleware {


    @Autowired
    ProcessFlowFramework processFlowFramework;


    public ProcessDetailsWSModel getProcessDetails(long userId, String processId) {

        ProcessDetailsWSModel response = new ProcessDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getProcessDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
