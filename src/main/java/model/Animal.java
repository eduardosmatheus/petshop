package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Animal {
    
    private final int id;
    private final String name;
    private final Cliente client;
    private final Breed race;
    private final Especie especie;

    public Animal(int id, String name, Cliente client, Breed race, Especie especie) {
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

    public Breed getRace() {
        return race;
    }

    public Especie getEspecie() {
        return especie;
    }
}
