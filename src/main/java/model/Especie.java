package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonSerialize
@Entity
public class Especie implements Serializable {
    
    @Id @GeneratedValue
    private int id;
    private String description;

    public Especie(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Especie() {
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
