/*
 * Created by Aditya on 10/4/17 7:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 7:01 PM
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

    public static final String NEW_LINE = "\n";
    private RepositoryDetailView mRepositoryDetailView;
    private RepositoryDetailDataHandler mRepositoryDetailDataHandler;

    public RepositoryDetailPresenter(RepositoryDetailView detailView) {
        mRepositoryDetailView = detailView;
        mRepositoryDetailDataHandler = new RepositoryDetailDataHandler<>(this);
    }

    public void getRepositoryIssues(String repoName) {
        mRepositoryDetailView.showDialog();
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
            int counter = 0;
            for (DescriptionType type : list) {
                Contributor contributor = (Contributor) type;
                stringBuilder.append(contributor.getLogin()).append(NEW_LINE);
                if (counter == 2)
                    break;
                counter++;
            }
            mRepositoryDetailView.showContributors(stringBuilder.toString());
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int counter = 0;
            for (DescriptionType type : list) {
                Issues issue = (Issues) type;
                if (issue != null) {
                    stringBuilder.append(issue.getTitle()).append(NEW_LINE);
                    if (counter == 2)
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
