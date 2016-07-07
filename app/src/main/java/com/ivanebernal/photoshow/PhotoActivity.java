package com.ivanebernal.photoshow;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ivanebernal.photoshow.InstagramService.InstagramService;
import com.ivanebernal.photoshow.Models.Datum;
import com.ivanebernal.photoshow.Models.UserRecentMedia;
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

public class PhotoActivity extends AppCompatActivity implements PhotoFragment.OnFragmentInteractionListener, InstagramTransport.onFragmentChange {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        String uri = String.valueOf(getIntent().getData());
        String ACCESS_TOKEN = uri.split("=")[1];
        Log.d("CODE", ACCESS_TOKEN);
        InstagramTransport instagramTransport = new InstagramTransport(this);
        instagramTransport.getUserRecentMedia(ACCESS_TOKEN);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void fragmentChange(UserRecentMedia userMedia) {
        progressBar.setVisibility(View.GONE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.photo_hoder, PhotoFragment.newInstance(userMedia))
                .commit();
    }
}
