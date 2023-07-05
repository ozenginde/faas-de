package com.faas.core.base.repo.inquiry;

import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends PagingAndSortingRepository<InquiryDBModel, Long> {

    long countByAgentIdAndInquiryState(long agentId,String inquiryState);
    List<InquiryDBModel>findByStatus(int status);
    List<InquiryDBModel>findByIdAndClientId(long inquiryId,long clientId);
    List<InquiryDBModel>findByInquiryState(String inquiryState);
    List<InquiryDBModel>findByAgentIdAndInquiryState(long agentId,String inquiryState);
    List<InquiryDBModel>findByCampaignIdAndInquiryState(String campaignId,String inquiryState);
    List<InquiryDBModel>findByCampaignIdAndAgentIdAndInquiryState(String campaignId,long agentId,String inquiryState);
    List<InquiryDBModel>findBySessionIdAndClientId(long sessionId,long clientId);
    Page<InquiryDBModel>findAllByCampaignId(String campaignId, Pageable pageable);
    Page<InquiryDBModel>findAllByCampaignIdAndClientCityAndClientCountry(String campaignId,String city,String country,Pageable pageable);


}
