/*
 * Created by Aditya on 9/4/17 11:42 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 11:42 PM
 */

package com.githubapi;

import com.githubapi.repositoryLanguage.presenter.LanguagePresenter;
import com.githubapi.repositoryLanguage.view.LanguageView;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;


public class LanguagePresenterTest {

    private LanguagePresenter mLanguagePresenter;
    @Mock
    LanguageView langauegeView;

    @Test
    public void languageIsNotEmpty() {
        ;
        Assert.assertTrue(new LanguagePresenter(langauegeView).isLanguageStringValid(""));

    }


}
