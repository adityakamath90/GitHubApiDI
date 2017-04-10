/*
 * Created by Aditya on 10/4/17 10:50 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 10:50 PM
 */

package com.githubapi.repositoryDetail;

import com.githubapi.repositoryDetail.model.RepositoryDetailDataHandler;
import com.githubapi.repositoryDetail.model.dto.Contributor;
import com.githubapi.repositoryDetail.model.dto.DescriptionType;
import com.githubapi.repositoryDetail.model.dto.Issues;
import com.githubapi.repositoryDetail.presenter.RepositoryDetailPresenter;
import com.githubapi.repositoryDetail.view.RepositoryDetailView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aditya on 10/04/17.
 */

public class RepositoryDetailPresenterTest {

    private static final String JAVA_REPO = "java";
    private static final String NETWORK_ERROR = "network error";
    private RepositoryDetailPresenter mRepositoryDetailPresenter;
    @Mock
    private RepositoryDetailView mRepositoryDetailView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mRepositoryDetailPresenter = new RepositoryDetailPresenter(mRepositoryDetailView);
    }

    @Test
    public void testContributorsListSucess() {
        mRepositoryDetailPresenter.getRepositoryContributors(JAVA_REPO);
        List<DescriptionType> contributorList = new ArrayList<>();
        Contributor contributor = new Contributor();
        contributor.setLogin("XYZ");
        contributorList.add(contributor);
        mRepositoryDetailPresenter.onSuccess(RepositoryDetailDataHandler.API_CONTRIBUTORS, contributorList);
        Mockito.verify(mRepositoryDetailView).dismissDialog();
        Mockito.verify(mRepositoryDetailView).showContributors(Mockito.anyString());
    }

    @Test
    public void testContributorsListFailure() {
        mRepositoryDetailPresenter.getRepositoryContributors(JAVA_REPO);
        mRepositoryDetailPresenter.onFailure(RepositoryDetailDataHandler.API_CONTRIBUTORS, NETWORK_ERROR);
        Mockito.verify(mRepositoryDetailView).dismissDialog();
        Mockito.verify(mRepositoryDetailView).showMessage(Mockito.anyString());

    }

    @Test
    public void testIssueListSucess() {
        mRepositoryDetailPresenter.getRepositoryIssues(JAVA_REPO);
        List<DescriptionType> issueList = new ArrayList<>();
        Issues issues = new Issues();
        issues.setTitle("XYZ");
        issueList.add(issues);
        mRepositoryDetailPresenter.onSuccess(RepositoryDetailDataHandler.API_ISSUES, issueList);
        Mockito.verify(mRepositoryDetailView).dismissDialog();
        Mockito.verify(mRepositoryDetailView).showIssues(Mockito.anyString());
    }

    @Test
    public void testIssueListFailure() {
        mRepositoryDetailPresenter.getRepositoryContributors(JAVA_REPO);
        mRepositoryDetailPresenter.onFailure(RepositoryDetailDataHandler.API_ISSUES, NETWORK_ERROR);
        Mockito.verify(mRepositoryDetailView).dismissDialog();
        Mockito.verify(mRepositoryDetailView).showMessage(Mockito.anyString());
    }


    @After
    public void tearDown() {
        mRepositoryDetailPresenter = null;
        mRepositoryDetailView = null;
    }

}
