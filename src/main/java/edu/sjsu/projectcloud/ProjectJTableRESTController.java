package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.jtable.JTableResult;
import edu.sjsu.projectcloud.project.Project;
import edu.sjsu.projectcloud.session.UserSessionInfo;
import edu.sjsu.projectcloud.task.Task;
import edu.sjsu.projectcloud.task.TaskScrum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/cmpe281project/api/projects")
public class ProjectJTableRESTController {
    @Autowired
    UserSessionInfo userSessionInfo;

    @RequestMapping(value = "/listProjects", method = RequestMethod.POST)
    public JTableResult getAllProjectForJTable()
    {
        JTableResult<Project> result = new JTableResult<>(true);
        result.setResult("OK");

        AppHandler appHandler = new AppHandler();
        List<Project> projects = appHandler.getAllProjectsPerResource(userSessionInfo.getId());

        for (Project t : projects) {
            result.addRecord(t);
        }
        return result;
    }

    @RequestMapping(value="/createStory", method=RequestMethod.POST)
    public JTableResult<? extends Task> createStory(@ModelAttribute TaskScrum story,
                                                    @RequestParam("projectId") String projectId,
                                                    @RequestParam("sprintId") String sprintId,
                                                    Model model) {
        AppHandler appHandler = new AppHandler();
        story.setId(null);
        appHandler.addStoryToSprint(story, projectId, sprintId);

        JTableResult<TaskScrum> result = new JTableResult<>();
        result.setResult("OK");
        result.addRecord(story);
        System.out.println(story);
        return result;
    }

    @RequestMapping(value="/updateStory", method=RequestMethod.POST)
    public JTableResult<? extends Task> updateStory(@ModelAttribute TaskScrum story,
                                                    @RequestParam("projectId") String projectId,
                                                    @RequestParam("sprintId") String sprintId,
                                                    Model model) {
        AppHandler appHandler = new AppHandler();
        appHandler.updateStoryInSprint(story, projectId, sprintId);

        JTableResult<TaskScrum> result = new JTableResult<>();
        result.setResult("OK");
        result.addRecord(story);
        System.out.println(story);
        return result;
    }

    @RequestMapping(value="/deleteStory", method=RequestMethod.POST)
    public JTableResult<? extends Task> deleteStory(@ModelAttribute TaskScrum story,
                                                    @RequestParam("projectId") String projectId,
                                                    @RequestParam("sprintId") String sprintId,
                                                    Model model) {
        AppHandler appHandler = new AppHandler();
        appHandler.deleteStoryFromSprint(projectId, sprintId, story.getId());
        return new JTableResult<>();
    }
}
