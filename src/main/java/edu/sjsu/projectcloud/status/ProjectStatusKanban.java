package edu.sjsu.projectcloud.status;

import edu.sjsu.projectcloud.project.ProjectScrum;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mallika on 5/3/15.
 */
public class ProjectStatusKanban extends ProjectStatus {
    private Date completionDate;

    public ProjectStatusKanban() {
        super();
    }
    public ProjectStatusKanban() {}

    public Date getCompletionDate(ProjectScrum project) {
        Date today = Calendar.getInstance().getTime();
        return today;
    }
}
