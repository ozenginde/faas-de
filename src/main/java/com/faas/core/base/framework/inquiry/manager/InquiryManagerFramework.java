package com.faas.core.base.framework.inquiry.manager;

import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquiryManagerFramework {


    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;


    public InquiryWSDTO getInquiryDetailsService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }




}
