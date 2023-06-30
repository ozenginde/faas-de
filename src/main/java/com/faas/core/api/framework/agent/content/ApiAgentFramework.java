package com.faas.core.api.framework.agent.content;

import com.faas.core.api.model.ws.agent.content.dto.ApiAgentWSDTO;
import com.faas.core.api.model.ws.agent.content.dto.ApiAgentSipAccountWSDTO;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSipChannelDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSipChannelRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.base.repo.user.settings.UserRoleRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiAgentFramework {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    SipAccountRepository sipAccountRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentWSDTO fillAgentApiAgentWSDTO(UserDBModel userDBModel) {

        ApiAgentWSDTO apiAgentWSDTO = new ApiAgentWSDTO();
        userDBModel.setPassword("");
        apiAgentWSDTO.setAgent(userDBModel);

        return apiAgentWSDTO;
    }

    public ApiAgentWSDTO apiAgentLoginService(String userEmail, String password) {

        List<UserDBModel> userDBModels = userRepository.findByUserEmailAndPasswordAndUserTypeAndValidUser(userEmail.toLowerCase(), appUtils.base64Encoder(password), AppConstant.AGENT_USER, true);
        if (userDBModels.size() > 0) {
            return fillAgentApiAgentWSDTO(userDBModels.get(0));
        }
        return null;
    }


    public ApiAgentSipAccountWSDTO apiGetAgentSipAccountService(long agentId, String processId) {

        ApiAgentSipAccountWSDTO sipAccountWSDTO = new ApiAgentSipAccountWSDTO();
        List<ProcessSipChannelDBModel> sipChannels = processSipChannelRepository.findByProcessId(processId);
        if (sipChannels.size()>0){
            sipAccountWSDTO.setSipChannel(sipChannels.get(0));
        }
        List<UserDetailsDBModel> userDetails = userDetailsRepository.findByUserId(agentId);
        if (userDetails.size()>0 && userDetails.get(0).getSipChannel() != null){
            sipAccountWSDTO.setSipAccount(userDetails.get(0).getSipChannel());
        }
        return sipAccountWSDTO;
    }


}
