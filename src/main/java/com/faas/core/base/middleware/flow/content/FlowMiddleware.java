package com.faas.core.base.middleware.flow.content;

import com.faas.core.base.framework.inquiry.content.InquiryFramework;
import com.faas.core.base.model.ws.flow.content.FlowWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FlowMiddleware {


    @Autowired
    InquiryFramework inquiryFramework;


    public FlowWSModel getAllFlows(long userId, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel getFlowsByState(long userId, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getFlowsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel getFlow(long userId, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel createFlow(long userId, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("createFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel updateFlow(long userId, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("updateFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel removeFlow(long userId, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("removeFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
