package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Race {

    private final int id;
    private final String description;

    public Race(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Codigo: %s\tDescricao: %s", id, description);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
