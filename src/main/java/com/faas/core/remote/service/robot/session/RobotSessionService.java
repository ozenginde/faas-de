package com.faas.core.remote.service.robot.session;

import com.faas.core.api.model.ws.agent.content.ApiAgentWSModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RobotSessionService {


    @Autowired
    AppUtils appUtils;


    public ApiAgentWSModel remoteRobotService(long agentId) {


        return null;
    }


}
