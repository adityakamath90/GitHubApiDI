/*
 * Created by Aditya on 9/4/17 9:21 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 9:21 PM
 */

package com.githubapi.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aditya on 09/04/17.
 */

public class RestClient {

    private static RestClient sRestClient;
    private static Retrofit sRetrofit;

    static {
        sRetrofit = new Retrofit.Builder().baseUrl(Config.BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build();
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
