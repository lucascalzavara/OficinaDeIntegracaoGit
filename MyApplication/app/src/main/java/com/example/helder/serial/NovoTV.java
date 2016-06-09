package com.example.helder.serial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NovoTV extends AppCompatActivity {

    private static final int BOTAO_LIGA = 1;
    private static final int BOTAO_INPUT = 2;
    private static final int BOTAO_OPCOES = 3;
    private static final int BOTAO_VOLTAR = 4;
    private static final int BOTAO_SAIR = 5;
    private static final int BOTAO_CHMAIS = 6;
    private static final int BOTAO_CHMENOS = 26;
    private static final int BOTAO_MENU = 7;
    private static final int BOTAO_CIMA = 9;
    private static final int BOTAO_OK = 10;
    private static final int BOTAO_BAIXO = 11;
    private static final int BOTAO_DIR = 12;
    private static final int BOTAO_ESQ = 13;
    private static final int BOTAO_1 = 14;
    private static final int BOTAO_2 = 15;
    private static final int BOTAO_3 = 16;
    private static final int BOTAO_4 = 17;
    private static final int BOTAO_5 = 18;
    private static final int BOTAO_6 = 19;
    private static final int BOTAO_7 = 20;
    private static final int BOTAO_8 = 21;
    private static final int BOTAO_9 = 22;
    private static final int BOTAO_0 = 23;
    private static final int BOTAO_VOLMAIS = 24;
    private static final int BOTAO_VOLMENOS = 25;
    private static final int BOTAO_A = 27;
    private static final int BOTAO_B = 28;
    private static final int BOTAO_C = 29;
    private static final int BOTAO_D = 30;
    private static final int BOTAO_ASTERISCO = 31;
    private static final int BOTAO_HASHTAG = 32;


    private Controle c = new Controle();

    Conexao connect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_projetor);

        c.setAparelho("Projetor");

        Intent intent = getIntent();
        c.setNome(intent.getStringExtra("nome"));
        connect = (Conexao)intent.getSerializableExtra("conexao");



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case BOTAO_LIGA:
                if(resultCode == RESULT_OK){
                    c.setBotaoLiga((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_INPUT:
                if(resultCode == RESULT_OK){
                    c.setBotaoInput((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_OPCOES:
                if(resultCode == RESULT_OK){
                    c.setBotaoOpcoes((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_VOLTAR:
                if(resultCode == RESULT_OK){
                    c.setBotaoVoltar((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_SAIR:
                if(resultCode == RESULT_OK){
                    c.setBotaoSair((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_MENU:
                if(resultCode == RESULT_OK){
                    c.setBotaoMenu((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_CIMA:
                if(resultCode == RESULT_OK){
                    c.setBotaoCima((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_OK:
                if(resultCode == RESULT_OK){
                    c.setBotaoOk((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_BAIXO:
                if(resultCode == RESULT_OK){
                    c.setBotaoBaixo((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_ESQ:
                if(resultCode == RESULT_OK){
                    c.setBotaoEsq((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_DIR:
                if(resultCode == RESULT_OK){
                    c.setBotaoDir((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_1:
                if(resultCode == RESULT_OK){
                    c.setBotao1((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_2:
                if(resultCode == RESULT_OK){
                    c.setBotao2((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_3:
                if(resultCode == RESULT_OK){
                    c.setBotao3((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_4:
                if(resultCode == RESULT_OK){
                    c.setBotao4((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_5:
                if(resultCode == RESULT_OK){
                    c.setBotao5((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_6:
                if(resultCode == RESULT_OK){
                    c.setBotao6((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_7:
                if(resultCode == RESULT_OK){
                    c.setBotao7((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_8:
                if(resultCode == RESULT_OK){
                    c.setBotao8((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_9:
                if(resultCode == RESULT_OK){
                    c.setBotao9((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_0:
                if(resultCode == RESULT_OK){
                    c.setBotao0((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_VOLMAIS:
                if(resultCode == RESULT_OK){
                    c.setBotaovolMais((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_VOLMENOS:
                if(resultCode == RESULT_OK){
                    c.setBotaoVolMenos((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_CHMAIS:
                if(resultCode == RESULT_OK){
                    c.setBotaoChMais((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_CHMENOS:
                if(resultCode == RESULT_OK){
                    c.setBotaoChMenos((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_A:
                if(resultCode == RESULT_OK){
                    c.setBotaoA((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_B:
                if(resultCode == RESULT_OK){
                    c.setBotaoB((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_C:
                if(resultCode == RESULT_OK){
                    c.setBotaoC((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_D:
                if(resultCode == RESULT_OK){
                    c.setBotaoD((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_ASTERISCO:
                if(resultCode == RESULT_OK){
                    c.setBotaoAsterisco((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_HASHTAG:
                if(resultCode == RESULT_OK){
                    c.setBotaoHashtag((String) data.getSerializableExtra("Novo"));
                }
                break;

        }
    }

    public void capturaLiga (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_LIGA);
    }

    public void capturaInput (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_INPUT);
    }
    public void capturaOpcoes (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_OPCOES);
    }
    public void capturaVoltar (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_VOLTAR);
    }
    public void capturaSair (View v){
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_SAIR);
    }
    public void capturaChMais (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_CHMAIS);
    }
    public void capturaMenu (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_MENU);
    }
    public void capturaCima (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_CIMA);
    }
    public void capturaOk (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_OK);
    }
    public void capturaBaixo (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_BAIXO);
    }
    public void capturaEsq (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_ESQ);
    }
    public void capturaDir (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_DIR);
    }
    public void captura1 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_1);
    }
    public void captura2 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_2);
    }
    public void captura3 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_3);
    }
    public void captura4 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_4);
    }
    public void captura5 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_5);
    }
    public void captura6 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_6);
    }
    public void captura7 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_7);
    }
    public void captura8 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_8);
    }
    public void captura9 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_9);
    }
    public void captura0 (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_0);
    }
    public void capturaVolMais (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_VOLMAIS);
    }
    public void capturaVolMenos (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_VOLMENOS);
    }
    public void capturaChMenos (View v){
        String e = new String ("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_CHMENOS);
    }
    public void capturaA (View v){
        String e = new String ("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_A);
    }
    public void capturaB (View v){
        String e = new String ("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_B);
    }
    public void capturaC (View v){
        String e = new String ("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_C);
    }
    public void capturaD (View v){
        String e = new String ("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_D);
    }
    public void capturaAsterisoc (View v){
        String e = new String ("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_ASTERISCO);
    }
    public void capturaHashtag (View v){
        String e = new String ("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_HASHTAG);
    }

    public void confirmar(View v){
        BD db = new BD(this);
        db.inserir(c);
        finish();
    }
}
