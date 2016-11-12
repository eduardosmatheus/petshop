package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonSerialize
@Entity
@Table(catalog = "breeds")
public class Breed implements Serializable {

    @Id @GeneratedValue
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
