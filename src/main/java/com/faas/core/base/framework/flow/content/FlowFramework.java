package com.faas.core.base.framework.flow.content;

import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;
import com.faas.core.base.repo.inquiry.content.InquiryRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FlowFramework {


    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;


    public List<InquiryWSDTO> getAllInquiriesService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }


    public List<InquiryWSDTO> getInquiriesByStateService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }

    public InquiryWSDTO getInquiryService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }

    public InquiryWSDTO createInquiryService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }


    public InquiryWSDTO updateInquiryService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }

    public InquiryWSDTO removeInquiryService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }


}
