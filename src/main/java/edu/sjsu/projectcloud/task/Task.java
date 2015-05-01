package edu.sjsu.projectcloud.task;

import org.springframework.data.annotation.Id;

/**
 * Created by mallika on 4/30/15.
 */
public class Task {
    @Id
    protected String id;

    protected String status;
    protected String taskName;
    protected String taskDescription;

    public Task(String status, String taskName, String taskDescription) {
        this.status = status;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
