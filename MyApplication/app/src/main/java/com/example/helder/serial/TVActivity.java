package com.example.helder.serial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TVActivity extends AppCompatActivity {

    Conexao connect;
    Controle c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        connect = (Conexao) intent.getSerializableExtra("conexao");

        BD db = new BD(this);
        c = db.buscaId(id);
    }
}
