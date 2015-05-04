package edu.sjsu.projectcloud.status;

import edu.sjsu.projectcloud.db.ProjectAccess;

/**
 * Created by mallika on 5/3/15.
 */
public class ProjectStatusFactory {

    public static ProjectStatus getProjectStatusObject(String projectType) {
        if (projectType.equals("KANBAN")) {
            return new ProjectStatusKanban();
        } else if (projectType.equals("SCRUM")) {

            return new ProjectStatusScrum();
        } else if (projectType.equals("WATERFALL")) {
            return new ProjectStatusWF();
        }
        return null;
    }
}
