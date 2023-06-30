package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.ChannelTempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "email_temp_table")
public class EmailTempDBModel {

    @Id
    private String id;
    private String processId;
    private String subject;
    private String body;
    private String footer;
    private String sender;
    private long typeId;
    private String emailType;
    private List<ChannelTempDataDAO>tempDatas;
    private long uDate;
    private long cDate;
    private int status;

    public EmailTempDBModel() {
    }

    public EmailTempDBModel(String id, String processId, String subject, String body, String footer, String sender, long typeId, String emailType, List<ChannelTempDataDAO> tempDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.subject = subject;
        this.body = body;
        this.footer = footer;
        this.sender = sender;
        this.typeId = typeId;
        this.emailType = emailType;
        this.tempDatas = tempDatas;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public List<ChannelTempDataDAO> getTempDatas() {
        return tempDatas;
    }

    public void setTempDatas(List<ChannelTempDataDAO> tempDatas) {
        this.tempDatas = tempDatas;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
