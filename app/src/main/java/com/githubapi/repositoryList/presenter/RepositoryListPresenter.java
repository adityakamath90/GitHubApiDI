/*
 * Created by Aditya on 11/4/17 2:34 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 2:34 AM
 */

package com.githubapi.repositoryList.presenter;

import com.githubapi.repositoryLanguage.model.Repository;
import com.githubapi.repositoryList.model.RepositoryDataHandler;
import com.githubapi.repositoryList.view.RepositoryListActivityView;

import javax.inject.Inject;

/**
 * Created by Aditya on 09/04/17.
 */

public class RepositoryListPresenter implements RepositoryListener {

    private RepositoryListActivityView mRepositoryListActivityView;
    private RepositoryDataHandler mRepositoryDataHandler;

    @Inject
    public RepositoryListPresenter(RepositoryListActivityView listActivityView,
                                   RepositoryDataHandler repositoryDataHandler) {
        mRepositoryListActivityView = listActivityView;
        mRepositoryDataHandler = repositoryDataHandler;
    }

    public void fetchRepos(String language, String page) {
        mRepositoryListActivityView.showDialog();
        mRepositoryDataHandler.fetchRepos(language, page);

    }


    @Override
    public void onSuccess(Repository repositoryList) {
        mRepositoryListActivityView.dismissDialog();
        if (repositoryList != null) {
            mRepositoryListActivityView.notifyDataSetChanged(repositoryList.getItems());
        } else {
            mRepositoryListActivityView.showMessage("No repository found");
        }
    }

    @Override
    public void onFailure(String errorMessage) {
        mRepositoryListActivityView.dismissDialog();
        mRepositoryListActivityView.showMessage(errorMessage);
    }
}
