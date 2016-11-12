package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Especie {
    @JsonView
    private final int id;
    @JsonView
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
