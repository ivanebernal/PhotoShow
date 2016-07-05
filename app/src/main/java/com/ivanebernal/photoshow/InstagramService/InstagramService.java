package com.ivanebernal.photoshow.InstagramService;

import com.ivanebernal.photoshow.Models.UserRecentMedia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Iván on 04/07/2016.
 */
public interface InstagramService {
    @GET("users/self/media/recent")
    Call<UserRecentMedia> getUserRecentMedia(@Query("access_token") String token);
}
