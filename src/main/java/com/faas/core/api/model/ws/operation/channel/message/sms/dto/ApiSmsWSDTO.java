package com.faas.core.api.model.ws.operation.channel.message.sms.dto;

import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;

public class ApiSmsWSDTO {

    private SmsMessageDBModel smsMessage;

    public ApiSmsWSDTO() {
    }

    public ApiSmsWSDTO(SmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }

    public SmsMessageDBModel getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(SmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }
}
