package com.safetybus.pc.safetybus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.safetybus.pc.safetybus2.model.ContatoModel;

import java.util.ArrayList;

public class numero extends AppCompatActivity {

    public ArrayList<ContatoModel> contatos;
    public ContatoModel c;
    public ListView lista;
    public EditText EditNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero);

        Intent intent = getIntent();
        if(intent !=null){
            Bundle params = intent.getExtras();
            if(params != null){
                String email = params.getString("email");

                EditText editText = findViewById(R.id.EditEmailNumero);

                editText.setText(email);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.numero,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        EditText email = findViewById(R.id.EditEmailNumero);
        EditText contato = findViewById(R.id.EditContatoNumero);

        switch (item.getItemId()){
            case R.id.MenuAdicionarNumero:
                try{
                    if (!EmailValido(email.getText().toString())){
                        email.setError("email invalido");
                    }else if (!ContatoValido(contato.getText().toString())){
                        contato.setError("contato invalido");
                    }else {

                    }
                }catch (Exception e){
                    Toast.makeText(numero.this,"O app parou",Toast.LENGTH_SHORT).show();
                }
            break;
            case R.id.MenuRemoverNumero:
                try{
                    if (!EmailValido(email.getText().toString())){
                        email.setError("email invalido");
                    }else if (!ContatoValido(contato.getText().toString())){
                        contato.setError("contato invalido");
                    }else {

                    }
                }catch (Exception e){
                    Toast.makeText(numero.this,"O app parou",Toast.LENGTH_SHORT).show();
                }
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean CampoVazio(String valor){
        boolean res = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return res;
    }

    public boolean EmailValido(String email){
        boolean res = (!CampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        return res;
    }

    public boolean ContatoValido(String contato){
        boolean res = (!CampoVazio(contato) && contato.trim().length() <= 20);
        return res;
    }

}
