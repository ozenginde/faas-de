package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryDTO;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.InquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InquiryHelper {

    @Autowired
    InquiryMapper inquiryMapper;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public ApiInquiryWSDTO getApiInquiryWSDTO(Page<InquiryDBModel> inquiryModelPage){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();
        List<ApiInquiryDTO> inquiryDTOS = new ArrayList<>();
        for (int i=0;i<inquiryModelPage.getContent().size();i++){
            inquiryDTOS.add(getApiInquiryDTO(inquiryModelPage.getContent().get(i)));
        }
        inquiryWSDTO.setInquiries(inquiryDTOS);
        inquiryWSDTO.setPagination(inquiryMapper.createInquiryPagination(inquiryModelPage));

        return inquiryWSDTO;
    }


    public ApiInquiryDTO getApiInquiryDTO(InquiryDBModel inquiryDBModel){

        ApiInquiryDTO inquiryWrapper = new ApiInquiryDTO();
        inquiryWrapper.setInquiry(inquiryDBModel);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(inquiryDBModel.getSessionId(),inquiryDBModel.getClientId());
        if (!sessionDBModels.isEmpty()){
            inquiryWrapper.setInquirySession(sessionDBModels.get(0));
        }
        return inquiryWrapper;
    }


    public List<ApiSummaryWSDTO> getApiInquirySummary(long agentId) {

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_INQUIRY_SUMMARY, String.valueOf(inquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.READY_INQUIRY))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_INQUIRY_SUMMARY, String.valueOf(inquiryRepository.countByAgentIdAndInquiryState(agentId,AppConstant.ACTIVE_INQUIRY))));

        return apiSummaryWSDTOS;
    }




}
