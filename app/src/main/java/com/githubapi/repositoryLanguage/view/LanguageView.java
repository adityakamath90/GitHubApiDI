/*
 * Created by Aditya on 9/4/17 11:29 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 11:29 PM
 */

package com.githubapi.repositoryLanguage.view;

import com.githubapi.repositoryLanguage.model.Repository;

/**
 * Methods which are invoked by @link {@link com.githubapi.repositoryLanguage.presenter.LanguagePresenter}
 * and implemented by @link {@link LanguageActivity}
 */

public interface LanguageView {

    void showDialog();
    void dismissDialog();

    void moveToLanguageDetailScreen(Repository repositoryList);
    void displayMessage(String message);
}
