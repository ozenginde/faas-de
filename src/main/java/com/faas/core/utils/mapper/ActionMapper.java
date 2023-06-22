package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.scenario.element.action.dao.ActionElementDataDAO;
import com.faas.core.base.model.ws.scenario.element.action.details.dto.ActionElementDataWSDTO;
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


    public ActionElementDataWSDTO getProcessActionDataWSDTO(ActionElementDataDAO actionElementDataDAO) {

        ActionElementDataWSDTO actionElementDataWSDTO = new ActionElementDataWSDTO();
        return actionElementDataWSDTO;
    }


}
