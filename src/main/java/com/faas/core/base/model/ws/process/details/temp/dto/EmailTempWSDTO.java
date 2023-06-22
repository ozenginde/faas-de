package com.faas.core.base.model.ws.process.details.temp.dto;

import com.faas.core.base.model.db.process.details.temp.EmailTempDBModel;

public class EmailTempWSDTO {

    private EmailTempDBModel emailTemp;

    public EmailTempWSDTO() {
    }

    public EmailTempWSDTO(EmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }

    public EmailTempDBModel getEmailTemp() {
        return emailTemp;
    }

    public void setEmailTemp(EmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }
}
