package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import parserview.Views;

@JsonSerialize
public class Animal {
    
    @JsonView(Views.Normal.class)
    public int id;
    @JsonView(Views.Normal.class)
    public String name;
    @JsonView(Views.Normal.class)
    public Race race;
    @JsonView(Views.Normal.class)
    public Especie especie;
}
