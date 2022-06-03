package com.safetybus.pc.safetybus2.face;

import com.safetybus.pc.safetybus2.model.ContatoModel;

import java.util.ArrayList;

public interface ContatoInterface {
    public void  AdicionarContato(ContatoModel contato);
    public void RemoverContato(ContatoModel contato);
    public ArrayList<ContatoModel> ListarContato();
    public void Superbotao(String email);
}
