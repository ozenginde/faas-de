package com.faas.core.base.middleware.process.details.trigger;

import com.faas.core.base.framework.process.details.trigger.ProcessTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.ProcessTriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProcessTriggerMiddleware {


    @Autowired
    ProcessTriggerFramework processTriggerFramework;


    public ProcessTriggerWSModel getProcessTrigger(long userId,String processId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.getProcessTriggerService(userId,processId);
        if (processTriggerWSDTO != null){
            response.setProcessTrigger(processTriggerWSDTO);;
        }

        general.setOperation("getProcessTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel createSmsTrigger(long userId,String processId,String title,String body,String senderId,String triggerType,String accountId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.createSmsTriggerService(userId,processId,title,body,senderId,triggerType,accountId);
        if (processTriggerWSDTO != null){
            response.setProcessTrigger(processTriggerWSDTO);;
        }

        general.setOperation("createSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel removeSmsTrigger(long userId,String processId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.removeSmsTriggerService(userId,processId);
        if (processTriggerWSDTO != null){
            response.setProcessTrigger(processTriggerWSDTO);;
        }

        general.setOperation("removeSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel createWappTrigger(long userId,String processId,String title,String body,String triggerType,String accountId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.createWappTriggerService(userId,processId,title,body,triggerType,accountId);
        if (processTriggerWSDTO != null){
            response.setProcessTrigger(processTriggerWSDTO);;
        }

        general.setOperation("createWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessTriggerWSModel removeWappTrigger(long userId,String processId) {

        ProcessTriggerWSModel response = new ProcessTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTriggerWSDTO processTriggerWSDTO = processTriggerFramework.removeWappTriggerService(userId,processId);
        if (processTriggerWSDTO != null){
            response.setProcessTrigger(processTriggerWSDTO);;
        }

        general.setOperation("removeWappTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
