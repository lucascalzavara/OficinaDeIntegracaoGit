package com.example.helder.serial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Calzavara on 08/06/2016.
 */
public class BD {
    private SQLiteDatabase db;

    public BD(Context context) {
        BancoDados auxBd = new BancoDados(context);
        db = auxBd.getWritableDatabase();
    }

    public void inserir(Controle controle){
        ContentValues valores = new ContentValues();
        valores.put("nome", controle.getNome());
        valores.put("botao1", controle.getBotao1());
        valores.put("botao2", controle.getBotao2());
        valores.put("botao3", controle.getBotao3());
        valores.put("botao4", controle.getBotao4());
        valores.put("botao5", controle.getBotao5());
        valores.put("botao6", controle.getBotao6());
        valores.put("botao7", controle.getBotao7());
        valores.put("botao8", controle.getBotao8());
        valores.put("botao9", controle.getBotao9());
        valores.put("botao0", controle.getBotao0());
        valores.put("botaovolmais", controle.getBotaovolMais());
        valores.put("botaovolmenos", controle.getBotaoVolMenos());
        valores.put("botaochmais", controle.getBotaoChMais());
        valores.put("botaochmenos", controle.getBotaoChMenos());
        valores.put("botaocima", controle.getBotaoCima());
        valores.put("botaook", controle.getBotaoOk());
        valores.put("botaobaixo", controle.getBotaoBaixo());
        valores.put("botaoesq", controle.getBotaoEsq());
        valores.put("botaodir", controle.getBotaoDir());
        valores.put("botaomenu", controle.getBotaoMenu());
        valores.put("botaovoltar", controle.getBotaoVoltar());
        valores.put("botaoopcoes", controle.getBotaoOpcoes());
        valores.put("botaoinput", controle.getBotaoInput());
        valores.put("botaoa", controle.getBotaoA());
        valores.put("botaob", controle.getBotaoB());
        valores.put("botaoc", controle.getBotaoC());
        valores.put("botaod", controle.getBotaoD());
        valores.put("botaoligadesliga", controle.getBotaoLiga());
        valores.put("botaohashtag", controle.getBotaoHashtag());
        valores.put("botaoasterisco", controle.getBotaoAsterisco());
        valores.put("botaoesc", controle.getBotaoEsc());
        valores.put("botaocomp", controle.getBotaoComp());
        valores.put("botaovideo", controle.getBotaoVideo());
        valores.put("botaousb", controle.getBotaoUsb());
        valores.put("botaolan", controle.getBotaoLan());
        valores.put("botaosoucesearch", controle.getBotaoSs());
        valores.put("tipo", controle.getTipo());
        db.insert("controle", null, valores);
    }

    public void atualizar(Controle controle){
        ContentValues valores = new ContentValues();
        valores.put("botao1", controle.getBotao1());
        valores.put("botao2", controle.getBotao2());
        valores.put("botao3", controle.getBotao3());
        valores.put("botao4", controle.getBotao4());
        valores.put("botao5", controle.getBotao5());
        valores.put("botao6", controle.getBotao6());
        valores.put("botao7", controle.getBotao7());
        valores.put("botao8", controle.getBotao8());
        valores.put("botao9", controle.getBotao9());
        valores.put("botao0", controle.getBotao0());
        valores.put("botaovolmais", controle.getBotaovolMais());
        valores.put("botaovolmenos", controle.getBotaoVolMenos());
        valores.put("botaochmais", controle.getBotaoChMais());
        valores.put("botaochmenos", controle.getBotaoChMenos());
        valores.put("botaocima", controle.getBotaoCima());
        valores.put("botaook", controle.getBotaoOk());
        valores.put("botaobaixo", controle.getBotaoBaixo());
        valores.put("botaoesq", controle.getBotaoEsq());
        valores.put("botaodir", controle.getBotaoDir());
        valores.put("botaomenu", controle.getBotaoMenu());
        valores.put("botaovoltar", controle.getBotaoVoltar());
        valores.put("botaoopcoes", controle.getBotaoOpcoes());
        valores.put("botaoinput", controle.getBotaoInput());
        valores.put("botaoa", controle.getBotaoA());
        valores.put("botaob", controle.getBotaoB());
        valores.put("botaoc", controle.getBotaoC());
        valores.put("botaod", controle.getBotaoD());
        valores.put("botaoligadesliga", controle.getBotaoLiga());
        valores.put("botaohashtag", controle.getBotaoHashtag());
        valores.put("botaoasterisco", controle.getBotaoAsterisco());
        valores.put("botaoesc", controle.getBotaoEsc());
        valores.put("botaocomp", controle.getBotaoComp());
        valores.put("botaovideo", controle.getBotaoVideo());
        valores.put("botaousb", controle.getBotaoUsb());
        valores.put("botaolan", controle.getBotaoLan());
        valores.put("botaosoucesearch", controle.getBotaoSs());
        db.update("controle", valores, "_id = ?", new String[]{""+controle.getId()});
    }

