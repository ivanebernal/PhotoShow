package com.ivanebernal.photoshow;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ConnectInstaIntent mBoundService;
    private boolean mServiceBound;
    ServiceConnection serviceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ConnectInstaIntent.class);
        intent.setAction(ApplicationData.CONECT_INSTA_ACTION);

        connectToInstagram();

//        serviceConnection = new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName name, IBinder service) {
//                ConnectInstaIntent.MyBinder myBinder = (ConnectInstaIntent.MyBinder) service;
//                mBoundService = myBinder.getService();
//                mServiceBound = true;
//            }
//
//            @Override
//            public void onServiceDisconnected(ComponentName name) {
//
//            }
//        };
        //bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        //unbindService(serviceConnection);
    }

    protected void connectToInstagram() {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        URL url = new URL(ApplicationData.AUTHURL + "?client_id=" + ApplicationData.CLIENT_ID + "&redirect_uri=" + ApplicationData.CALLBACK_URI + "&response_type=code");
//                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                        connection.setRequestMethod("GET");
//                        Log.i("Content", connection.getResponseMessage());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            thread.start();
        Uri uri = Uri.parse(ApplicationData.AUTHURL + "?client_id=" + ApplicationData.CLIENT_ID + "&redirect_uri=" + ApplicationData.CALLBACK_URI + "&response_type=token");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.instagram.android");

        try{
            startActivity(intent);
        }catch (Exception e){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(ApplicationData.AUTHURL + "?client_id=" + ApplicationData.CLIENT_ID + "&redirect_uri=" + ApplicationData.CALLBACK_URI + "&response_type=token&scope=public_content")));
        }
    }
}
