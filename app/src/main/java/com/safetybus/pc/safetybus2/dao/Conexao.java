package com.safetybus.pc.safetybus2.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper{

    private static String BANCO = "safetybus";
    private static int VERSAO = 1;

    public Conexao(Context context) {
        super(context, BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

      String sql="create table usuario (email VARCHAR(30) PRIMARY KEY,\n" +
              "nome VARCHAR(50) NOT NULL,\n" +
              "id int unsigned NOT NULL auto_increment,\n" +
              "senha VARCHAR(20) NOT NULL UNIQUE)";

      String sql2="create table contato (numero_telefone VARCHAR(20) PRIMARY KEY,\n" +
              "email VARCHAR(30) NOT NULL,\n" +
              "nome VARCHAR(50) NOT NULL,\n" +
              "FOREIGN KEY(email) REFERENCES usuario (email))";
      db.execSQL(sql);
      db.execSQL(sql2);




    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

      String sql="drop table if exist usuario" ;
      String sql2="drop table if exist contato";
      db.execSQL(sql);
      db.execSQL(sql2);
      onCreate(db);



    }
}
