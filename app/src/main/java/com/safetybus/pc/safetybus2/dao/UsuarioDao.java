package com.safetybus.pc.safetybus2.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.safetybus.pc.safetybus2.AvisoActivity;
import com.safetybus.pc.safetybus2.SuperBotaoActivity;
import com.safetybus.pc.safetybus2.alterar_cadastro;
import com.safetybus.pc.safetybus2.face.UsuarioInterface;
import com.safetybus.pc.safetybus2.model.UsuarioModel;

public class UsuarioDao implements UsuarioInterface {
    private static String TABELA = "usuario";
    private static String EMAIL = "email";
    private static String NOME = "nome";
    private static String SENHA = "senha";
    public Context context;
    private Conexao conexao;
    private  SQLiteDatabase database ;


    public UsuarioDao(Context context) {


        this.context = context;
        conexao = new Conexao(context);
      database  = this.conexao.getWritableDatabase();
    }

    @Override
    public void CadastrarUsuario(UsuarioModel usuario) {



        boolean retorno;

        ContentValues values = new ContentValues();

        values.put(EMAIL, usuario.getEmail());
        values.put(NOME, usuario.getNome());
        values.put(SENHA, usuario.getSenha());

        //String coluns = ("email = ?,nome = ?,senha = ?");

        retorno = database.insert(TABELA, null, values)>0;

        if (!retorno) {
            Toast.makeText(context, "cadastro não realizado", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(context, "cadastro realizado ", Toast.LENGTH_SHORT).show();
            Intent i= new Intent(context, AvisoActivity.class);
            Bundle paramentro = new Bundle();
            paramentro.putString("chave",usuario.getEmail());
             i.putExtras(paramentro);

            context.startActivity(i);

        }

        database.close();

    }

    @Override
    public void AlterarUsuario(UsuarioModel usuario) {


    }

    @Override
    public boolean VerificarUsuario(UsuarioModel usuario) {

        return false;
    }



    @Override
    public void acessoLogin(String email, String senha) {
        String sql="select * from usuario order by id desc";
        this.database = this.conexao.getReadableDatabase();
        Cursor cursor= this.database.rawQuery(sql,null);
        int contator = this.database.rawQuery(sql,null).getCount();
        int c=0;
        if(cursor.moveToFirst()){
            while(true){
                c++;
                String em= cursor.getString(cursor.getColumnIndex("email"));
                if(email.equals(em)){

                    String senha2=cursor.getString(cursor.getColumnIndex("senha"));
                    if(senha.equals(senha2)) {
                        String nome=cursor.getString(cursor.getColumnIndex("nome"));
                        Intent i = new Intent(context, SuperBotaoActivity.class);
                        Bundle parametro = new Bundle();
                        parametro.putString("chave1", em);
                        parametro.putString("chaveNome", nome);

                        i.putExtras(parametro);
                        context.startActivity(i);
                        break;
                    }else{
                        Toast.makeText(context,"senha esta errada",Toast.LENGTH_LONG).show();
                        break;
                    }
                }else if(c>=contator){
                    Toast.makeText(context,"o email nao existe",Toast.LENGTH_LONG).show();
                    break;
                }

            }
        }
        cursor.close();
        database.close();
    }



    public void mudarsenha(String senha,String email){
    boolean ead;
    ContentValues values= new ContentValues();
    values.put(SENHA,senha);
    String where = "email= ?";
    String[] args={email};
    ead=this.database.update(TABELA,values,where,args)>0;
    if(ead){
     Toast.makeText(context,"senha mudada",Toast.LENGTH_LONG).show();
    }else{
        Toast.makeText(context,"erro al mudar a senha contate ao programador",Toast.LENGTH_LONG).show();
    }
    database.close();
    }
    public void  emailexiste(String email){

   String sql="select * from usuario order by id desc";
   this.database = this.conexao.getReadableDatabase();
        Cursor cursor= this.database.rawQuery(sql,null);
        int contator = this.database.rawQuery(sql,null).getCount();
        int c=0;
        if(cursor.moveToFirst()){
            while(true){
             c++;
             String em= cursor.getString(cursor.getColumnIndex("email"));
             if(email.equals(em)){
              Intent i= new Intent(context,alterar_cadastro.class);
              Bundle parametro= new Bundle();
              parametro.putString("chave",em);
              i.putExtras(parametro);
              context.startActivity(i);
              break;

             }else if(c>=contator){
                 Toast.makeText(context,"o email nao existe",Toast.LENGTH_LONG).show();
                 break;
             }

            }
        }
        cursor.close();
        database.close();
    }

}