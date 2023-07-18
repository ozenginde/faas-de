package com.faas.core.remote.service.assets;

import com.faas.core.api.model.ws.agent.content.ApiAgentWSModel;
import com.faas.core.api.model.ws.agent.content.dto.ApiAgentWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteAssetService {


    @Autowired
    AppUtils appUtils;


    public ApiAgentWSModel remoteAssetService(long agentId) {


        return null;
    }



}
