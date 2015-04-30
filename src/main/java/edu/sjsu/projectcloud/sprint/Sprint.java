package edu.sjsu.projectcloud.sprint;

import java.util.Date;

/**
 * Created by mallika on 4/30/15.
 */
public class Sprint {

    private String id;

    protected String sprintName;
    protected Date startDate;
    protected Date endDate;

    public Sprint(String sprintName, Date startDate, Date endDate) {
        this.sprintName = sprintName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
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
