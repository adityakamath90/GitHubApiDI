/*
 * Created by Aditya on 10/4/17 10:50 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 10:50 PM
 */

package com.githubapi.repositoryList;

import com.githubapi.repositoryLanguage.model.Repository;
import com.githubapi.repositoryList.model.RepositoryDataHandler;
import com.githubapi.repositoryList.presenter.RepositoryListPresenter;
import com.githubapi.repositoryList.view.RepositoryListActivityView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Aditya on 10/04/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class RepositoryListPresenterTest {

    private static final String JAVA = "java";
    private static final String NETWORK_ERROR = "network error";
    public static final String PAGE = "1";

    private RepositoryListPresenter mRepositoryListPresenter;
    @Mock
    private RepositoryListActivityView mRepositoryListActivityView;
    @Mock
    private RepositoryDataHandler mRepositoryDataHandler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mRepositoryListPresenter = new RepositoryListPresenter(mRepositoryListActivityView,mRepositoryDataHandler);
    }

    @Test
    public void testForSuccessfullListOfLanguages() {
        mRepositoryListPresenter.fetchRepos(JAVA, PAGE);
        Mockito.verify(mRepositoryListActivityView).showDialog();
        mRepositoryListPresenter.onSuccess(new Repository());
        Mockito.verify(mRepositoryListActivityView).dismissDialog();
        Mockito.verify(mRepositoryListActivityView).notifyDataSetChanged(null);
    }

    @Test
    public void testForFailedApiForLanguage() {
        mRepositoryListPresenter.fetchRepos(JAVA, PAGE);
        Mockito.verify(mRepositoryListActivityView).showDialog();
        mRepositoryListPresenter.onFailure(NETWORK_ERROR);
        Mockito.verify(mRepositoryListActivityView).dismissDialog();
        Mockito.verify(mRepositoryListActivityView).showMessage(NETWORK_ERROR);
    }

    @After
    public void tearDown() {
        mRepositoryListPresenter = null;
        mRepositoryListActivityView = null;
    }
}
