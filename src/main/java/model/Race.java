package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import parserview.Views;

@JsonSerialize
public class Race {

    @JsonView(Views.Normal.class)
    public final int id;

    @JsonView(Views.Normal.class)
    public final String descricao;

    public Race(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("Codigo: %s\tDescricao: %s", id, descricao);
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
