package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import views.Views;

@JsonSerialize
public class Animal {
    
    @JsonView(Views.Normal.class)
    public final int id;
    @JsonView(Views.Normal.class)
    public final String name;
    @JsonView(Views.Normal.class)
    public final Cliente client;
    @JsonView(Views.Normal.class)
    public final Race race;
    @JsonView(Views.Normal.class)
    public final Especie especie;

    public Animal(int id, String name, Cliente client, Race race, Especie especie) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.race = race;
        this.especie = especie;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cliente getCliente() {
        return client;
    }

    public Race getRace() {
        return race;
    }

    public Especie getEspecie() {
        return especie;
    }
}
