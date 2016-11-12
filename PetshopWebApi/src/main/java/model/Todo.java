package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

@JsonSerialize
public class Todo {

    private final String id;
    private final String title;
    private final boolean done;
    private final Date createdOn = new Date();

    public Todo(String id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
}
