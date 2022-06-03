package com.safetybus.pc.safetybus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.safetybus.pc.safetybus2.control.UsuarioControl;

public class ConfirmarEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_email);


        Button btnEmail = (Button) findViewById(R.id.BTN_verificar);
        Button fechar = (Button) findViewById(R.id.fechar);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioControl user = new UsuarioControl(ConfirmarEmailActivity.this);
                EditText email = (EditText) findViewById(R.id.VR_email);
                  user.verificarEmailLogin(email.getText().toString());






            }
        });

      fechar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i = new Intent(ConfirmarEmailActivity.this,EntrarLogin.class);
              finish();
              startActivity(i);
          }
      });



    }
}
