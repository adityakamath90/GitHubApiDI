/*
 * Created by Aditya on 11/4/17 2:18 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 1:47 AM
 */

package com.githubapi.repositoryDetail.model;

import com.githubapi.repositoryDetail.model.dto.Contributor;
import com.githubapi.repositoryDetail.model.dto.Issues;
import com.githubapi.repositoryDetail.presenter.RepositoryDetailListener;
import com.githubapi.utils.Config;
import com.githubapi.utils.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Aditya on 10/04/17.
 */

public class RepositoryDetailDataHandler<DescriptionType> {

    private RepositoryDetailListener<DescriptionType> mRepositoryDetailListener;
    public static final int API_ISSUES = 1;
    public static final int API_CONTRIBUTORS = 2;

    public RepositoryDetailDataHandler(RepositoryDetailListener repositoryDetailListener) {
        mRepositoryDetailListener = repositoryDetailListener;
    }

    public void getListOfIssues(String repoName) {
        RepositoryDetailService repositoryDetailService = RestClient.getInstance().getService(RepositoryDetailService.class);
        repositoryDetailService.getIssues(String.format(Config.ISSUES, repoName)).enqueue(new Callback<List<Issues>>() {
            @Override
            public void onResponse(Call<List<Issues>> call, Response<List<Issues>> response) {
                mRepositoryDetailListener.onSuccess(API_ISSUES, (List<DescriptionType>) response.body());
            }

            @Override
            public void onFailure(Call<List<Issues>> call, Throwable t) {
                mRepositoryDetailListener.onFailure(API_ISSUES, t.getMessage());
            }
        });
    }

    public void getListOfContributors(final String repoName) {
        RepositoryDetailService repositoryDetailService = RestClient.getInstance().getService(RepositoryDetailService.class);
        repositoryDetailService.getContributors(String.format(Config.CONTRIBUTORS, repoName)).enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                mRepositoryDetailListener.onSuccess(API_CONTRIBUTORS, (List<DescriptionType>) response.body());
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                mRepositoryDetailListener.onFailure(API_CONTRIBUTORS, t.getMessage());
            }
        });

    }

}
