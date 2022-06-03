package com.safetybus.pc.safetybus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.safetybus.pc.safetybus2.control.UsuarioControl;
import com.safetybus.pc.safetybus2.model.UsuarioModel;

public class cadastro extends AppCompatActivity {

    public EditText nome,email,senha,senha2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button cadastrar = findViewById(R.id.ButtonCadastrarCadastro);
        Button voltar = findViewById(R.id.ButtonVoltarCadastro);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioControl usuarioControl = new UsuarioControl(cadastro.this);


                nome =(EditText) findViewById(R.id.EditNomeCadastro);
                email =(EditText) findViewById(R.id.EditEmailCadastro);
                senha = (EditText) findViewById(R.id.EditSenhaCadastro);
                senha2=(EditText) findViewById(R.id.editSenhaCadastro2);


             if(!senha.getText().toString().equals(senha2.getText().toString())){

                    senha2.setError(" a senha esta diferente");
                }else{

                    UsuarioModel usuarioModel = new UsuarioModel(nome.getText().toString(),email.getText().toString(),senha.getText().toString());
                    usuarioControl.CadastrarUsuario(usuarioModel);
                }








            }
        });




        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(cadastro.this, EntrarLogin.class);
                finish();
                startActivity(b);
            }
        });
    }



}
