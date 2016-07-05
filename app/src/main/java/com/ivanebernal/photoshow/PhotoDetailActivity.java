package com.ivanebernal.photoshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PhotoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        ImageView photoImageView = (ImageView) findViewById(R.id.photo_detailed);
        TextView captionTextView = (TextView) findViewById(R.id.caption);
        Intent intent = getIntent();
        Picasso.with(this).load(intent.getStringExtra("URL")).into(photoImageView);
        captionTextView.setText(intent.getStringExtra("CAPTION"));
    }
}
