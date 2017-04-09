/*
 * Created by Aditya on 9/4/17 9:22 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 9:22 PM
 */

package com.githubapi.repositoryLanguage.presenter;

import com.githubapi.repositoryLanguage.model.Repository;

import java.util.List;

/**
 * Created by Aditya on 09/04/17.
 */

public interface RepositoryListener {
    void onSuccess(List<Repository> repositoryList);

    void onFailure(String message);
}
