package com.example.helder.serial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProjetorActivity extends AppCompatActivity {

    Controle c;
    Conexao connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projetor);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        connect = (Conexao) intent.getSerializableExtra("conexao");

        BD db = new BD(this);
        c = db.buscaId(id);

    }

    public void botaoLiga(View View){
        connect.write(c.getBotaoLiga().getBytes());
    }

    public void botaoSs(View View){
        connect.write(c.getBotaoSs().getBytes());
    }
    public void botaoComp(View View){
        connect.write(c.getBotaoComp().getBytes());
    }
    public void botaoVideo(View View){
        connect.write(c.getBotaoVideo().getBytes());
    }
    public void botaoUsb(View View){
        connect.write(c.getBotaoUsb().getBytes());
    }
    public void botaoLan(View View){
        connect.write(c.getBotaoLan().getBytes());
    }
    public void botaoMenu(View View){
        connect.write(c.getBotaoMenu().getBytes());
    }
    public void botaoEsc(View View){
        connect.write(c.getBotaoEsc().getBytes());
    }
    public void botaoCima(View View){
        connect.write(c.getBotaoCima().getBytes());
    }
    public void botaoOkProjetor(View View){
        connect.write(c.getBotaoOk().getBytes());
    }
    public void botaoBaixo(View View){
        connect.write(c.getBotaoBaixo().getBytes());
    }
    public void botaoEsq(View View){
        connect.write(c.getBotaoEsq().getBytes());
    }
    public void botaoDir(View View){
        connect.write(c.getBotaoDir().getBytes());
    }
    public void botao1(View View){
        connect.write(c.getBotao1().getBytes());
    }
    public void botao2(View View){
        connect.write(c.getBotao2().getBytes());
    }
    public void botao3(View View){
        connect.write(c.getBotao3().getBytes());
    }
    public void botao4(View View){
        connect.write(c.getBotao4().getBytes());
    }
    public void botao5(View View){
        connect.write(c.getBotao5().getBytes());
    }
    public void botao6(View View){
        connect.write(c.getBotao6().getBytes());
    }
    public void botao7(View View){
        connect.write(c.getBotao7().getBytes());
    }
    public void botao8(View View){
        connect.write(c.getBotao8().getBytes());
    }
    public void botao9(View View){
        connect.write(c.getBotao9().getBytes());
    }
    public void botao0(View View){
        connect.write(c.getBotao0().getBytes());
    }
    public void botaoVolMais(View View){
        connect.write(c.getBotaovolMais().getBytes());
    }
    public void botaoVolMenos(View View){
        connect.write(c.getBotaoVolMenos().getBytes());
    }

}
