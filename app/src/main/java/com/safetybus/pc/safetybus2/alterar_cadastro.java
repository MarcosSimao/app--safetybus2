package com.safetybus.pc.safetybus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.safetybus.pc.safetybus2.control.UsuarioControl;
import com.safetybus.pc.safetybus2.model.UsuarioModel;

public class alterar_cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_cadastro);

        Intent recebe= getIntent();
        Bundle parametro=recebe.getExtras();
        final String email = parametro.getString("chave");

        Button Alterar = findViewById(R.id.ButtonAlterarAlterarCadastro);
        Button Voltar = findViewById(R.id.ButtonVoltarAlterarCadastro);

        Alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioControl usuarioControl = new UsuarioControl(alterar_cadastro.this);
                UsuarioModel usuarioModel = new UsuarioModel(null,null,null);

                EditText senha = findViewById(R.id.btnSenhanova);
                EditText senhanova = findViewById(R.id.btnRepetesenha);
                if(!senha.getText().toString().equals(senhanova.getText().toString())){
                    senhanova.setError(" as senhas sao diferentes coloque senhas iguais ");
                }else{
                    String senha2= senha.getText().toString();
                    senha.setText("");
                    senhanova.setText("");
                    usuarioControl.mudarsenha(senha2,email);
                }






            }

            });

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(alterar_cadastro.this,EntrarLogin.class);
                finish();
                startActivity(a);
            }
        });
    }



}
