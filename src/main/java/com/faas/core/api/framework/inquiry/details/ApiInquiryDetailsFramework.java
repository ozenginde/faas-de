package com.faas.core.api.framework.inquiry.details;

import com.faas.core.api.model.ws.inquiry.details.dto.ApiInquiryDetailsWSDTO;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import com.faas.core.utils.mapper.InquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiInquiryDetailsFramework {

    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    InquiryMapper inquiryMapper;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;


    public ApiInquiryDetailsWSDTO apiGetInquiryDetailsService(long agentId, long inquiryId){

        ApiInquiryDetailsWSDTO inquiryDetailsWSDTO = new ApiInquiryDetailsWSDTO();
        return inquiryDetailsWSDTO;
    }





}
