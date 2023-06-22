package com.faas.core.base.model.ws.process.details.channel.dto;

import com.faas.core.base.model.db.process.details.channel.ProcessWappChannelDBModel;

public class ProcessWappChannelWSDTO {

    private ProcessWappChannelDBModel wappChannel;

    public ProcessWappChannelWSDTO() {
    }

    public ProcessWappChannelWSDTO(ProcessWappChannelDBModel wappChannel) {
        this.wappChannel = wappChannel;
    }

    public ProcessWappChannelDBModel getWappChannel() {
        return wappChannel;
    }

    public void setWappChannel(ProcessWappChannelDBModel wappChannel) {
        this.wappChannel = wappChannel;
    }
}
