package com.faas.core.base.framework.inquiry.content;

import com.faas.core.base.model.ws.inquiry.content.dto.InquiryCampaignWSDTO;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class InquiryFramework {


    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;


    public List<InquiryWSDTO> getAllInquiriesService(long userId, int reqPage, int reqSize) {

        return null;
    }


    public List<InquiryWSDTO> getInquiriesByStateService(long userId,String inquiryState, int reqPage, int reqSize) {

        return null;
    }


    public List<InquiryCampaignWSDTO> getInquiryCampaignsService(long userId) {

        return null;
    }


    public InquiryCampaignWSDTO getInquiryCampaignService(long userId,String campaignId) {

        return null;
    }


    public InquiryWSDTO getInquiryService(long userId, long inquiryId,long clientId) {

        return null;
    }

    public InquiryWSDTO createInquiryService(long userId, String campaignId,long clientId) {

        return null;
    }


    public InquiryWSDTO updateInquiryService(long userId, long inquiryId,long clientId) {

        return null;
    }

    public InquiryWSDTO removeInquiryService(long userId,long inquiryId,long clientId) {

        return null;
    }


}
