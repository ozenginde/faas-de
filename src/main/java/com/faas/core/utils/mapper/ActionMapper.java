package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.scenario.details.action.dao.ActionVariableDAO;
import com.faas.core.base.model.ws.scenario.details.action.details.dto.ActionVariableWSDTO;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ActionMapper {

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ActionVariableWSDTO getProcessActionDataWSDTO(ActionVariableDAO actionVariableDAO) {

        ActionVariableWSDTO actionVariableWSDTO = new ActionVariableWSDTO();
        return actionVariableWSDTO;
    }


}
