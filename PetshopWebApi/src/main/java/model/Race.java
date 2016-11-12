package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Race {

    public int id;
    public String description;

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
