/*
 * Created by Aditya on 9/4/17 9:22 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 9:22 PM
 */

package com.githubapi.repositoryLanguage.view;

import com.githubapi.repositoryLanguage.model.Repository;

import java.util.List;

/**
 * Methods which are invoked by @link {@link com.githubapi.repositoryLanguage.presenter.LanguagePresenter}
 * and implemented by @link {@link LanguageActivity}
 */

public interface LanguageView {

    void showDialog();
    void dismissDialog();

    void moveToLanguageDetailScreen(List<Repository> repositoryList);
    void displayMessage(String message);
}
