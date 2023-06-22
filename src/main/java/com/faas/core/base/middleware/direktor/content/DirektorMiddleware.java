package com.faas.core.base.middleware.direktor.content;

import com.faas.core.base.framework.direktor.content.DirektorFramework;
import com.faas.core.base.model.ws.client.content.AllClientsWSModel;
import com.faas.core.base.model.ws.client.content.dto.AllClientsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DirektorMiddleware {


    @Autowired
    DirektorFramework direktorFramework;


    public AllClientsWSModel getAllClients(long userId, int reqPage, int reqSize) {

        AllClientsWSModel response = new AllClientsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        AllClientsWSDTO allClientsWSDTO = new AllClientsWSDTO();


        general.setOperation("getAllClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
