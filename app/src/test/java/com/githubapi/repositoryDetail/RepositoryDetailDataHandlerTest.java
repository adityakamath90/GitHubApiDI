/*
 * Created by Aditya on 11/4/17 1:27 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 1:27 AM
 */

package com.githubapi.repositoryDetail;

import com.githubapi.repositoryDetail.model.RepositoryDetailDataHandler;
import com.githubapi.repositoryDetail.model.dto.DescriptionType;
import com.githubapi.repositoryList.presenter.RepositoryListener;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Aditya on 11/04/17.
 */

public class RepositoryDetailDataHandlerTest {


    public static final String BUTTERKNIFE = "Butterknife";
    @Mock
    RepositoryDetailDataHandler<DescriptionType> mRepositoryDetailDataHandler;
    @Mock
    RepositoryListener mRepositoryDetailListener;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testContributors() {
        mRepositoryDetailDataHandler.getListOfContributors(BUTTERKNIFE);
        Mockito.verifyZeroInteractions(mRepositoryDetailListener);
    }

    @Test
    public void testIssues() {
        mRepositoryDetailDataHandler.getListOfIssues(BUTTERKNIFE);
        Mockito.verifyZeroInteractions(mRepositoryDetailListener);
    }


    @After
    public void tearDown() {
        mRepositoryDetailDataHandler = null;
        mRepositoryDetailListener = null;
    }

}
