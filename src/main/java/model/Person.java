package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonSerialize
public class Person implements Serializable {
    
    private int id;
    private String cpf;
    private String name;
    private long age;
    private String address;
    private String phone;
    private List<Animal> animals = new ArrayList<>();
    
    public Person() {
    }

    public Person(int id, String cpf, String name, long age, String address, String phone) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getAge() {
        return age;
    }    

    public void setAge(long age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
