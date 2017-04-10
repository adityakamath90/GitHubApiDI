/*
 * Created by Aditya on 10/4/17 5:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 5:01 PM
 */

package com.githubapi.repositoryLanguage.view;

/**
 * Methods which are invoked by @link {@link com.githubapi.repositoryLanguage.presenter.LanguagePresenter}
 * and implemented by @link {@link LanguageActivity}
 */

public interface LanguageView {
    void moveToLanguageDetailScreen();

    void displayMessage();
}
