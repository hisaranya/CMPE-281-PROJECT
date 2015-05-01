package edu.sjsu.projectcloud.resource;

import edu.sjsu.projectcloud.project.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mallika on 4/30/15.
 */
public class Resource {

    protected String id;

    protected String username;
    protected String password;
    List<Project> projects = new ArrayList<>();
    public Resource(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Resource() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        String string = "id: "+this.getId()+", username: "+this.getUsername()+", password: "+this.getPassword();
        return string;
    }
/*
    public void findProject(Resource resource){
        if(projects != null){
            projects.add(projects);
        }
        else
        {
            System.out.println("There are no projects for the user.");
        }
    }
    */
}
