/*
 * Created by Aditya on 9/4/17 11:47 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 11:46 PM
 */

package com.githubapi;

import com.githubapi.repositoryLanguage.model.Item;
import com.githubapi.repositoryLanguage.presenter.LanguagePresenter;
import com.githubapi.repositoryLanguage.view.LanguageView;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;


public class LanguagePresenterTest {

    private LanguagePresenter mLanguagePresenter;
    @Mock
    LanguageView langauegeView;

    @Test
    public void languageIsEmpty() {
        Assert.assertTrue(new LanguagePresenter(langauegeView).isLanguageStringValid("java"));
    }

    @Test
    public void repoListIsNotEmpty() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item());
        Assert.assertFalse(new LanguagePresenter(langauegeView).isRepoListEmpty(itemList));
    }


}
