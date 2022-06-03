package com.safetybus.pc.safetybus2.model;

import java.util.ArrayList;

public class OnibusModel {
    private int numero_linha;
    private String nome_linha;
    private ArrayList<UsuarioModel> usuario;

    public int getNumero_linha() {return numero_linha;}

    public void setNumero_linha(int numero_linha) {this.numero_linha = numero_linha;}

    public String getNome_linha() {return nome_linha;}

    public void setNome_linha(String nome_linha) {this.nome_linha = nome_linha;}

    public ArrayList<UsuarioModel> getUsuario() {return usuario;}

    public void setUsuario(ArrayList<UsuarioModel> usuario) {this.usuario = usuario;}
}
