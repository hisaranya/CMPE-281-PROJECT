package edu.sjsu.projectcloud.project;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by mallika on 4/30/15.
 */
public class Project {

    protected String id;

    protected String projectname;
    protected String projecttype;
    protected String startdate;
    protected String enddate;

    public Project(String projectname, String projecttype, String startdate, String enddate) {
        this.projectname = projectname;
        this.projecttype = projecttype;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Project() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

}
