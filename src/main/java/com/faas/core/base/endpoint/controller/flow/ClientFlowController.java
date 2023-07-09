package com.faas.core.base.endpoint.controller.flow;

import com.faas.core.base.middleware.flow.ClientFlowMiddleware;
import com.faas.core.base.model.ws.flow.FlowCampaignWSModel;
import com.faas.core.base.model.ws.flow.ClientFlowWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/flow/")
public class ClientFlowController {


    @Autowired
    ClientFlowMiddleware clientFlowMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENT_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllClientFlows(@RequestParam long userId,
                                               @RequestParam int reqPage,
                                               @RequestParam int reqSize) {

        ClientFlowWSModel response = clientFlowMiddleware.getAllClientFlows(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_FLOWS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getClientFlowsByState(@RequestParam long userId,
                                                   @RequestParam String flowState,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        ClientFlowWSModel response = clientFlowMiddleware.getClientFlowsByState(userId,flowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_FLOW_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowCampaigns(@RequestParam long userId,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        FlowCampaignWSModel response = clientFlowMiddleware.getFlowCampaigns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_FLOW_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowCampaign(@RequestParam long userId,
                                             @RequestParam String campaignId,
                                             @RequestParam int reqPage,
                                             @RequestParam int reqSize) {

        FlowCampaignWSModel response = clientFlowMiddleware.getFlowCampaign(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> getClientFlow(@RequestParam long userId,
                                           @RequestParam long flowId,
                                           @RequestParam long clientId) {

        ClientFlowWSModel response = clientFlowMiddleware.getClientFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CLIENT_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> createClientFlow(@RequestParam long userId,
                                              @RequestParam long clientId,
                                              @RequestParam String campaignId) {

        ClientFlowWSModel response = clientFlowMiddleware.createClientFlow(userId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CLIENT_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> updateClientFlow(@RequestParam long userId,
                                              @RequestParam long flowId,
                                              @RequestParam long clientId) {

        ClientFlowWSModel response = clientFlowMiddleware.updateClientFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CLIENT_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> removeClientFlow(@RequestParam long userId,
                                              @RequestParam long flowId,
                                              @RequestParam long clientId) {

        ClientFlowWSModel response = clientFlowMiddleware.removeClientFlow(userId,flowId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
