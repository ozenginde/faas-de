package com.faas.core.base.framework.process.details.flow;

import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessFlowFramework {

    @Autowired
    AppUtils appUtils;


    public ProcessDetailsWSDTO getProcessDetailsService(String processId) {

        return null;
    }



}
