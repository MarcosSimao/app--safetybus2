package com.safetybus.pc.safetybus2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AvisoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso);

        Button btnavancar =(Button) findViewById(R.id.btnAvancar);
        Button btnfechar = (Button) findViewById(R.id.btnFechar);
        Intent recebe=getIntent();
        Bundle parametro = recebe.getExtras();
        final String enviar= parametro.getString("chave");

        btnfechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(AvisoActivity.this,cadastro.class);
                finish();
                startActivity(i);
            }
        });
        btnavancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AvisoActivity.this,ContatoCadastrarActivity.class);
                Bundle parametro2= new Bundle();
                parametro2.putString("chave2",enviar);
                i.putExtras(parametro2);
                startActivity(i);
            }
        });





    }
}
