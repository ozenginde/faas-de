package com.faas.core.base.framework.inquiry.details;

import com.faas.core.base.model.ws.inquiry.content.dto.ClientInquiryWSDTO;
import com.faas.core.base.repo.inquiry.ClientInquiryRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquiryDetailsFramework {


    @Autowired
    ClientInquiryRepository clientInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public ClientInquiryWSDTO getInquiryDetailsService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }




}
