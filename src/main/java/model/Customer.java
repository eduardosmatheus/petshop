package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@JsonSerialize
@Entity
public class Customer implements Serializable {
    
    @JsonView @Id
    private String cpf;
    @JsonView
    private String name;
    @JsonView
    private long age;
    @JsonView
    private String address;
    @JsonView
    private String phone;
    
    @JsonView @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    private List<Animal> animals = new ArrayList<>();
    
    public Customer() {
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
    
    
}
