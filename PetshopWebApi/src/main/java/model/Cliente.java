package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Cliente {
    
    @JsonView
    private final String cpf;
    @JsonView
    private final String name;
    @JsonView
    private final long age;
    @JsonView
    private final String address;
    @JsonView
    private final String phone;

    public Cliente(String cpf, String name, long age, String address, String phone) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public long getAge() {
        return age;
    }

    public String getEndereco() {
        return address;
    }

    public String getTelefone() {
        return phone;
    }
    
}
