/*
 * Created by Aditya on 11/4/17 1:27 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 1:27 AM
 */

package com.githubapi.repositoryList;

import com.githubapi.repositoryList.model.RepositoryDataHandler;
import com.githubapi.repositoryList.presenter.RepositoryListener;
import com.githubapi.utils.RestClient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;

/**
 * Created by Aditya on 10/04/17.
 */

public class RepositoryListDataHandlerTest {

    public static final String JAVA = "Java";
    public static final String PAGE_NO = "1";
    @Mock
    private RepositoryListener mRepositoryListener;
    private RepositoryDataHandler mRepositoryDataHandler;
    @Mock
    RestClient mRestClient;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mRepositoryDataHandler = new RepositoryDataHandler(mRepositoryListener,mRestClient);
    }

    @Test
    public void testRepoList() {
        mRepositoryDataHandler.fetchRepos(JAVA, PAGE_NO);
        Mockito.verifyZeroInteractions(mRepositoryListener);
    }


    @After
    public void tearDown() {
        mRepositoryDataHandler = null;
        mRepositoryListener = null;
    }
}
