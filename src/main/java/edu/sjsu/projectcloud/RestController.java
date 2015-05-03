package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.jtable.JTableResult;
import edu.sjsu.projectcloud.project.Project;
import edu.sjsu.projectcloud.project.ProjectScrum;
import edu.sjsu.projectcloud.sprint.Sprint;
import edu.sjsu.projectcloud.task.TaskScrum;
import edu.sjsu.projectcloud.session.UserSessionInfo;
import edu.sjsu.projectcloud.sprint.Sprint;
import javassist.tools.reflect.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sandy on 5/1/15.
 */
@EnableAutoConfiguration
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/cmpe281project/api")
public class RestController {
    @Autowired
    UserSessionInfo userSessionInfo;

    private class SampleBean {
        public String user;
        public String pass;

        public SampleBean(String user, String pass) {
            this.user = user;
            this.pass = pass;
        }
    }

    @RequestMapping(value = "/getAllStoriesForJTable", method = RequestMethod.POST)
    public JTableResult getAllSprintsForJTable(@RequestParam(value = "projectId", required = true) String projectId) {
        JTableResult result = new JTableResult();
        result.setResult("OK");

        for (int i=0; i < 20; i++) {
            TaskScrum task = new TaskScrum("Status", "Task Name", "Description", "resource name", 1, 10);
            task.setId(i+"");
            result.addRecord(task);
        }
        return result;
    }


    @RequestMapping(value = "/getAllSprintsForProject", method = RequestMethod.GET)
    public List<Sprint> getAllSprintsForProject(@RequestParam(value = "projectId", required = true) String projectId) {
        // get sprints and return the list of sprints here

        List<Sprint> sprints = new ArrayList<>();
        sprints.add(new Sprint("Sprint-1", "05/02/2015", "05/09/2015"));
        sprints.add(new Sprint("Sprint-2", "05/10/2015", "05/17/2015"));
        return sprints;
    }

    @RequestMapping(value = "/addStory", method = RequestMethod.POST)
    public String addStory(@RequestBody String requestBody, @RequestParam(required=true, value="projectId") String projectId) {
        // Url will be /cmpe281project/api/addStory?projectId=1
        // RequestBody will be a json with object
        // parse the request body and add it to the project using DAO

        System.out.println("JSON received " + requestBody);


//        DAO dao = DAOFactory.getInstance("SCRUM");
//        dao.addStoryForProject(story, projectId);

        return "success";
    }

    @RequestMapping(value = "/test/dummyproject/{projectid}", method = RequestMethod.GET)
    public Project returnDummyProjectPOJO(@PathVariable String projectid) {
        Project project = setUpDummyProject(projectid);
        return project;
    }

    private Project setUpDummyProject(String projectid) {
        ProjectScrum project = new ProjectScrum("DummyProject", "SCRUM", "05/02/2015", "05/31/2015", "Team16");
        project.setId(projectid);
        project.setSprints(setupDummySprints());
        return project;
    }

    private List<Sprint> setupDummySprints() {
        List<Sprint> sprints = new ArrayList<>();
        Sprint sprint1 = new Sprint("DummySprint1", "05/02/2015", "05/09/2015");
        sprint1.setId("1234");
        Sprint sprint2 = new Sprint("DummySprint2", "05/09/2015", "05/16/2015");
        sprint2.setId("5678");
        sprint1 = addStories(sprint1);
        sprint2 = addStories(sprint2);
        sprints.add(sprint1);
        sprints.add(sprint2);
        return sprints;
    }

    private Sprint addStories(Sprint sprint) {
        String taskName = sprint.getSprintName()+"DummyTask1";
        TaskScrum taskScrum = new TaskScrum("In progress", taskName, "Dummy Task 1", "XYZ", 50, 10);
        taskScrum.setId("1234");
        sprint.addTask(taskScrum);
        return sprint;
    }










}
