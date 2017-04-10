/*
 * Created by Aditya on 11/4/17 2:18 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 2:14 AM
 */

package com.githubapi.repositoryDetail.presenter;

import com.githubapi.repositoryDetail.model.RepositoryDetailDataHandler;
import com.githubapi.repositoryDetail.model.dto.Contributor;
import com.githubapi.repositoryDetail.model.dto.DescriptionType;
import com.githubapi.repositoryDetail.model.dto.Issues;
import com.githubapi.repositoryDetail.view.RepositoryDetailView;

import java.util.List;

/**
 * Created by Aditya on 10/04/17.
 */

public class RepositoryDetailPresenter implements RepositoryDetailListener<DescriptionType> {

    private static final String NEW_LINE = "\n";
    private static final String TAB = "\t";
    private static final String DOT = ".";
    private static final String SPACE = " ";
    private static final int THRESHOLD = 3;

    private RepositoryDetailView mRepositoryDetailView;
    private RepositoryDetailDataHandler mRepositoryDetailDataHandler;

    public RepositoryDetailPresenter(RepositoryDetailView detailView) {
        mRepositoryDetailView = detailView;
        mRepositoryDetailDataHandler = new RepositoryDetailDataHandler<>(this);
    }

    public void getRepositoryIssues(String repoName) {
        mRepositoryDetailDataHandler.getListOfIssues(repoName);
    }

    public void getRepositoryContributors(String repoName) {
        mRepositoryDetailView.showDialog();
        mRepositoryDetailDataHandler.getListOfContributors(repoName);
    }

    @Override
    public void onSuccess(int requestType, List<DescriptionType> list) {
        mRepositoryDetailView.dismissDialog();
        if (requestType == RepositoryDetailDataHandler.API_CONTRIBUTORS) {
            StringBuilder stringBuilder = new StringBuilder();
            int counter = 1;
            for (DescriptionType type : list) {
                Contributor contributor = (Contributor) type;
                stringBuilder.append(TAB).append(counter).append(DOT).append(SPACE).append(contributor.getLogin()).append(NEW_LINE);
                if (counter == THRESHOLD)
                    break;
                counter++;
            }
            mRepositoryDetailView.showContributors(stringBuilder.toString());
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int counter = 1;
            for (DescriptionType type : list) {
                Issues issue = (Issues) type;
                if (issue != null) {
                    stringBuilder.append(TAB).append(counter).append(DOT).append(SPACE).append(issue.getTitle()).append(NEW_LINE);
                    if (counter == THRESHOLD)
                        break;
                    counter++;
                }
            }

            mRepositoryDetailView.showIssues(stringBuilder.toString());
        }
    }

    @Override
    public void onFailure(int requestType, String errorMessage) {
        mRepositoryDetailView.dismissDialog();
        mRepositoryDetailView.showMessage(errorMessage);
    }
}
