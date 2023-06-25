package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.scenario.details.action.dao.ActionDataDAO;
import com.faas.core.base.model.ws.scenario.details.action.details.dto.ActionDataWSDTO;
import com.faas.core.base.repo.utils.variables.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ActionMapper {

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ActionDataWSDTO getProcessActionDataWSDTO(ActionDataDAO actionDataDAO) {

        ActionDataWSDTO actionDataWSDTO = new ActionDataWSDTO();
        return actionDataWSDTO;
    }


}
