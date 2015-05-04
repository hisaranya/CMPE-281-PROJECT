package edu.sjsu.projectcloud.status;

import edu.sjsu.projectcloud.project.ProjectScrum;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mallika on 5/3/15.
 */
public class ProjectStatusKanban extends ProjectStatus {
    private int ready;
    private int inprogress;
    private int complete;
    private int limit = 10;

    public ProjectStatusKanban(int ready, int inprogress, int complete) {
        super();
        this.ready = ready;
        this.inprogress = inprogress;
        this.complete = complete;
    }

    public int getReady() {
        return ready;
    }

    public void setReady(int ready) {
        this.ready = ready;
    }

    public int getInprogress() {
        return inprogress;
    }

    public void setInprogress(int inprogress) {
        this.inprogress = inprogress;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }
}
