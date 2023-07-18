package com.faas.core.base.repo.inquiry;

import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends PagingAndSortingRepository<InquiryDBModel,Long> {

    boolean existsByClientIdAndCampaignId(long clientId,String campaignId);
    long countByAgentIdAndInquiryState(long agentId,String inquiryState);
    List<InquiryDBModel>findByStatus(int status);
    List<InquiryDBModel>findByIdAndClientId(long inquiryId, long clientId);
    List<InquiryDBModel>findByInquiryState(String inquiryState);
    List<InquiryDBModel>findByAgentIdAndInquiryState(long agentId, String inquiryState);
    List<InquiryDBModel>findByCampaignIdAndInquiryState(String campaignId, String inquiryState);
    List<InquiryDBModel>findByCampaignIdAndAgentIdAndInquiryState(String campaignId, long agentId, String inquiryState);
    List<InquiryDBModel>findBySessionIdAndClientId(long sessionId, long clientId);
    Page<InquiryDBModel>findAllByInquiryState(String inquiryState, Pageable pageable);
    Page<InquiryDBModel>findAllByAgentId(long agentId,Pageable pageable);
    Page<InquiryDBModel>findAllByAgentIdAndInquiryState(long agentId,String inquiryState,Pageable pageable);
    Page<InquiryDBModel>findAllByCampaignId(String campaignId, Pageable pageable);
    Page<InquiryDBModel>findAllByAgentIdAndCampaignId(long agentId,String campaignId);
    Page<InquiryDBModel>findAllByAgentIdAndCampaignIdAndInquiryState(long agentId,String campaignId,String inquiryState);
    Page<InquiryDBModel>findAllByCampaignIdAndClientCityAndClientCountry(String campaignId,String clientCity,String clientCountry,Pageable pageable);

}
