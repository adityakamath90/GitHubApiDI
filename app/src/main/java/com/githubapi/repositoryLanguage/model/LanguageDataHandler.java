/*
 * Created by Aditya on 9/4/17 10:37 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 9:30 PM
 */

package com.githubapi.repositoryLanguage.model;


import com.githubapi.repositoryLanguage.presenter.RepositoryListener;
import com.githubapi.utils.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LanguageDataHandler {

    RepositoryListener mRepositoryListener;

    public LanguageDataHandler(RepositoryListener repositoryListener) {
        mRepositoryListener = repositoryListener;
    }


    public void fetchRepos(String language) {
        GithubApiService githubApiService = RestClient.getInstance().getService(GithubApiService.class);
        githubApiService.getRepos(language).enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                mRepositoryListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                mRepositoryListener.onFailure(t.getMessage());
            }
        });

    }
}
