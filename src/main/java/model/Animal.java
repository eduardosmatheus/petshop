package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import views.Views;

@JsonSerialize
public class Animal {
    
    private final int id;
    private final String name;
    private final Cliente client;
    private final Race race;
    private final Especie especie;

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

    public Cliente getClient() {
        return client;
    }

    public Race getRace() {
        return race;
    }

    public Especie getEspecie() {
        return especie;
    }
}
