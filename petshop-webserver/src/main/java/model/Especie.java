package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import parserview.Views;

@JsonSerialize
public class Especie {

    @JsonView(Views.Normal.class)
    private final int id;
    @JsonView(Views.Normal.class)
    private final String description;

    public Especie(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
