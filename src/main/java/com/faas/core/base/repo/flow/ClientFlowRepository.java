package com.faas.core.base.repo.flow;

import com.faas.core.base.model.db.flow.ClientFlowDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientFlowRepository extends PagingAndSortingRepository<ClientFlowDBModel, Long> {

    boolean existsByClientIdAndCampaignIdAndFlowState(long clientId,String campaignId,String flowState);
    List<ClientFlowDBModel>findByStatus(int status);
    List<ClientFlowDBModel>findBySessionId(long sessionId);
    List<ClientFlowDBModel>findByIdAndClientId(long flowId, long clientId);
    List<ClientFlowDBModel>findByFlowState(String flowState);
    List<ClientFlowDBModel>findByCampaignIdAndFlowState(String campaignId, String flowState);
    List<ClientFlowDBModel>findByCampaignIdAndAgentIdAndFlowState(String campaignId, long agentId, String flowState);
    List<ClientFlowDBModel>findBySessionIdAndClientId(long sessionId, long clientId);
    Page<ClientFlowDBModel>findAllByCampaignId(String campaignId, Pageable pageable);
    Page<ClientFlowDBModel>findAllByFlowState(String flowState, Pageable pageable);
    Page<ClientFlowDBModel>findAllByCampaignIdAndClientCityAndClientCountry(String campaignId, String city, String country, Pageable pageable);

}
