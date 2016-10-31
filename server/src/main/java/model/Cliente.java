package model;

import com.fasterxml.jackson.annotation.JsonView;
import parserview.Views;

public class Cliente {

    @JsonView(Views.Normal.class)
    public final String cpf;
    
    @JsonView(Views.Normal.class)
    public final String nome;
    
    @JsonView(Views.Normal.class)
    public final long idade;
    
    @JsonView(Views.Normal.class)
    public final String endereco;
    
    @JsonView(Views.Normal.class)
    public final String telefone;

    public Cliente(String cpf, String nome, long idade, String endereco, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
