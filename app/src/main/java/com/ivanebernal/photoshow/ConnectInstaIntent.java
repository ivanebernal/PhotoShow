package com.ivanebernal.photoshow;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

import retrofit2.http.Url;

public class ConnectInstaIntent extends Service {

    private MyBinder mBinder = new MyBinder();
    private String mAction;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public ConnectInstaIntent() {
    }



    @Override
    public IBinder onBind(Intent intent) {
        mAction = intent.getAction();
        return mBinder;
    }

    public class MyBinder extends Binder {
        public ConnectInstaIntent getService(){return ConnectInstaIntent.this;}
    }
}
