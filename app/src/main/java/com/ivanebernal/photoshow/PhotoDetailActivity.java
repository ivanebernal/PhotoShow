package com.ivanebernal.photoshow;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ivanebernal.photoshow.Models.UserRecentMedia;

public class PhotoDetailActivity extends AppCompatActivity implements PhotoDetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_details);
        viewPager.setAdapter(new PicDetailAdapter(getSupportFragmentManager(), (UserRecentMedia) getIntent().getParcelableExtra("USER_MEDIA")));
        viewPager.setCurrentItem(getIntent().getIntExtra("POSITION", 0));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
