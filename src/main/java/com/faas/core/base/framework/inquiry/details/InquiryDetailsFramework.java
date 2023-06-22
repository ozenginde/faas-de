package com.faas.core.base.framework.inquiry.details;

import com.faas.core.base.model.ws.inquiry.details.dto.InquiryDetailsWSDTO;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquiryDetailsFramework {


    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;


    public InquiryDetailsWSDTO getInquiryDetailsService(long userId, long inquiryId) {

            return null;
    }


}
