package com.safetybus.pc.safetybus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.safetybus.pc.safetybus2.control.UsuarioControl;

public class EntrarLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_login);



        ImageButton btnLogar = (ImageButton)findViewById(R.id.btnLogar) ;
        TextView altSenha = (TextView)findViewById(R.id.TextAlterarLogin);
        TextView btncadastro = (TextView)findViewById(R.id.TextCadastroLogin);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioControl controll = new UsuarioControl(EntrarLogin.this);
                EditText email = (EditText) findViewById(R.id.EntrarEmail);
                EditText senha = (EditText) findViewById(R.id.EntrarSenha);
                controll.acessoLogin(email.getText().toString(),senha.getText().toString());

            }
        });
        altSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(EntrarLogin.this,ConfirmarEmailActivity.class);
                finish();
                startActivity(i);

            }
        });


        btncadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(EntrarLogin.this,cadastro.class) ;
               finish();
               startActivity(i);
            }
        });







    }
}
