package edu.sjsu.projectcloud;

import edu.sjsu.projectcloud.db.NullMongoTemplateException;
import edu.sjsu.projectcloud.db.ResourceAccess;
import edu.sjsu.projectcloud.project.Project;
import edu.sjsu.projectcloud.resource.Resource;

/**
 * Created by mallika on 5/1/15.
 */
public class AppHandler {
    ResourceAccess resourceAccess = new ResourceAccess();


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

    public boolean validateUsernamePassword(String username, String password) {
        Resource resource = doesUserExist(username);
        if (resource.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
/*
    public Project doesProjectExist(String username, Project project) {
        try {
            project.findProject(username);
        } catch (NullMongoTemplateException nmte) {
            System.out.println("Mongo Connection failed");
            return null;
        }
        return project;

    }
    */
}