    public void deletar(Controle controle){
        db.delete("controle", "_id = "+controle.getId(), null);
    }

    public List<Controle> buscarTodos(){
        List<Controle> list = new ArrayList<>();
        String[] colunas = new String[]{"_id", "nome", "tipo"};
        //Cursor cursor = db.query(Tabela, Colunas, where, whereArgs, ...);

        Cursor cursor = db.query("controle", colunas, null, null, null, null, "nome ASC");


        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Controle c = new Controle();
                c.setId(cursor.getInt(0));
                c.setNome(cursor.getString(1));
                c.setTipo(cursor.getString(2));
            }while (cursor.moveToNext());
        }
        return (list);
    }

    public Controle buscaId(int id){
        Controle c = new Controle();

        Cursor cursor = db.query("controle", null, "_id = "+id, null, null, null, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            c.setId(cursor.getInt(0));
            c.setNome(cursor.getString(1));
            c.setTipo(cursor.getString(2));
            c.setBotao1(cursor.getString(3));
            c.setBotao2(cursor.getString(4));
            c.setBotao3(cursor.getString(5));
            c.setBotao4(cursor.getString(6));
            c.setBotao5(cursor.getString(7));
            c.setBotao6(cursor.getString(8));
            c.setBotao7(cursor.getString(9));
            c.setBotao8(cursor.getString(10));
            c.setBotao9(cursor.getString(11));
            c.setBotao0(cursor.getString(12));
            c.setBotaovolMais(cursor.getString(13));
            c.setBotaoVolMenos(cursor.getString(14));
            c.setBotaoChMais(cursor.getString(15));
            c.setBotaoChMenos(cursor.getString(16));
            c.setBotaoCima(cursor.getString(17));
            c.setBotaoEsq(cursor.getString(18));
            c.setBotaoDir(cursor.getString(19));
            c.setBotaoBaixo(cursor.getString(20));
            c.setBotaoOk(cursor.getString(21));
            c.setBotaoMenu(cursor.getString(22));
            c.setBotaoVoltar(cursor.getString(23));
            c.setBotaoSair(cursor.getString(24));
            c.setBotaoOpcoes(cursor.getString(25));
            c.setBotaoInput(cursor.getString(26));
            c.setBotaoA(cursor.getString(27));
            c.setBotaoB(cursor.getString(28));
            c.setBotaoC(cursor.getString(29));
            c.setBotaoD(cursor.getString(30));
            c.setBotaoLiga(cursor.getString(31));
            c.setBotaoHashtag(cursor.getString(32));
            c.setBotaoAsterisco(cursor.getString(33));
            c.setBotaoEsc(cursor.getString(34));
            c.setBotaoComp(cursor.getString(35));
            c.setBotaoVideo(cursor.getString(36));
            c.setBotaoUsb(cursor.getString(37));
            c.setBotaoLan(cursor.getString(38));
            c.setBotaoSs(cursor.getString(39));

        }
        return c;

    }
}
