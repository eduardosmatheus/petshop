package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@JsonSerialize
public class Animal implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private Date birthday;
    
    @OneToOne(mappedBy = "customer_id")
    private Customer customer;
    
    @OneToOne @MapsId
    private Breed breed;
    
    @OneToOne @MapsId
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
    
    public Customer getCustomer() {
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRace(Breed breed) {
        this.breed = breed;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
