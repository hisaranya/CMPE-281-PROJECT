package edu.sjsu.projectcloud.task;

import java.util.Date;

/**
 * Created by mallika on 4/30/15.
 */
public class TaskWF extends Task {
    protected Date startDate;
    protected Date endDate;

    public TaskWF() {}


    public TaskWF(String status, String taskName, String taskDescription, String resourceName, Date startDate, Date endDate) {
        super(status, taskName, taskDescription, resourceName);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TaskWF(String status, String taskName, String taskDescription, Date startDate, Date endDate) {
        super(status, taskName, taskDescription);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
