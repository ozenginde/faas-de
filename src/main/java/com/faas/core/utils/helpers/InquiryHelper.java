package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InquiryHelper {

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;




    public List<ApiSummaryWSDTO> agentInquirySummaryHelper(long agentId) {

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_INQUIRY_SUMMARY, String.valueOf(inquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.READY_INQUIRY))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_INQUIRY_SUMMARY, String.valueOf(inquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.ACTIVE_INQUIRY))));

        return apiSummaryWSDTOS;
    }




}
