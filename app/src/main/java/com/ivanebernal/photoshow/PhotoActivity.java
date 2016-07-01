package com.ivanebernal.photoshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PhotoActivity extends AppCompatActivity {

    private String ACCESS_TOKEN;
    ImageView imageView;
    List<String> imageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        imageView = (ImageView) findViewById(R.id.profile_pic);
        String uri = String.valueOf(getIntent().getData());
        Log.d("URI", uri);
        ACCESS_TOKEN = uri.split("=")[1];
        Log.d("CODE", ACCESS_TOKEN);
        getPhotoWithHashtag();
//        Picasso.with(getApplicationContext()).load(imageUrls.get(0)).into(imageView);
    }

    private void getPhotoWithHashtag(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.instagram.com/v1/users/254859349?access_token=" + ACCESS_TOKEN);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                    String response = convertInputStreamToString(inputStream);
                    Log.i("GOT", String.valueOf(urlConnection.getResponseCode()));
                    Log.i("RESPONSE", response);
//                    String imageUrl = response.substring(response.indexOf("https"), response.indexOf("jpg")+3);
//                    imageUrls.add(imageUrl);
//                    Log.i("URL", imageUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null) result += line;
        if(inputStream != null) inputStream.close();
        return result;
    }
}
