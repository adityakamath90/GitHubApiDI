/*
 * Created by Aditya on 10/4/17 5:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 5:01 PM
 */

package com.githubapi.repositoryList.view;

import com.githubapi.repositoryLanguage.model.Item;

import java.util.List;

/**
 * Created by Aditya on 10/04/17.
 */

public interface RepositoryListActivityView {

    void showDialog();

    void dismissDialog();

    void showMessage(String errorMesssage);

    void notifyDataSetChanged(List<Item> listItem);
}
