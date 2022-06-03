package com.safetybus.pc.safetybus2.face;

import com.safetybus.pc.safetybus2.model.UsuarioModel;

public interface UsuarioInterface {
    public void CadastrarUsuario (UsuarioModel usuario);
    public void AlterarUsuario(UsuarioModel usuario);
    public boolean VerificarUsuario(UsuarioModel usuario);
    public void acessoLogin(String email, String senha);

}
