package com.faas.core.base.model.db.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.dao.SmsTriggerDAO;
import com.faas.core.base.model.db.process.details.trigger.dao.WappTriggerDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "process_trigger_table")
public class ProcessTriggerDBModel {

    @Id
    private String id;
    private String processId;
    private SmsTriggerDAO smsTrigger;
    private WappTriggerDAO wappTrigger;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessTriggerDBModel() {
    }

    public ProcessTriggerDBModel(String id, String processId, SmsTriggerDAO smsTrigger, WappTriggerDAO wappTrigger, String triggerType, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.smsTrigger = smsTrigger;
        this.wappTrigger = wappTrigger;
        this.triggerType = triggerType;
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

    public SmsTriggerDAO getSmsTrigger() {
        return smsTrigger;
    }

    public void setSmsTrigger(SmsTriggerDAO smsTrigger) {
        this.smsTrigger = smsTrigger;
    }

    public WappTriggerDAO getWappTrigger() {
        return wappTrigger;
    }

    public void setWappTrigger(WappTriggerDAO wappTrigger) {
        this.wappTrigger = wappTrigger;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
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
