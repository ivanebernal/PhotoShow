package com.ivanebernal.photoshow;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ConnectInstaIntent.class);
        intent.setAction(ApplicationData.CONECT_INSTA_ACTION);

        connectToInstagram();
    }

    protected void connectToInstagram() {
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
