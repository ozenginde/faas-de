package com.faas.core.base.framework.flow.manager;

import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FlowManagerFramework {


    @Autowired
    AppUtils appUtils;


    public InquiryWSDTO getFlowDetailsService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }


}
