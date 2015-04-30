package edu.sjsu.projectcloud.project;

import java.util.Date;

/**
 * Created by mallika on 4/30/15.
 */
public class Project {

    protected String id;

    protected String projectName;
    protected String projectType;
    protected Date startDate;
    protected Date endDate;

    public Project(String projectName, String projectType, Date startDate, Date endDate) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
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
