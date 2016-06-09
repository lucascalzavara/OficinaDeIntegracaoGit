package com.example.helder.serial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lucas Calzavara on 08/06/2016.
 */
public class BancoDados extends SQLiteOpenHelper {

    private static final String NOME_BD = "controle";
    private static final int VERSAO_BD = 2;

    public BancoDados(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "CREATE TABLE IF NOT EXISTS controle(     _id    integer PRIMARY KEY AUTOINCREMENT,     nome varchar(100),    tipo varchar(50),     botao1 varchar(1000),     botao2 varchar(1000),     botao3 varchar(1000),     botao4 varchar(1000),     botao5 varchar(1000),     botao6 varchar(1000),     botao7 varchar(1000),     botao8 varchar(1000),     botao9 varchar(1000),     botao0 varchar(1000),     botaovolmais varchar(1000),     botaovolmenos varchar(1000),     botaochmais varchar(1000),     botaochmenos varchar(1000),     botaocima varchar(1000),     botaoesq varchar(1000),     botaodir varchar(1000),     botaobaixo varchar(1000),     botaook varchar(1000),     botaomenu varchar(1000),     botaovoltar varchar(1000),     botaosair varchar(1000),     botaoopcoes varchar(1000),     botaoinput varchar(1000),     botaoa varchar(1000),     botaob varchar(1000),     botaoc varchar(1000),     botaod varchar(1000),     botaoligadesliga varchar(1000),     botaohashtag varchar(1000),     botaoasterisco varchar(1000),     botaoesc varchar(1000),     botaocomp varchar(1000),     botaovideo varchar(1000),     botaousb varchar(1000),     botaolan varchar(1000),     botaosoucesearch varchar(1000) );";
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table controle");
        onCreate(db);
    }
}
