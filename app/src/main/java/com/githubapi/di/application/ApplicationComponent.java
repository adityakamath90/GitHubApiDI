package com.githubapi.di.application;

import android.app.Application;
import android.content.Context;

import com.githubapi.GithubApplication;
import com.githubapi.repositoryDetail.view.RepositoryDetailActivity;
import com.githubapi.repositoryList.view.RepositoryList;
import com.githubapi.utils.RestClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by aditya.k on 17-04-2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(GithubApplication demoApplication);
    Application getApplication();
    RestClient getRestClient();
}
