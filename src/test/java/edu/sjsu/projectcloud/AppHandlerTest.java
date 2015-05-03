package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.task.TaskScrum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by mallika on 5/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloApp.class)
@WebAppConfiguration
public class AppHandlerTest {

    @Test
    public void testAddStoryToSprint() throws Exception {
        AppHandler appHandler = new AppHandler();
        String taskName = "DummyTask2";
        String projectid = "554597c977c846b675a270cc";
        String sprintid = "554597d377c846b675a270cd";
        TaskScrum taskScrum = new TaskScrum("In progress", taskName, "Dummy Task 2", "ABC", 50, 10);
        appHandler.addStoryToSprint(taskScrum, projectid, sprintid);
    }
}