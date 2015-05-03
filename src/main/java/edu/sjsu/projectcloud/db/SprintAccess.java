package edu.sjsu.projectcloud.db;

import com.mongodb.Mongo;
import edu.sjsu.projectcloud.project.Project;
import edu.sjsu.projectcloud.resource.Resource;
import edu.sjsu.projectcloud.sprint.Sprint;
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
public class SprintAccess {

    private MongoOperations getMongoOperations() throws UnknownHostException {
        MongoOperations mongoOperations = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "test"));
        return mongoOperations;
    }

    public Sprint insertSprint(Sprint sprint) {
        Sprint dbSprint = null;
        MongoOperations mongoOperations = getMongoOperationInstance();
        if (mongoOperations != null) {
            Sprint existSprint = mongoOperations.findOne(query(where("sprintName").is(sprint.getSprintName()).
                    and("startDate").is(sprint.getStartDate()).and("endDate").is(sprint.getEndDate())), Sprint.class);
            mongoOperations.insert(sprint);
            if (existSprint != null) {
                dbSprint = mongoOperations.findOne(query(where("sprintName").is(sprint.getSprintName()).
                        and("startDate").is(sprint.getStartDate()).and("endDate").is(sprint.getEndDate()).and("_id").ne(existSprint.getId())), Sprint.class);
            } else {
                dbSprint = mongoOperations.findOne(query(where("sprintName").is(sprint.getSprintName()).
                        and("startDate").is(sprint.getStartDate()).and("endDate").is(sprint.getEndDate())), Sprint.class);
            }
        }
        return dbSprint;
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

    public void updateSprintAddTask(String sprintname, String projectname, Task task) throws NullMongoTemplateException {
        MongoOperations mongoOperations = getMongoOperationInstance();
        if (mongoOperations == null) {
            throw new NullMongoTemplateException();
        }
        mongoOperations.updateFirst(query(where("projectname").is(projectname).and("sprintName").is(sprintname)), new Update().push("tasks", task), Resource.class);
    }
}
