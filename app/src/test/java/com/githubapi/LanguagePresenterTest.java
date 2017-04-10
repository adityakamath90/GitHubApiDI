/*
 * Created by Aditya on 10/4/17 4:03 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 4:03 PM
 */

package com.githubapi;

import com.githubapi.repositoryLanguage.model.Item;
import com.githubapi.repositoryLanguage.presenter.LanguagePresenter;
import com.githubapi.repositoryLanguage.view.LanguageView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;


public class LanguagePresenterTest {

    public static final String JAVA = "java";
    private LanguagePresenter mLanguagePresenter;
    @Mock
    private LanguageView langauegeView;

    @Before
    public void setUp() {
        mLanguagePresenter = new LanguagePresenter(langauegeView);
    }



    @Test
    public void languageIsEmpty() {
        Assert.assertTrue(mLanguagePresenter.isLanguageStringValid(JAVA));
    }

    @Test
    public void repoListIsNotEmpty() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item());
        Assert.assertFalse(mLanguagePresenter.isRepoListEmpty(itemList));
    }

    @After
    public void tearDown() {
        langauegeView = null;
        mLanguagePresenter = null;
    }


}
