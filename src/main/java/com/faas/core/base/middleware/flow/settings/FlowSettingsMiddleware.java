package com.faas.core.base.middleware.flow.settings;

import com.faas.core.base.framework.flow.settings.FlowSettingsFramework;
import com.faas.core.base.model.ws.flow.settings.FlowTypeWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FlowSettingsMiddleware {


    @Autowired
    FlowSettingsFramework flowSettingsFramework;


    public FlowTypeWSModel getAllFlowTypes(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getAllFlowTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel getFlowType(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel createFlowType(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("createFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel updateFlowType(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("updateFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel removeFlowType(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("removeFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
