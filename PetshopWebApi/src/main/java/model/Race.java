package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Race {

<<<<<<< HEAD:src/main/java/model/Race.java
    @JsonView(Views.Normal.class)
    public final int id;

    @JsonView(Views.Normal.class)
    public final String descricao;
=======
    public int id;
    public String description;
>>>>>>> 64f7007dfc1b493ae2428d2d9b6a0f25bd019067:PetshopWebApi/src/main/java/model/Race.java

    public Race(int id, String descricao) {
        this.id = id;
        this.description = descricao;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.description = descricao;
    }
}
