package com.githubapi.repositoryLanguage.di;

import android.content.Context;

import com.githubapi.di.application.ActivityScope;
import com.githubapi.repositoryLanguage.presenter.RepositoryPresenter;
import com.githubapi.repositoryLanguage.view.RepositoryLanguageActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aditya.k on 17-04-2017.
 */
@Module
public class RepositoryActivityModule {

    private RepositoryLanguageActivity mRepositoryLanguageActivity;

    public RepositoryActivityModule(RepositoryLanguageActivity languageActivity) {
        mRepositoryLanguageActivity = languageActivity;
    }

    @Provides
    public Context getActivityContext() {
        return mRepositoryLanguageActivity;
    }

    @Provides
    RepositoryPresenter getPresenter() {
        return new RepositoryPresenter(mRepositoryLanguageActivity);
    }
}
