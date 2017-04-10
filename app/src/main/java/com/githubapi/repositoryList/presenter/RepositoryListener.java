/*
 * Created by Aditya on 10/4/17 5:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 4:19 PM
 */

package com.githubapi.repositoryList.presenter;

import com.githubapi.repositoryLanguage.model.Repository;

/**
 * Created by Aditya on 09/04/17.
 */

public interface RepositoryListener {
    void onSuccess(Repository repository);

    void onFailure(String message);
}
