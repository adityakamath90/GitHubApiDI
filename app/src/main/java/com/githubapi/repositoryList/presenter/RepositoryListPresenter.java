/*
 * Created by Aditya on 10/4/17 5:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 5:01 PM
 */

package com.githubapi.repositoryList.presenter;

import com.githubapi.repositoryLanguage.model.Item;
import com.githubapi.repositoryLanguage.model.Repository;
import com.githubapi.repositoryList.model.RepositoryDataHandler;
import com.githubapi.repositoryList.view.RepositoryListActivityView;

import java.util.List;

/**
 * Created by Aditya on 09/04/17.
 */

public class RepositoryListPresenter implements RepositoryListener {

    private RepositoryListActivityView mRepositoryListActivityView;
    private RepositoryDataHandler mRepositoryDataHandler;

    public RepositoryListPresenter(RepositoryListActivityView listActivityView) {
        mRepositoryListActivityView = listActivityView;
        mRepositoryDataHandler = new RepositoryDataHandler(this);
    }

    public boolean isRepoListEmpty(List<Item> itemList) {
        boolean isRepoListEmpty = false;

        if (itemList == null || itemList.isEmpty()) {
            isRepoListEmpty = true;
        }

        return isRepoListEmpty;
    }


    public void fetchRepos(String language, String page) {
        mRepositoryListActivityView.showDialog();
        mRepositoryDataHandler.fetchRepos(language, page);

    }


    @Override
    public void onSuccess(Repository repositoryList) {
        mRepositoryListActivityView.dismissDialog();
        mRepositoryListActivityView.notifyDataSetChanged(repositoryList.getItems());
    }

    @Override
    public void onFailure(String errorMessage) {
        mRepositoryListActivityView.dismissDialog();
        mRepositoryListActivityView.showMessage(errorMessage);
    }
}
