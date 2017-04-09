/*
 * Created by Aditya on 9/4/17 11:29 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 11:29 PM
 */

package com.githubapi.repositoryLanguage.presenter;

import com.githubapi.repositoryLanguage.model.Repository;

/**
 * Created by Aditya on 09/04/17.
 */

public interface RepositoryListener {
    void onSuccess(Repository repository);

    void onFailure(String message);
}
