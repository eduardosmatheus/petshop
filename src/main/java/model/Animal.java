package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize
public class Animal implements Serializable {
    
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Cliente client;
    private Breed race;
    private Especie especie;

    public Animal() {
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public void setRace(Breed race) {
        this.race = race;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
