/*
 * Created by Aditya on 10/4/17 3:57 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 3:57 PM
 */

package com.githubapi.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aditya on 09/04/17.
 */

public class RestClient {

    private static RestClient sRestClient;
    private static Retrofit sRetrofit;
    private static OkHttpClient sOkHttpClient;

    static {
        sOkHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return chain.proceed(request);
            }
        }).build();
        sRetrofit = new Retrofit.Builder().baseUrl(Config.BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).client(sOkHttpClient).build();
        sRestClient = new RestClient();
    }

    private RestClient() {

    }


    public static RestClient getInstance() {
        return sRestClient;
    }

    public <T> T getService(Class<T> clazz) {
        return sRetrofit.create(clazz);
    }


}
