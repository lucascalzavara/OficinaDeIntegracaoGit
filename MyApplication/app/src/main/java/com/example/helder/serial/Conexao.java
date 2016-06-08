package com.example.helder.serial;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.os.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

public class Conexao extends Thread implements Serializable{

    BluetoothSocket btSocket = null;
    BluetoothServerSocket btServerSocket = null;
    InputStream input = null;
    OutputStream output = null;
    String btDevAddress = null;
    String myUUID = "00001101-0000-1000-8000-00805F9B34FB";
    boolean server;
    boolean running = false;

    public Conexao(String btDevAddress) {
        this.server = false;
        this.btDevAddress = btDevAddress;
    }

    public void run() {
        this.running = true;
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            BluetoothDevice btDevice = btAdapter.getRemoteDevice(btDevAddress);
            btSocket = btDevice.createRfcommSocketToServiceRecord(UUID.fromString(myUUID));
            btAdapter.cancelDiscovery();
            if (btSocket != null) {
                btSocket.connect();
                toMainActivity(new String("conectado").getBytes(),"status");
            }
            else
                toMainActivity(new String("Erro Socket").getBytes(),"erro");
        } catch (IOException e) {
            e.printStackTrace();
            toMainActivity(new String(e.getMessage()).getBytes(),"ex");
        }
        if(btSocket != null) {
            try {
                input = btSocket.getInputStream();
                output = btSocket.getOutputStream();
                byte[] buffer = new byte[2048];
                int bytes;
                while(running) {
                    bytes = input.read(buffer);
                    toMain2Activity(Arrays.copyOfRange(buffer, 0, bytes));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private void toMain2Activity(byte[] data) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putByteArray("data", data);
        message.setData(bundle);
        Main2Activity.handler.sendMessage(message);
    }

    private void toMainActivity(byte[] data,String tipo) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putByteArray(tipo, data);
        message.setData(bundle);
        MainActivity.handler.sendMessage(message);
    }
    public void write(byte[] data) {
        if(output != null) {
            try {
                output.write(data);
            } catch (IOException e) {
                e.printStackTrace();
                toMainActivity(new String(e.getMessage()).getBytes(),"ex");
            }
        }
    }
    public void cancel() {
        try {
            running = false;
            output.close();
            input.close();
            btSocket.close();
            toMainActivity(new String("desconectado").getBytes(),"status");
        } catch (IOException e) {
            e.printStackTrace();
        }
        running = false;
    }
}
