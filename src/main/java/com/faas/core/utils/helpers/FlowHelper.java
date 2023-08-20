package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlowHelper {


    @Autowired
    AppUtils appUtils;


    public List<ApiSummaryWSDTO> agentInquirySummaryHelper(long agentId) {

        return null;
    }




}
