package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dao.BreedsDAO;
import dao.CustomerDAO;
import dao.EspeciesDAO;
import java.io.Serializable;
import java.util.Date;

@JsonSerialize
public class Animal implements Serializable {
    
    private int id;
    private String name;
    private Date birth;
    private Customer customer;
    private Breed breed;
    private Especie especie;
    private String obs; 
     
    public Animal() {}

    public Animal(int id, String name, Date birth, Customer customer, Breed breed, Especie especie, String obs) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.customer = customer;
        this.breed = breed;
        this.especie = especie;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirthday(Date birthday) {
        this.birth = birthday;
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

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
    
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public static Animal buildAnimal(int id, String name, Date birth, int idBreed, int idEspecie, int idCustomer) {
        Animal animal = new Animal();
        animal.setId(id);
        animal.setName(name);
        animal.setBirthday(birth);
        animal.setBreed(new BreedsDAO().findOne(idBreed));
        animal.setEspecie(new EspeciesDAO().findOne(idEspecie));
        animal.setCustomer(new CustomerDAO().findOne(idCustomer));
        return animal;
    }
}
