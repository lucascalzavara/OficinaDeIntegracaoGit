package com.example.helder.serial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class NovoControle extends AppCompatActivity {

    EditText nome;
    Spinner tipo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_controle);

        nome = (EditText)findViewById(R.id.NomeText);
        tipo = (Spinner)findViewById(R.id.spinnerTipo);
        ArrayAdapter<String> spAparelhos;
        String[] aparelhos = new String[]{"Selecione","Projetor", "TV"};
        spAparelhos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aparelhos);
        spAparelhos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tipo.setAdapter(spAparelhos);
    }

    public void botaoOk (View View){
        if(!nome.getText().toString().isEmpty()) {
            switch ((String) tipo.getSelectedItem()) {
                case "Projetor":
                    Intent intent = getIntent();
                    Conexao c = (Conexao) intent.getSerializableExtra("conexao");
                    Intent novoProjetor = new Intent(this, NovoProjetor.class);
                    novoProjetor.putExtra("conexao", c);
                    novoProjetor.putExtra("nome", nome.getText());
                    startActivity(novoProjetor);
                    break;
                case "TV":
                    Intent intent2 = getIntent();
                    Conexao c2 = (Conexao) intent2.getSerializableExtra("conexao");
                    Intent novoTv = new Intent(this, NovoTV.class);
                    novoTv.putExtra("conexao", c2);
                    novoTv.putExtra("nome", nome.getText());
                    startActivity(novoTv);
                    break;
                default:
                    Toast.makeText(this, "Selecione o Aparelho", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Preencha um nome", Toast.LENGTH_LONG).show();
        }
    }

    public void botaoCancelar (View View){
        finish();
    }
}
