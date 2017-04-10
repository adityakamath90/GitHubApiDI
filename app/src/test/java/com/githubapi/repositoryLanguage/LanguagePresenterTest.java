/*
 * Created by Aditya on 10/4/17 10:50 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 10:50 PM
 */

package com.githubapi.repositoryLanguage;

import com.githubapi.repositoryLanguage.presenter.LanguagePresenter;
import com.githubapi.repositoryLanguage.view.LanguageView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class LanguagePresenterTest {

    private static final String JAVA = "java";
    private LanguagePresenter mLanguagePresenter;
    @Mock
    private LanguageView langauegeView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mLanguagePresenter = new LanguagePresenter(langauegeView);
    }


    @Test
    public void testLanguageStringValid() {
        mLanguagePresenter.isLanguageStringValid(JAVA);
        Mockito.verify(langauegeView).moveToLanguageDetailScreen();
    }

    @Test
    public void testLanguageStringInValid() {
        mLanguagePresenter.isLanguageStringValid(null);
        Mockito.verify(langauegeView).displayMessage();
    }


    @After
    public void tearDown() {
        langauegeView = null;
        mLanguagePresenter = null;
    }


}
