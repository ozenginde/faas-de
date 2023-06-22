package com.faas.core.base.model.db.process.details.temp;

import com.faas.core.base.model.db.process.details.temp.dao.ChannelTempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "push_temp_table")
public class PushTempDBModel {

    @Id
    private String id;
    private String processId;
    private String header;
    private String body;
    private String footer;
    private String sender;
    private long typeId;
    private String pushType;
    private List<ChannelTempDataDAO>tempDatas;
    private long uDate;
    private long cDate;
    private int status;

    public PushTempDBModel() {
    }

    public PushTempDBModel(String id, String processId, String header, String body, String footer, String sender, long typeId, String pushType, List<ChannelTempDataDAO> tempDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.header = header;
        this.body = body;
        this.footer = footer;
        this.sender = sender;
        this.typeId = typeId;
        this.pushType = pushType;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
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
