package edu.sjsu.projectcloud.project;

import edu.sjsu.projectcloud.resource.Resource;
import edu.sjsu.projectcloud.task.Task;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mallika on 4/30/15.
 */
public class Project {

    protected String id;

    protected String projectname;
    protected String projecttype;
    protected String startdate;
    protected String enddate;
    protected String ownername;

    protected List<Resource> resources = new ArrayList<>();
    protected List<Task> tasks = new ArrayList<>();

    public Project(String projectname, String projecttype, String startdate, String enddate, String ownername) {
        this.projectname = projectname;
        this.projecttype = projecttype;
        this.startdate = startdate;
        this.enddate = enddate;
        this.ownername = ownername;
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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public void addResource(Resource resource) {
        if (resources != null) {
            resources.add(resource);
        } else {
            System.out.println("Resources is null");
        }
    }


    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public void addTask(Task task) {
        if (tasks != null) {
            tasks.add(task);
        } else {
            System.out.println("Tasks is null");
        }
    }
}
