package com.githubapi.di.application;

import android.app.Application;
import android.content.Context;

import com.githubapi.utils.RestClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aditya.k on 17-04-2017.
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
            mApplication =application;
    }

    @Singleton
    @Provides
    public Application getApplication(){
        return mApplication;
    }

    @Provides
    public RestClient getRestClient(){
        return RestClient.getInstance();
    }
}
