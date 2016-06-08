package com.example.helder.serial;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2Activity extends AppCompatActivity {
    private static EditText sinal;
    private Button btCancel,btOk;
    private static boolean copy=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sinal = (EditText)findViewById(R.id.editText2);
        btCancel = (Button)findViewById(R.id.btCancel);
        btCancel.setOnClickListener(onClickBtCancel);
        btOk=(Button)findViewById(R.id.btok);
        btOk.setOnClickListener(onClickBtOk);
    }

    private View.OnClickListener onClickBtCancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setResult(RESULT_CANCELED);
            finish();
        }
    };

    private View.OnClickListener onClickBtOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String novo;
            if(copy) {
                int j = 0;
                char[] dados = sinal.getText().toString().toCharArray();
                char[] tratado = new char[dados.length];
                for (int i = 0; i < dados.length; i++) {
                    if ((dados[i] >= '0' && dados[i] <= '9') || (dados[i] == '#') || (dados[i] == ',') || (dados[i] == '$')) {
                        tratado[j] = dados[i];
                        j++;
                    }
                }
                String cmd = new String(Arrays.copyOfRange(tratado, 0, j));
                novo = cmd;
            }else{
                novo = sinal.getText().toString();
            }
            Intent ret = new Intent();
            ret.putExtra("Novo",novo);
            setResult(RESULT_OK,ret);
            finish();
        }
    };

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            byte[] data = bundle.getByteArray("data");
            if(data!=null) {
                String dataString = new String(data);
                sinal.append(dataString);
                copy=true;
                sinal.setEnabled(false);
            }
        }
    };

}
