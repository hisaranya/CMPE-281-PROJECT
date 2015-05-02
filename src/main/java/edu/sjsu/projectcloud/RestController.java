package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.sprint.Sprint;
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
    @RequestMapping(value = "/getAllSprintsForProject", method = RequestMethod.GET)
    public List<Sprint> getAllSprintsForProject(@RequestParam(value = "projectId", required = true) String projectId) {
        // get sprints and return the list of sprints here

        List<Sprint> sprints = new ArrayList<>();
        sprints.add(new Sprint("Sprint-1", new Date(), new Date()));
        sprints.add(new Sprint("Sprint-2", new Date(), new Date()));
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

    @RequestMapping(value = "/allStory", method = RequestMethod.POST)
    public
}
