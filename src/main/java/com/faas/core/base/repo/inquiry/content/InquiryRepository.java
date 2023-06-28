package com.faas.core.base.repo.inquiry.content;

import com.faas.core.base.model.db.inquiry.content.InquiryDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends PagingAndSortingRepository<InquiryDBModel, Long> {

    long countByAgentIdAndInquiryState(long agentId,String inquiryState);
    List<InquiryDBModel> findByStatus(int status);
    List<InquiryDBModel>findByInquiryState(String inquiryState);
    List<InquiryDBModel>findByAgentIdAndInquiryState(long agentId,String inquiryState);
    List<InquiryDBModel>findByCampaignIdAndInquiryState(String campaignId,String inquiryState);
    List<InquiryDBModel>findByCampaignIdAndAgentIdAndInquiryState(String campaignId,long agentId,String inquiryState);
    List<InquiryDBModel>findBySessionIdAndClientId(long sessionId,long clientId);



}
