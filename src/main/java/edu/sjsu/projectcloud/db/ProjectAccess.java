package edu.sjsu.projectcloud.db;

import com.mongodb.Mongo;
import edu.sjsu.projectcloud.project.Project;
import edu.sjsu.projectcloud.resource.Resource;
import edu.sjsu.projectcloud.task.Task;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Update;

import java.net.UnknownHostException;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by mallika on 5/1/15.
 */
public class ProjectAccess {

    private MongoOperations getMongoOperations() throws UnknownHostException {
        MongoOperations mongoOperations = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "test"));
        return mongoOperations;
    }

    public boolean insertProject(Project project) {
        MongoOperations mongoOperations = getMongoOperationInstance();
        if (mongoOperations != null) {
            mongoOperations.insert(project);
            return true;
        }
        return false;
    }

    public boolean updateProjectAddResource(Resource resource, String projectName) {
        MongoOperations mongoOperations = getMongoOperationInstance();
        if (mongoOperations != null) {
            Project project = mongoOperations.findOne(query(where("projectname").is(projectName)), Project.class);
            if (project != null) {
                project.addResource(resource);
                String projectId = project.getId();
                mongoOperations.upsert(query(where("projectname").is(projectName)), Update.update(projectId, project), Project.class);
            }
            return true;
        }
        return false;
    }

    public boolean updateProjectAddTask(Task task, String projectName) {
        MongoOperations mongoOperations = getMongoOperationInstance();
        if (mongoOperations != null) {
            Project project = mongoOperations.findOne(query(where("projectname").is(projectName)), Project.class);
            if (project != null) {
                project.addTask(task);
                String projectId = project.getId();
                mongoOperations.upsert(query(where("projectname").is(projectName)), Update.update(projectId, project), Project.class);
            }
            return true;
        }
        return false;
    }

    private MongoOperations getMongoOperationInstance() {
        MongoOperations mongoOperations = null;
        try {
            mongoOperations = getMongoOperations();
        } catch (UnknownHostException uhe) {
            System.out.println("Unknown Host");
            return null;
        }
        return mongoOperations;
    }

}
