/*
 * Created by Aditya on 10/4/17 10:50 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 10:50 PM
 */

package com.githubapi.repositoryList;

import com.githubapi.repositoryLanguage.model.GithubApiService;
import com.githubapi.repositoryList.model.RepositoryDataHandler;
import com.githubapi.repositoryList.presenter.RepositoryListener;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * Created by Aditya on 10/04/17.
 */

public class RepositoryListDataHandlerTest {

    @Mock
    private RepositoryListener mRepositoryListener;
    @InjectMocks
    GithubApiService mGithubApiService;
    private RepositoryDataHandler mRepositoryDataHandler;

    @Before
    public void setUp() {
        mRepositoryDataHandler = new RepositoryDataHandler(mRepositoryListener);
    }

    @Test
    public void checkForSuccessFullAPiCAll() {
        final ArgumentCaptor<GithubApiService> captor = ArgumentCaptor.forClass(GithubApiService.class);
        //captor.capture().;

    }

    @After
    public void tearDown() {
        mRepositoryDataHandler = null;
        mRepositoryListener = null;
    }
}
