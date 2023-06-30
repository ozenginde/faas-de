package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.ChannelTempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "wapp_message_temp_table")
public class WappMessageTempDBModel {

    @Id
    private String id;
    private String processId;
    private String title;
    private String body;
    private long typeId;
    private String messageType;
    private List<ChannelTempDataDAO>tempDatas;
    private long uDate;
    private long cDate;
    private int status;


    public WappMessageTempDBModel() {
    }

    public WappMessageTempDBModel(String id, String processId, String title, String body, long typeId, String messageType, List<ChannelTempDataDAO> tempDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.title = title;
        this.body = body;
        this.typeId = typeId;
        this.messageType = messageType;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
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


