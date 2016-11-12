package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Breed {

    private int id;
    private String name;

    public Breed(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Breed() {
    }

    @Override
    public String toString() {
        return String.format("Codigo: %s\tDescricao: %s", id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.name = description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
