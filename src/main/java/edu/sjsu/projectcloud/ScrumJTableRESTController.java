package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.jtable.JTableResult;
import edu.sjsu.projectcloud.session.UserSessionInfo;
import edu.sjsu.projectcloud.task.Task;
import edu.sjsu.projectcloud.task.TaskScrum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/cmpe281project/api/scrum")
public class ScrumJTableRESTController {
    @Autowired
    UserSessionInfo userSessionInfo;

    @RequestMapping(value="/createStory", method=RequestMethod.POST)
    public JTableResult<? extends Task> createStory(@ModelAttribute TaskScrum story, Model model) {
        // TODO actually create the entry from MongoDB

        story.setId("-1");

        JTableResult<TaskScrum> result = new JTableResult<>();
        result.setResult("OK");
        result.addRecord(story);
        System.out.println(story);
        return result;
    }

    @RequestMapping(value="/updateStory", method=RequestMethod.POST)
    public JTableResult<? extends Task> updateStory(@ModelAttribute TaskScrum story, Model model) {
        // TODO actually update the entry from MongoDB

        story.setId("-1");

        JTableResult<TaskScrum> result = new JTableResult<>();
        result.setResult("OK");
        result.addRecord(story);
        System.out.println(story);
        return result;
    }

    @RequestMapping(value="/deleteStory", method=RequestMethod.POST)
    public JTableResult<? extends Task> deleteStory(@ModelAttribute TaskScrum story, Model model) {
        // TODO actually delete the entry from MongoDB

        System.out.println("Delete for story id = " + story.getId());
        return new JTableResult<>();
    }


}
