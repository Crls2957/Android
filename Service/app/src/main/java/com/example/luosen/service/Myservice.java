package com.example.luosen.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Myservice extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Log.d("提交时间",format.format(System.currentTimeMillis()));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
