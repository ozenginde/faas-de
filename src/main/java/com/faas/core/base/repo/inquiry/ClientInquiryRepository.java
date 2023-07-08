package com.faas.core.base.repo.inquiry;

import com.faas.core.base.model.db.inquiry.ClientInquiryDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientInquiryRepository extends PagingAndSortingRepository<ClientInquiryDBModel, Long> {

    long countByAgentIdAndInquiryState(long agentId,String inquiryState);
    List<ClientInquiryDBModel>findByStatus(int status);
    List<ClientInquiryDBModel>findByIdAndClientId(long inquiryId, long clientId);
    List<ClientInquiryDBModel>findByInquiryState(String inquiryState);
    List<ClientInquiryDBModel>findByAgentIdAndInquiryState(long agentId, String inquiryState);
    List<ClientInquiryDBModel>findByCampaignIdAndInquiryState(String campaignId, String inquiryState);
    List<ClientInquiryDBModel>findByCampaignIdAndAgentIdAndInquiryState(String campaignId, long agentId, String inquiryState);
    List<ClientInquiryDBModel>findBySessionIdAndClientId(long sessionId, long clientId);
    Page<ClientInquiryDBModel>findAllByCampaignId(String campaignId, Pageable pageable);
    Page<ClientInquiryDBModel>findAllByInquiryState(String inquiryState, Pageable pageable);
    Page<ClientInquiryDBModel>findAllByCampaignIdAndClientCityAndClientCountry(String campaignId, String city, String country, Pageable pageable);


}
