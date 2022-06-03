package com.safetybus.pc.safetybus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.safetybus.pc.safetybus2.control.ContatoControl;
import com.safetybus.pc.safetybus2.model.ContatoModel;

public class ContatoCadastrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_cadastrar);
         Intent recebe = getIntent();
         Bundle parametro = recebe.getExtras();
         String emailRecebe = parametro.getString("chave2");


        ContatoModel user = new ContatoModel(null,null,null);
        TextView email = (TextView) findViewById(R.id.ContatoEmailCadastro);
        user.setEmail(emailRecebe);
    final String  str =user.getEmail();
        email.setText(user.getEmail().toString());
        Button voltar= (Button) findViewById(R.id.ButtonVoltarCadastro);
        Button enviar = (Button) findViewById(R.id.ButtonContatocadastro);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(ContatoCadastrarActivity.this,cadastro.class);
                finish();
                startActivity(i);
            }
        });
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContatoControl contato = new ContatoControl(ContatoCadastrarActivity.this);
                EditText numero = (EditText) findViewById(R.id.ContatoNumero);
                EditText nome = (EditText) findViewById(R.id.ContatoNomeCadastro);
                boolean algo=false,algo1=false;
                if(!contato.verificarNome(algo1)){
                    nome.setError(" so pode haver 15 caractere");
                }else if(!contato.verificarNumero(algo)){
                    numero.setError(" so pode haver 15 numeros");
                }else{
                    ContatoModel model = new ContatoModel(nome.getText().toString(),numero.getText().toString(),str);
                    contato.AdicionarContato(model);

                }
            }
        });




    }
}
