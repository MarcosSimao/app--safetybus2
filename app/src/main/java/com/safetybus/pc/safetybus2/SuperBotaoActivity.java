package com.safetybus.pc.safetybus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.safetybus.pc.safetybus2.control.ContatoControl;
import com.safetybus.pc.safetybus2.model.UsuarioModel;

public class SuperBotaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_botao);

        Intent recebe = getIntent();
        Bundle parametro = recebe.getExtras();
        final String emailRecebe = parametro.getString("chave1");
        String nome1 = parametro.getString("chaveNome");


        UsuarioModel user = new UsuarioModel(null,null,null);
        TextView nome = (TextView) findViewById(R.id.nomeDousuario);
        user.setNome(nome1);

        nome.setText(user.getNome());


        Button SupetBtn=(Button) findViewById(R.id.SupetBtn);

        SupetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContatoControl usuario = new ContatoControl(SuperBotaoActivity.this);
                usuario.Superbotao(emailRecebe);

            }
        });






    }
}
