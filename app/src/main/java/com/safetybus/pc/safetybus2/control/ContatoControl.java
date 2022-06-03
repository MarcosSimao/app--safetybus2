package com.safetybus.pc.safetybus2.control;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.safetybus.pc.safetybus2.dao.ContatoDao;
import com.safetybus.pc.safetybus2.face.ContatoInterface;
import com.safetybus.pc.safetybus2.model.ContatoModel;

import java.util.ArrayList;

public class ContatoControl implements ContatoInterface {
    private Context context;
    private ContatoDao contato;
    private ContatoModel model;
    private EditText ContatoNomeCadastro,ContatoNumero;
    private TextView ContatoEmailCadastro;

    public ContatoControl(Context context){
      this.context=context;
      contato= new ContatoDao(this.context);
      model= new ContatoModel(null,null,null);

    }
    @Override
    public void AdicionarContato(ContatoModel contato1) {

        if(contato1.getEmail().isEmpty() || contato1.getNome().isEmpty() || contato1.getTelefone().isEmpty()){
            verificarNome(false);
            verificarNumero(false);

        }else{

            verificarNome(true);
            verificarNumero(true);
            this.contato.AdicionarContato(contato1);
        }

    }

    @Override
    public void RemoverContato(ContatoModel contato) {

    }

    @Override
    public ArrayList<ContatoModel> ListarContato() {
        return null;
    }

    @Override
    public void Superbotao(String email) {
        contato.Superbotao(email);

    }


    public boolean verificarNome(boolean nome){

        return nome;
    }
    public boolean verificarNumero(boolean numero){

        return numero;
    }
    public void limpar(){
        model.setNome(null);
        model.setEmail(null);
        model.setTelefone(null);

        ContatoNomeCadastro.setText("");
        ContatoNumero.setText("");
        ContatoEmailCadastro.setText("");


        ContatoNomeCadastro.requestFocus();

    }
}
