package edu.sjsu.projectcloud.resource;

/**
 * Created by mallika on 4/30/15.
 */
public class Resource {

    protected String id;

    protected String username;
    protected String password;

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
}
