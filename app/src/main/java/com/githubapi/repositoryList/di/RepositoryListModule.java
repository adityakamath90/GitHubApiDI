package com.githubapi.repositoryList.di;

import android.content.Context;

import com.githubapi.di.application.ApplicationComponent;
import com.githubapi.repositoryList.model.RepositoryDataHandler;
import com.githubapi.repositoryList.presenter.RepositoryListPresenter;
import com.githubapi.repositoryList.view.RepositoryList;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aditya.k on 17-04-2017.
 */
@Module
public class RepositoryListModule {

    private RepositoryList mRepositoryList;
    private RepositoryDataHandler mDataHandler;


    public RepositoryListModule(RepositoryList repositoryList, RepositoryDataHandler dataHandler) {
        mRepositoryList = repositoryList;
        mDataHandler = dataHandler;
    }

    @Provides
    Context getActivityContext(){
       return mRepositoryList;
    }

    @Provides RepositoryListPresenter getPresenter(){
        return new RepositoryListPresenter(mRepositoryList,mDataHandler);
    }
    @Provides RepositoryDataHandler getDataHandler(){
        return mDataHandler;
    }
}
