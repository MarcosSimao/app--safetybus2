package com.safetybus.pc.safetybus2.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;

import com.safetybus.pc.safetybus2.control.ContatoControl;
import com.safetybus.pc.safetybus2.face.ContatoInterface;
import com.safetybus.pc.safetybus2.model.ContatoModel;

import java.util.ArrayList;

public class ContatoDao implements ContatoInterface {
    private Context context;
    private static  String TABELA;
    private static String NOME;
    private static String NUMERO;
    private static String EMAIL;
    private  Conexao conexao;
    private SQLiteDatabase database;
    private ContatoControl cd;

    public ContatoDao(Context context){
       this.context=context;
       TABELA="contato";
       NOME="nome";
       NUMERO="numero_telefone";
       EMAIL="email";
       conexao= new Conexao(context);
        database = this.conexao.getWritableDatabase();

    }

    @Override
    public void AdicionarContato(ContatoModel contato) {

        boolean retorno;
        ContentValues values = new ContentValues();
        values.put(NUMERO,contato.getTelefone());
        values.put(NOME,contato.getNome());
        values.put(EMAIL,contato.getEmail());

        retorno=database.insert(TABELA,null,values)>0;
        if(!retorno){
            Toast.makeText(context," cadastro nao realizado",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "cadastro realizado ", Toast.LENGTH_SHORT).show();
            cd.limpar();
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
        String sql = "select * from contato where email="+email;
        this.database = this.conexao.getReadableDatabase();
        Cursor cursor= this.database.rawQuery(sql,null);
      if(cursor.moveToFirst()){

          String nome=cursor.getString(cursor.getColumnIndex("nome"));
          String numero=cursor.getString(cursor.getColumnIndex("numero_telefone"));

          Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=55"+numero+"&text=Ola "+nome));
          context.startActivity(i);
      }


    }


}
