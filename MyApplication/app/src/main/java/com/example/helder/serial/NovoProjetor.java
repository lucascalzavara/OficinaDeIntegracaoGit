package com.example.helder.serial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NovoProjetor extends AppCompatActivity {


    private static final int BOTAO_LIGA = 1;
    private static final int BOTAO_SS = 2;
    private static final int BOTAO_COMP = 3;
    private static final int BOTAO_VIDEO = 4;
    private static final int BOTAO_USB = 5;
    private static final int BOTAO_LAN = 6;
    private static final int BOTAO_MENU = 7;
    private static final int BOTAO_ESC = 8;
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
            case BOTAO_SS:
                if(resultCode == RESULT_OK){
                    c.setBotaoSs((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_COMP:
                if(resultCode == RESULT_OK){
                    c.setBotaoComp ((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_VIDEO:
                if(resultCode == RESULT_OK){
                    c.setBotaoVideo((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_USB:
                if(resultCode == RESULT_OK){
                    c.setBotaoUsb((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_LAN:
                if(resultCode == RESULT_OK){
                    c.setBotaoLan((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_MENU:
                if(resultCode == RESULT_OK){
                    c.setBotaoMenu((String) data.getSerializableExtra("Novo"));
                }
                break;
            case BOTAO_ESC:
                if(resultCode == RESULT_OK){
                    c.setBotaoEsc((String) data.getSerializableExtra("Novo"));
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
        }
    }

    public void capturaLiga (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_LIGA);
    }

    public void capturaSs (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_SS);
    }
    public void capturaComp (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_COMP);
    }
    public void capturaVideo (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_VIDEO);
    }
    public void capturaUsb (View v){
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_USB);
    }
    public void capturaLan (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_LAN);
    }
    public void capturaMenu (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_MENU);
    }
    public void capturaEsc (View v){
        String e = new String("*");
        connect.write(e.getBytes());
        Intent novoCod = new Intent(this, Main2Activity.class);
        startActivityForResult(novoCod, BOTAO_ESC);
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

    public void confirmar(View v){
        BD db = new BD(this);
        db.inserir(c);
        finish();
    }
}
