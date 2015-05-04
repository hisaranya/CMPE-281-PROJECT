package edu.sjsu.projectcloud.status;

/**
 * Created by mallika on 5/3/15.
 */
public class ProjectStatusFactory {

    public static String getProjectStatusObject(String projectType) {
        if (projectType.equals("KANBAN")) {
            return new ProjectStatusKanban();
        }
    }
}
