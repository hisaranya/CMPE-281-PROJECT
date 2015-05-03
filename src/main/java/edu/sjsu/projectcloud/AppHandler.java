package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.db.*;
import edu.sjsu.projectcloud.exceptions.InvalidLoginException;
import edu.sjsu.projectcloud.exceptions.NoSuchUserException;
import edu.sjsu.projectcloud.project.Project;
import edu.sjsu.projectcloud.resource.Resource;
import edu.sjsu.projectcloud.session.User;
import edu.sjsu.projectcloud.sprint.Sprint;
import edu.sjsu.projectcloud.task.Task;
import edu.sjsu.projectcloud.task.TaskScrum;


/**
 * Created by mallika on 5/1/15.
 */
public class AppHandler {
    ResourceAccess resourceAccess = new ResourceAccess();
    ProjectAccess projectAccess = new ProjectAccess();
    SprintAccess sprintAccess = new SprintAccess();
    TaskAccess taskAccess = new TaskAccess();

    public User validateAndGetUser(String username, String password) throws NoSuchUserException, InvalidLoginException {
        User u = new User();
        try {
            Resource r = resourceAccess.findResource(username);

            if (r == null) {
                throw new NoSuchUserException();
            }

            if (validateUsernamePassword(username, password)) {
                u = new User(r);
                return u;
            } else {
                throw new InvalidLoginException();
            }
        } catch (NullMongoTemplateException e) {
            e.printStackTrace();
        }

        return u;
    }

    public Resource doesUserExist(String username) {
        Resource resource;
        try {
            resource = resourceAccess.findResource(username);
        } catch (NullMongoTemplateException nmte) {
            System.out.println("Mongo Connection failed");
            return null;
        }
        return resource;
    }

    public Project getProject(String projectid) {
        Project project = null;
        try {
            project = projectAccess.getProject(projectid);
        } catch (NullMongoTemplateException nmte) {
            System.out.println("Mongo Connection failed");
            return null;
        }
        return project;
    }

    public void insertResource(Resource resource) {
        resourceAccess.insertResource(resource);
    }

    public Project insertProject(Project project) {
        Project dbProject = projectAccess.insertProject(project);
        return dbProject;
    }

    public boolean validateUsernamePassword(String username, String password) {
        Resource resource = doesUserExist(username);
        if (resource.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public Project doesProjectExistInResource(String username, Project project) {
        Project project1;
        try {
            project1 = resourceAccess.findProjectinResource(username, project.getProjectname(), project.getProjecttype());
        } catch (NullMongoTemplateException nmte) {
            System.out.println("Mongo Connection failed");
            return null;
        }
        return project1;

    }

    public boolean updateResourceAddProject(String username, Project project) {
        try {
            resourceAccess.updateResourceAddProject(username, project);
        } catch (NullMongoTemplateException nmte) {
            System.out.println("Mongo Connection failed");
            return false;
        }
        return true;
    }

    public Sprint doesSprintExistInProject(String projectname, String projecttype, String username, Sprint sprint)  {
        Sprint newSprint;
        try {
            newSprint = projectAccess.findSprintinProject(username, projectname, projecttype, sprint.getSprintName());
        } catch (NullMongoTemplateException nmte) {
            System.out.println("Mongo connection not established");
            return null;
        }
        return newSprint;
    }

    public Sprint insertSprint(Sprint sprint, String projectid) {
        Sprint dbSprint = sprintAccess.insertSprint(sprint);
        return dbSprint;
    }

    public boolean updateProjectAddSprint(String projectid, Sprint sprint) {
        try {
            projectAccess.updateProjectAddSprint(projectid, sprint);
        } catch (NullMongoTemplateException nmte) {
            System.out.println("Mongo Connection failed");
            return false;
        }
        return true;
    }

    public Task addStoryToSprint(TaskScrum story, String projectid, String sprintid) {
        Task dbTask = taskAccess.insertTask(story);
        try {
            Sprint sprint = sprintAccess.updateSprintAddTask(sprintid, dbTask);
            projectAccess.updateProjectAddStoryToSprint(projectid, sprint, story);
        } catch (NullMongoTemplateException nmte) {
            System.out.println("Mongo Connection failed");
            return null;
        }
        return dbTask;
    }



}
