/*
 * Created by Aditya on 11/4/17 1:27 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 12:54 AM
 */

package com.githubapi.repositoryList.model;


import com.githubapi.repositoryLanguage.model.GithubApiService;
import com.githubapi.repositoryLanguage.model.Repository;
import com.githubapi.repositoryList.presenter.RepositoryListener;
import com.githubapi.utils.Config;
import com.githubapi.utils.RestClient;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryDataHandler {

    private RepositoryListener mRepositoryListener;
    private RestClient mRestClient;

    @Inject
    public RepositoryDataHandler(RepositoryListener repositoryListener, RestClient restClient) {
        mRepositoryListener = repositoryListener;
        mRestClient = restClient;
    }


    public void fetchRepos(String language, String pageNo) {
        GithubApiService githubApiService = mRestClient.getService(GithubApiService.class);
        Map<String, String> map = new HashMap<>();
        map.put(Config.QUERY, Config.QUERY_PARAM_LANGUAGE + language);
        map.put(Config.PAGE, pageNo);
        githubApiService.getRepos(map).enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {
                mRepositoryListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {
                mRepositoryListener.onFailure(t.getMessage());
            }
        });

    }
}
