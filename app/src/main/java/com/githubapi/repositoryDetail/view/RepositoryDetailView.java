/*
 * Created by Aditya on 10/4/17 7:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 6:31 PM
 */

package com.githubapi.repositoryDetail.view;

/**
 * Created by Aditya on 10/04/17.
 */

public interface RepositoryDetailView {

    void showDialog();

    void dismissDialog();

    void showMessage(String message);

    void showIssues(String issues);

    void showContributors(String contributors);
}
