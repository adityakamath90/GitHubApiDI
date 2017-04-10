/*
 * Created by Aditya on 10/4/17 3:56 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 2:59 PM
 */

package com.githubapi.repositoryLanguage.presenter;

import com.githubapi.repositoryLanguage.model.Item;
import com.githubapi.repositoryLanguage.model.LanguageDataHandler;
import com.githubapi.repositoryLanguage.model.Repository;
import com.githubapi.repositoryLanguage.view.LanguageView;

import java.util.List;

public class LanguagePresenter implements RepositoryListener {

    private LanguageView mLanguageView;
    private LanguageDataHandler mLanguageDataHandler;

    public LanguagePresenter(LanguageView languageView) {
        mLanguageView = languageView;
        mLanguageDataHandler = new LanguageDataHandler(this);
    }


    public boolean isLanguageStringValid(String language) {
        boolean isLanguageStringValid = true;
        if (language == null || language.isEmpty()) {
            isLanguageStringValid = false;
        }

        return isLanguageStringValid;
    }

    public boolean isRepoListEmpty(List<Item> itemList) {
        boolean isRepoListEmpty = false;

        if (itemList == null || itemList.isEmpty()) {
            isRepoListEmpty = true;
        }

        return isRepoListEmpty;
    }


    public void fetchRepos(String language) {
        mLanguageView.showDialog();
        mLanguageDataHandler.fetchRepos(language);

    }


    @Override
    public void onSuccess(Repository repositoryList) {
        mLanguageView.dismissDialog();
        mLanguageView.moveToLanguageDetailScreen(repositoryList);
    }

    @Override
    public void onFailure(String errorMessage) {
        mLanguageView.dismissDialog();
        mLanguageView.displayMessage(errorMessage);
    }
}
