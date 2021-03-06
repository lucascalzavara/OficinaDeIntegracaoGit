package com.example.helder.serial;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Lucas Calzavara on 09/06/2016.
 */
public class Servico extends Service {

    Conexao connect;
    String address;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null){
            address = intent.getStringExtra("address");
            connect = new Conexao(address);
        }
        return 0;
    }



    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
