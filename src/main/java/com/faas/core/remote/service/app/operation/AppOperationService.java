package com.faas.core.remote.service.app.operation;

import com.faas.core.api.model.ws.agent.content.ApiAgentWSModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AppOperationService {


    @Autowired
    AppUtils appUtils;


    public ApiAgentWSModel apiAgentLogin(long agentId) {


        return null;
    }




}
