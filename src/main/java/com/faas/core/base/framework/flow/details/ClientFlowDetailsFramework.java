package com.faas.core.base.framework.flow.details;

import com.faas.core.base.model.ws.inquiry.content.dto.ClientInquiryWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientFlowDetailsFramework {


    @Autowired
    AppUtils appUtils;


    public ClientInquiryWSDTO getFlowDetailsService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }


}
