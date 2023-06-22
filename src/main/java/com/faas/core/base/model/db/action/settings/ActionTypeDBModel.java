package com.faas.core.base.model.db.action.settings;

import javax.persistence.*;

@Entity
@Table(name = "action_types_table")
public class ActionTypeDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "action_type")
    private String actionType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;


    public ActionTypeDBModel() {
    }

    public ActionTypeDBModel(long id, String actionType, long uDate, long cDate, int status) {
        this.id = id;
        this.actionType = actionType;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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
