/*
 * Created by Aditya on 9/4/17 11:29 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 11:29 PM
 */

package com.githubapi.repositoryLanguage.presenter;

import android.text.TextUtils;

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
        if (TextUtils.isEmpty(language)) {
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
        mLanguageView.displayMessage(errorMessage);
    }
}
