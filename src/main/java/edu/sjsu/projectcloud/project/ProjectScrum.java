package edu.sjsu.projectcloud.project;

import edu.sjsu.projectcloud.sprint.Sprint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mallika on 5/1/15.
 */
public class ProjectScrum extends Project {

    private List<Sprint> sprint = new ArrayList<>();
    public ProjectScrum(String projecttype, String projectname, String startdate, String enddate, String ownername) {
        super(projectname, projecttype, startdate, enddate, ownername);
    }
}
