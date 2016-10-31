package model;

import com.fasterxml.jackson.annotation.JsonView;
import parserview.Views;

public class Especie {

    @JsonView(Views.Normal.class)
    private final int id;
    @JsonView(Views.Normal.class)
    private final String descricao;

    public Especie(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    
}
