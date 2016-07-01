package com.ivanebernal.photoshow;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ivan on 21/06/16.
 */
public class InstagramTransport {
    public static final String BASE_URL = "https://api.instagram.com";
    public Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
