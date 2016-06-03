package com.example.lucascalzavara.controle;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int ENABLE_BLUETOOTH = 1;
    public static int SELECT_PAIRED_DEVICE = 2;
    public static int SELECT_DISCOVERED_DEVICE = 3;

    static TextView statusMessage;

    ConnectionThread connect;

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            Bundle bundle = msg.getData();
            byte[] data = bundle.getByteArray("data");
            String dataString= new String(data);

            if(dataString.equals("---N"))
                statusMessage.setText("Ocorreu um erro durante a conexão D:");
            else if(dataString.equals("---S"))
                statusMessage.setText("Conectado :D");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] aparelhos = new String[]{"Selecione", "TV", "Projetor"};
        ArrayAdapter<String> aparelhosAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aparelhos);
        aparelhosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spAparelhos = (Spinner) findViewById(R.id.spinner);
        spAparelhos.setAdapter(aparelhosAdapter);

        spAparelhos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch ((String) spAparelhos.getSelectedItem()){
                    case "Projetor":
                        Intent ProjetorActivity = new Intent(MainActivity.this, ProjetorActivity.class);
                        startActivity(ProjetorActivity);
                        break;
                    case "TV":
                        Intent tvActivity = new Intent(MainActivity.this, TVActivity.class);
                        startActivity(tvActivity);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        statusMessage = (TextView) findViewById(R.id.textView5);
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            statusMessage.setText("Que pena! Hardware Bluetooth não está funcionando :(");
            finish();
        } else {
            statusMessage.setText("Ótimo! Hardware Bluetooth está funcionando :)");
        }
        if(!btAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, ENABLE_BLUETOOTH);
            statusMessage.setText("Solicitando ativação do Bluetooth...");
        } else {
            statusMessage.setText("Bluetooth já ativado :)");
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ENABLE_BLUETOOTH){
            if(resultCode == RESULT_OK){
                statusMessage.setText("Bluetooth ativado");
            } else {
                statusMessage.setText("Bluetooth não ativado");
                finish();
            }
        } else if (requestCode == SELECT_PAIRED_DEVICE){
            if(resultCode == RESULT_OK){
                statusMessage.setText("Você selecionou "+ data.getStringExtra("btDevName")+ "\n" + data.getStringExtra("btDevAddress"));
                connect = new ConnectionThread(data.getStringExtra("btDevAdress"));
                connect.start();
            } else {
                statusMessage.setText("Nenhum dispositivo selecionado :(");
            }
        }
    }

    public void novo (View View){
        Intent novoActivity = new Intent(this, NovoActivity.class);
        startActivity(novoActivity);
    }

    public void searchPairedDevices(View view) {

        Intent searchPairedDevicesIntent = new Intent(this, PairedDevices.class);
        startActivityForResult(searchPairedDevicesIntent, SELECT_PAIRED_DEVICE);
    }
}
