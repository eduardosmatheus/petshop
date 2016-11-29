package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;

@JsonSerialize
public class Animal implements Serializable {
    
    private int id;
    private String name;
    private Date birthday;
    private Person customer;
    private Breed breed;
    private Especie especie;
    
    public Animal() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public Person getCustomer() {
        return customer;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
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

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
