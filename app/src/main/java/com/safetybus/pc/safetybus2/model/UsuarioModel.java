package com.safetybus.pc.safetybus2.model;

public class UsuarioModel {
    private String nome;
    private String email;
    private String senha;
    public UsuarioModel(String nome ,String email,String senha){
       this.nome=nome;
       this.email=email;
       this.senha=senha;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return ( email.toString() +"\n"+  senha.toString());
    }
}
