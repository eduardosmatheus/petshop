package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize
public class Breed implements Serializable {

    private Integer id;
    
    private String name;

    public Breed(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Breed() {
    }

    @Override
    public String toString() {
        return String.format("Codigo: %s\tDescricao: %s", id, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
