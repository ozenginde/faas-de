package com.faas.core.base.model.ws.user.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.details.dto.UserWappChannelWSDTO;


public class UserWappChannelWSModel {

    private GeneralWSModel general;
    private UserWappChannelWSDTO userWappChannel;


    public UserWappChannelWSModel() {
    }

    public UserWappChannelWSModel(GeneralWSModel general, UserWappChannelWSDTO userWappChannel) {
        this.general = general;
        this.userWappChannel = userWappChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public UserWappChannelWSDTO getUserWappChannel() {
        return userWappChannel;
    }

    public void setUserWappChannel(UserWappChannelWSDTO userWappChannel) {
        this.userWappChannel = userWappChannel;
    }
}
