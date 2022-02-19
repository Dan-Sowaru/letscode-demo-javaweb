package br.com.letscode.letscodedemojavaweb.modelo;

import lombok.Data;

@Data
public class Pessoa {
    private String nome;
    private String sobrenome;
    private String idade;
    private String data;

    public Pessoa(String nome, String sobrenome, String idade, String data) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.data = data;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}


