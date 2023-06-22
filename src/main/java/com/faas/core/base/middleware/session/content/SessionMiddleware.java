package com.faas.core.base.middleware.session.content;

import com.faas.core.base.framework.session.content.SessionFramework;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.session.content.SessionWSModel;
import com.faas.core.base.model.ws.session.content.dto.SessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SessionMiddleware {


    @Autowired
    SessionFramework sessionFramework;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    AppUtils appUtils;


    public SessionWSModel getAllSessions(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();

        Page<SessionDBModel> sessionDBModels = sessionRepository.findAllByStatus(1,PageRequest.of(reqPage,reqSize));
        for (int i=0;i<sessionDBModels.getContent().size();i++){
            sessionWSDTOS.add(sessionFramework.filSessionWSDTO(sessionDBModels.getContent().get(i)));
        }

        response.setSessions(sessionWSDTOS);
        general.setOperation("getAllSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SessionWSModel getSessionsByStateService(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();



        response.setSessions(sessionWSDTOS);
        general.setOperation("getAllSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel getSession(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();



        response.setSessions(sessionWSDTOS);
        general.setOperation("getSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SessionWSModel createSession(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();



        response.setSessions(sessionWSDTOS);
        general.setOperation("createSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SessionWSModel createSessions(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();



        response.setSessions(sessionWSDTOS);
        general.setOperation("createSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SessionWSModel updateSession(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();



        response.setSessions(sessionWSDTOS);
        general.setOperation("updateSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SessionWSModel removeSession(long userId, int reqPage, int reqSize) {

        SessionWSModel response = new SessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SessionWSDTO> sessionWSDTOS = new ArrayList<>();



        response.setSessions(sessionWSDTOS);
        general.setOperation("removeSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
