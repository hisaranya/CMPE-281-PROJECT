package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.db.NullMongoTemplateException;
import edu.sjsu.projectcloud.db.ProjectAccess;
import edu.sjsu.projectcloud.db.ResourceAccess;
import edu.sjsu.projectcloud.project.Project;
import edu.sjsu.projectcloud.resource.Resource;

/**
 * Created by mallika on 5/1/15.
 */
public class AppHandler {
    ResourceAccess resourceAccess = new ResourceAccess();
    ProjectAccess projectAccess = new ProjectAccess();

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

    public void insertResource(Resource resource) {
        resourceAccess.insertResource(resource);
    }

    public void insertProject(Project project) {
        projectAccess.insertProject(project);
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

}
