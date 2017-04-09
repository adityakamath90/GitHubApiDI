/*
 * Created by Aditya on 9/4/17 7:17 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 7:17 PM
 */

package com.githubapi.language.view;

/**
 * Created by Aditya on 09/04/17.
 */

public interface LanguageView {

    void showDialog();
    void dismissDialog();
    void moveToLanguageDetailScreen();
    void displayMessage(String message);
}
