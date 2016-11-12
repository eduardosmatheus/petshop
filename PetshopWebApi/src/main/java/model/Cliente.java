package model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Cliente {
    
    @JsonView
    public String cpf;
    @JsonView
    public String nome;
    @JsonView
    public long idade;
    @JsonView
    public String address;
    @JsonView
    public String phone;

    public Cliente() { }

    public Cliente(String cpf, String nome, long idade, String address, String phone) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.address = address;
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdade() {
        return idade;
    }

    public void setIdade(long idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return address;
    }

    public void setEndereco(String endereco) {
        this.address = endereco;
    }

    public String getTelefone() {
        return phone;
    }

    public void setTelefone(String telefone) {
        this.phone = telefone;
    }
    
}
