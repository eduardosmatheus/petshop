package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Cliente {
    
    private final String cpf;
    private final String name;
    private final long age;
    private final String address;
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

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
