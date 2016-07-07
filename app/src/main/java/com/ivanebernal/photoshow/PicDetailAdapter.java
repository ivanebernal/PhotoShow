package com.ivanebernal.photoshow;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ivanebernal.photoshow.Models.UserRecentMedia;

/**
 * Created by ivan on 6/07/16.
 */
public class PicDetailAdapter extends FragmentPagerAdapter {
    private UserRecentMedia mUserMedia;
    public PicDetailAdapter(FragmentManager fm, UserRecentMedia userMedia) {
        super(fm);
        mUserMedia = userMedia;
    }

    @Override
    public Fragment getItem(int position) {
        return PhotoDetailFragment.newInstance(mUserMedia.getData().get(position));
    }

    @Override
    public int getCount() {
        return mUserMedia.getData().size();
    }
}
