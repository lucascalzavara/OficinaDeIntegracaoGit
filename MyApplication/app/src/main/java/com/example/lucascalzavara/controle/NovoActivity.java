package com.example.lucascalzavara.controle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NovoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        String[] aparelhos = new String[]{"Selecione", "TV", "Projetor"};

        ArrayAdapter<String> aparelhosAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aparelhos);
        aparelhosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spAparelhos = (Spinner) findViewById(R.id.spinner2);
        spAparelhos.setAdapter(aparelhosAdapter);
    }

    public void botaook (View View){
        EditText edText = (EditText) findViewById(R.id.editText);
        if(!edText.getText().toString().isEmpty()) {
            Spinner spAparelhos = (Spinner) findViewById(R.id.spinner2);
            switch ((String) spAparelhos.getSelectedItem()) {
                case "Projetor":
                    Intent novoProjetor = new Intent(this, NovoProjetorActivity.class);
                    startActivity(novoProjetor);
                    break;
                case "TV":
                    Intent novoTV = new Intent(this, NovoTVActivity.class);
                    startActivity(novoTV);
                    break;
                default:
                    Toast.makeText(this,"Selecione um aparelho", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Preencha o nome", Toast.LENGTH_LONG).show();
        }
    }
}
