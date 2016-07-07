package com.ivanebernal.photoshow;

import android.content.Context;
import android.util.Log;

import com.ivanebernal.photoshow.InstagramService.InstagramService;
import com.ivanebernal.photoshow.Models.UserRecentMedia;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ivan on 21/06/16.
 */
public class InstagramTransport {
    public static final String BASE_URL = "https://api.instagram.com/v1/";
    private onFragmentChange mContext;

    public InstagramTransport(Context context){
        mContext = (onFragmentChange)context;
    }

    public Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getUserRecentMedia(String token){
        final UserRecentMedia userRecentMedia = new UserRecentMedia();
        final InstagramService instagramService = getRetrofit().create(InstagramService.class);
        Call<UserRecentMedia> userRecentMediaCall = instagramService.getUserRecentMedia(token);
        userRecentMediaCall.enqueue(new Callback<UserRecentMedia>() {
            @Override
            public void onResponse(Call<UserRecentMedia> call, Response<UserRecentMedia> response) {
                Log.d("Response code", String.valueOf(response.code()));
                if(response.code() == 200) {
                    userRecentMedia.setData(response.body().getData());
                    userRecentMedia.setMeta(response.body().getMeta());
                    userRecentMedia.setPagination(response.body().getPagination());
                    mContext.fragmentChange(userRecentMedia);
                }
            }

            @Override
            public void onFailure(Call<UserRecentMedia> call, Throwable t) {

            }
        });
    }

    interface onFragmentChange{
        void fragmentChange(UserRecentMedia userRecentMedia);
    }

}
