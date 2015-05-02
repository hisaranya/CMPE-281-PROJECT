package edu.sjsu.projectcloud.sprint;

import edu.sjsu.projectcloud.task.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mallika on 4/30/15.
 */
public class Sprint {

    private String id;

    protected String sprintName;
    protected String startDate;
    protected String endDate;
    protected List<Task> tasks = new ArrayList<>();


    public Sprint(String sprintName, String startDate, String endDate) {
        this.sprintName = sprintName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Sprint() {}

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

}
