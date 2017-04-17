package com.githubapi;

import android.app.Application;

import com.githubapi.di.application.ApplicationComponent;
import com.githubapi.di.application.ApplicationModule;
import com.githubapi.di.application.DaggerApplicationComponent;


/**
 * Created by aditya.k on 17-04-2017.
 */

public class GithubApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationComponent applicationComponent = DaggerApplicationComponent
                .builder().applicationModule(new ApplicationModule(this)).build();
        applicationComponent.inject(this);
    }
}
