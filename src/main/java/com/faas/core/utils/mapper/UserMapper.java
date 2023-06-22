package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.channel.account.SipAccountDBModel;
import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.model.db.user.details.dao.UserDataDAO;
import com.faas.core.base.model.db.utils.variables.DataTypeDBModel;
import com.faas.core.base.model.ws.user.content.dto.UserWSDTO;
import com.faas.core.base.model.ws.user.details.dto.UserDetailsWSDTO;
import com.faas.core.base.model.ws.user.details.dto.UserSipChannelWSDTO;
import com.faas.core.base.model.ws.user.details.dto.UserWappChannelWSDTO;
import com.faas.core.base.repo.channel.account.SipAccountRepository;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.base.repo.utils.variables.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserMapper {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    SipAccountRepository sipAccountRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    AppUtils appUtils;


    public UserDataDAO mapUserDataDAO(String dataId,long dataTypeId,String value){

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (dataTypeDBModel.isPresent()){

            UserDataDAO userDataDAO = new UserDataDAO();
            userDataDAO.setDataId(dataId);
            userDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            userDataDAO.setValue(value);
            userDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            userDataDAO.setStatus(1);

            return userDataDAO;
        }
        return null;
    }






}
