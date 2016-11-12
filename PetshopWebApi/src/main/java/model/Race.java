package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import views.Views;

@JsonSerialize
public class Race {

    @JsonView(Views.Normal.class)
    public int id;
    @JsonView(Views.Normal.class)
    public String descricao;

    public Race(){}
    
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

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
