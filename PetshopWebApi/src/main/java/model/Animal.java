package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import views.Views;

@JsonSerialize
public class Animal implements Serializable {
    
    @JsonView(Views.Normal.class)
    public int id;
    @JsonView(Views.Normal.class)
    public String name;
    @JsonView(Views.Normal.class)
    public Cliente cliente;
    @JsonView(Views.Normal.class)
    public Race race;
    @JsonView(Views.Normal.class)
    public Especie especie;

    public Animal() {}

    public Animal(int id, String name, Cliente cliente, Race race, Especie especie) {
        this.id = id;
        this.name = name;
        this.cliente = cliente;
        this.race = race;
        this.especie = especie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
    
    
}
