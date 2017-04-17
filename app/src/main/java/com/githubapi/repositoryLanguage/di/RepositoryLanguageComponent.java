package com.githubapi.repositoryLanguage.di;

import android.content.Context;

import com.githubapi.repositoryLanguage.presenter.RepositoryPresenter;
import com.githubapi.repositoryLanguage.view.RepositoryLanguageActivity;

import dagger.Component;
import dagger.Provides;

/**
 * Created by aditya.k on 17-04-2017.
 */

@Component(modules = RepositoryActivityModule.class)
public interface RepositoryLanguageComponent {
    void inject(RepositoryLanguageActivity repositoryLanguageActivity);
     Context getActivityContext();
    RepositoryPresenter getPresenter();
}
