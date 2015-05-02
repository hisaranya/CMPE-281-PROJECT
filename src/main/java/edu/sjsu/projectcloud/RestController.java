package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.session.UserSessionInfo;
import edu.sjsu.projectcloud.sprint.Sprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
/*
    @RequestMapping(value = "/allStory", method = RequestMethod.POST)
    public
    */
}
