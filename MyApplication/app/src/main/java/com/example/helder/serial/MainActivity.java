package com.example.helder.serial;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static Button btCon,btNew;
    private ListView botoes;
    private Spinner dispositivos;
    private List<Controle> lista_cotroles;
    private List<String> lista_dev;
    private ArrayAdapter arrayAdapter;
    private ArrayAdapter arrayAdapterSpinner;
    private BluetoothAdapter bluetoothAdapter;
    Set<BluetoothDevice> pairedDevices;
    Conexao connect;
    static boolean conectado=false;
    public static int ENABLE_BLUETOOTH = 1;
    public static int Novo_botao = 2;
    private static final boolean debug = true;
    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        BD db = new BD(this);
        lista_cotroles = db.buscarTodos();
        arrayAdapter = new ArrayAdapter<Controle>(this, android.R.layout.simple_list_item_1,lista_cotroles);

        btCon = (Button)findViewById(R.id.btcon);
        btCon.setOnClickListener(clickBtCon);
        btNew = (Button)findViewById(R.id.btNew);
        btNew.setOnClickListener(clickBtNew);
        btNew.setEnabled(false);
        botoes = (ListView)findViewById(R.id.listView);
        botoes.setAdapter(arrayAdapter);
        botoes.setOnItemClickListener(listaOnClick);
        lista_dev = new ArrayList<>();
        arrayAdapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista_dev);
        dispositivos = (Spinner)findViewById(R.id.spinner);
        dispositivos.setAdapter(arrayAdapterSpinner);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothAdapter!=null){
            if(!bluetoothAdapter.isEnabled()){
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, ENABLE_BLUETOOTH);
            }else{
                ListaDevices();
            }
        }
    }

    private void ListaDevices(){
        pairedDevices = bluetoothAdapter.getBondedDevices();
        arrayAdapterSpinner.clear();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
               lista_dev.add(device.getName());
            }
        }
        arrayAdapterSpinner.notifyDataSetChanged();
    }

    private View.OnClickListener clickBtCon = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(conectado){
                connect.cancel();
            }else {
                int pos = dispositivos.getSelectedItemPosition();
                List<BluetoothDevice> lista = new ArrayList<>(pairedDevices);
                BluetoothDevice device = lista.get(pos);
                String address = device.getAddress();

                Intent intent = new Intent(MainActivity.this, Servico.class);
                intent.putExtra("address", address);
                startService(intent);



                connect = new Conexao(device.getAddress());
                connect.start();
            }
        }
    };

    private View.OnClickListener clickBtNew = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(conectado) {
                Intent novoControle = new Intent(MainActivity.this, NovoControle.class);
                novoControle.putExtra("conexao", connect);
                startActivity(novoControle);
            }
        }
    };

    private AdapterView.OnItemClickListener listaOnClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(conectado) {
                int idControle = lista_cotroles.get(position).getId();
                String tipo = lista_cotroles.get(position).getTipo();
                switch (tipo){
                    case "Projetor":
                        Intent startProjetor = new Intent(MainActivity.this, ProjetorActivity.class);
                        startProjetor.putExtra("conexao", connect);
                        startProjetor.putExtra("id", idControle);
                        startActivity(startProjetor);
                        break;
                    case "TV":
                        Intent startTV = new Intent(MainActivity.this, TVActivity.class);
                        startTV.putExtra("conexao", connect);
                        startTV.putExtra("id", idControle);
                        startActivity(startTV);
                        break;
                }



                /*
                connect.write(b.getCodigo().getBytes());*/
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ENABLE_BLUETOOTH) {
            if(resultCode != RESULT_OK) {
                Toast.makeText(MainActivity.this, "Ative o Bluetooth", Toast.LENGTH_SHORT).show();
            }else{
                ListaDevices();
            }
        }
    }
    public static Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            byte[] data = bundle.getByteArray("erro");
            if(data!=null){
                String dataString= new String(data);
                Toast.makeText(context, dataString, Toast.LENGTH_SHORT).show();
            }else{
                data = bundle.getByteArray("ex");
                if(data!=null&&debug){
                    String dataString= new String(data);
                    Toast.makeText(context, dataString, Toast.LENGTH_SHORT).show();
                }else{
                    data = bundle.getByteArray("status");
                    if(data!=null){
                        String dataString= new String(data);
                        if(dataString.equals("conectado")){
                            btNew.setEnabled(true);
                            btCon.setText("Desconectar");
                            conectado=true;
                        }else
                            if(dataString.equals("desconectado")){
                                btNew.setEnabled(false);
                                btCon.setText("Conectar");
                                conectado=false;
                            }

                    }
                }
            }
        }
    };
}
