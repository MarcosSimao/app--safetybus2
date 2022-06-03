package com.safetybus.pc.safetybus2.control;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.safetybus.pc.safetybus2.dao.UsuarioDao;
import com.safetybus.pc.safetybus2.face.UsuarioInterface;
import com.safetybus.pc.safetybus2.model.UsuarioModel;

public class UsuarioControl implements UsuarioInterface {

    private Context context;
    private UsuarioDao usuarioDao;
    private UsuarioModel user;

    private EditText  EditNomeCadastro,EditEmailCadastro,EditSenhaCadastro,editSenhaCadastro2;
    public UsuarioControl(Context context) {


        this.context = context;
       usuarioDao  = new UsuarioDao(this.context);
       user= new UsuarioModel(null,null,null);
    }

    @Override
    public void CadastrarUsuario(UsuarioModel usuario) {

        if(usuario.getNome().isEmpty() || usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty() ){

            verificarNome(false);

        }else{

            if(usuario.getSenha().length()>10){
                Toast.makeText(context," senha so pode ate 10 caractere",Toast.LENGTH_LONG).show();
            }else{

            verificarNome(true);
            usuarioDao.CadastrarUsuario(usuario);
            }

        }
    }

    @Override
    public void AlterarUsuario(UsuarioModel usuario) {

        usuarioDao.AlterarUsuario(usuario);
    }

    @Override
    public boolean VerificarUsuario(UsuarioModel usuario) {
        boolean retorno;

        retorno = usuarioDao.VerificarUsuario(usuario);
        return retorno;
    }

    @Override
    public void acessoLogin(String email, String senha) {

     usuarioDao.acessoLogin(email,senha);


    }

    public void verificarEmailLogin(String email){
          if(email.isEmpty()){
              Toast.makeText(context," por favor coloque um email pra enviar ",Toast.LENGTH_LONG).show();
          }else{


         usuarioDao.emailexiste(email);
        }
    }
    public boolean verificarSenhaLogin(String senha){

        if(senha.length()>10){

            return false;
        }else{
            return true;
        }



    }


    public boolean verificarNome(boolean nome){

        return false;
    }
    public void mudarsenha(String senha, String email){
        if(senha.length()>10){

            Toast.makeText(context," digite ate 10 caractere",Toast.LENGTH_LONG).show();
        }else{

            usuarioDao.mudarsenha(senha,email);
        }


    }
    public void limpar(){
        user.setNome(null);
        user.setEmail(null);
        user.setSenha(null);

        EditNomeCadastro.setText("");
        EditEmailCadastro.setText("");
        EditSenhaCadastro.setText("");
        editSenhaCadastro2.setText("");

        EditNomeCadastro.requestFocus();

    }



}
