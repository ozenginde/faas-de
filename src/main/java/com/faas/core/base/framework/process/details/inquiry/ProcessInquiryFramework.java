package com.faas.core.base.framework.process.details.inquiry;

import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessInquiryFramework {


    @Autowired
    AppUtils appUtils;


    public ProcessDetailsWSDTO getProcessDetailsService(String processId) {

        return null;
    }




}
