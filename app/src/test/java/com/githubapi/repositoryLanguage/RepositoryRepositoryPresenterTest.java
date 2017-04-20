/*
 * Created by Aditya on 11/4/17 1:27 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 1:26 AM
 */

package com.githubapi.repositoryLanguage;

import com.githubapi.repositoryLanguage.presenter.RepositoryPresenter;
import com.githubapi.repositoryLanguage.view.LanguageView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class RepositoryRepositoryPresenterTest {

    private static final String JAVA = "java";
    private RepositoryPresenter mRepositoryPresenter;
    @Mock
    private LanguageView mLanguageView;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mRepositoryPresenter = new RepositoryPresenter(mLanguageView);
    }


    @Test
    public void testLanguageStringValid() {
        mRepositoryPresenter.isLanguageStringValid(JAVA);
        Mockito.verify(mLanguageView).moveToLanguageDetailScreen();
    }

    @Test
    public void testLanguageStringInValid() {
        mRepositoryPresenter.isLanguageStringValid(null);
        Mockito.verify(mLanguageView).displayMessage();
    }


    @After
    public void tearDown() {
        mLanguageView = null;
        mRepositoryPresenter = null;
    }


}
