package model;

import com.fasterxml.jackson.annotation.JsonView;
import parserview.Views;

public class Race {

    @JsonView(Views.Hidden.class)
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
}
