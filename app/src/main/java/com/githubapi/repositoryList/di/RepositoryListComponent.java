package com.githubapi.repositoryList.di;

import android.content.Context;

import com.githubapi.di.application.ApplicationComponent;
import com.githubapi.di.PerActivity;
import com.githubapi.repositoryList.presenter.RepositoryListPresenter;
import com.githubapi.repositoryList.view.RepositoryList;

import dagger.Component;

/**
 * Created by aditya.k on 17-04-2017.
 */
@PerActivity
@Component(modules = {RepositoryListModule.class},dependencies = ApplicationComponent.class)
public interface RepositoryListComponent {
    void inject(RepositoryList repositoryList);
    Context getActivityContext();
    RepositoryListPresenter getPresenter();
}
