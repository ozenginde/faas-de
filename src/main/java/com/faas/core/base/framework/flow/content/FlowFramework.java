package com.faas.core.base.framework.flow.content;

import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;
import com.faas.core.base.repo.inquiry.InquiryRepository;
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


    public List<InquiryWSDTO> getAllFlowsService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }

    public List<InquiryWSDTO> getFlowsByStateService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }

    public InquiryWSDTO getFlowService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }

    public InquiryWSDTO createFlowService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }

    public InquiryWSDTO updateFlowService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }

    public InquiryWSDTO removeFlowService(long userId, String clientState, int reqPage, int reqSize) {

        return null;
    }


}
