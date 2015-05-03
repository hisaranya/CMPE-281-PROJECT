package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.jtable.JTableResult;
import edu.sjsu.projectcloud.task.Task;
import edu.sjsu.projectcloud.task.TaskScrum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/cmpe281project/api/scrum")
public class ScrumJTableRESTController {
    /**
     * JTable's protocol is -
     *  1. CREATE - sends POST with fields as the column names
     *  2. GET - sends POST
     *  3. UPDATE - sends POST
     *  4. DELETE - sends POST
     */

    @RequestMapping(value="/createStory", method=RequestMethod.POST)
    public JTableResult<? extends Task> createStory(@ModelAttribute TaskScrum story, Model model) {
        story.setId("1234");

        JTableResult<TaskScrum> result = new JTableResult<>();
        result.setResult("OK");
        result.addRecord(story);
        System.out.println(story);
        return result;
    }




}
