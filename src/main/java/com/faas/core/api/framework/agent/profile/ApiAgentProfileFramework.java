package com.faas.core.api.framework.agent.profile;

import com.faas.core.api.model.ws.agent.content.dto.ApiAgentWSDTO;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiAgentProfileFramework {



    @Autowired
    AppUtils appUtils;


    public ApiAgentWSDTO fillAgentApiAgentWSDTO(UserDBModel userDBModel) {

        ApiAgentWSDTO apiAgentWSDTO = new ApiAgentWSDTO();

        return apiAgentWSDTO;
    }



}
