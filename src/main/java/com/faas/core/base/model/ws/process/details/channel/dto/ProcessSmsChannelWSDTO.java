package com.faas.core.base.model.ws.process.details.channel.dto;

import com.faas.core.base.model.db.process.details.channel.ProcessSmsChannelDBModel;

public class ProcessSmsChannelWSDTO {

    private ProcessSmsChannelDBModel smsChannel;

    public ProcessSmsChannelWSDTO() {
    }

    public ProcessSmsChannelWSDTO(ProcessSmsChannelDBModel smsChannel) {
        this.smsChannel = smsChannel;
    }

    public ProcessSmsChannelDBModel getSmsChannel() {
        return smsChannel;
    }

    public void setSmsChannel(ProcessSmsChannelDBModel smsChannel) {
        this.smsChannel = smsChannel;
    }
}
