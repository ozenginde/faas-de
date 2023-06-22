package com.faas.core.base.model.db.process.content.dao;

public class ProcessPathDAO {

    private String pathId;
    private int pathOrder;
    private String processPath;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessPathDAO() {
    }

    public ProcessPathDAO(String pathId, int pathOrder, String processPath, long uDate, long cDate, int status) {
        this.pathId = pathId;
        this.pathOrder = pathOrder;
        this.processPath = processPath;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public int getPathOrder() {
        return pathOrder;
    }

    public void setPathOrder(int pathOrder) {
        this.pathOrder = pathOrder;
    }

    public String getProcessPath() {
        return processPath;
    }

    public void setProcessPath(String processPath) {
        this.processPath = processPath;
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
