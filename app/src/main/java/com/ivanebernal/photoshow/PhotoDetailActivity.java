package com.ivanebernal.photoshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PhotoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        ImageView photoImageView = (ImageView) findViewById(R.id.photo_detailed);
        TextView captionTextView = (TextView) findViewById(R.id.caption);
        TextView likesText = (TextView) findViewById(R.id.num_likes);
        ImageView profilePic = (ImageView) findViewById(R.id.user_pic);
        TextView userName = (TextView) findViewById(R.id.user_name);

        Intent intent = getIntent();
        Picasso.with(this).load(intent.getStringExtra("URL")).resize(intent.getIntExtra("HEIGHT", 1)*2,intent.getIntExtra("WIDTH", 1)*2).into(photoImageView);
        captionTextView.setText(intent.getStringExtra("CAPTION"));
        likesText.setText(intent.getIntExtra("LIKES", 0)+"");
        userName.setText(intent.getStringExtra("USER_NAME"));
        Picasso.with(this).load(intent.getStringExtra("PROFILE_PIC")).into(profilePic);

    }
}
