/*
 * Created by Aditya on 10/4/17 3:58 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 3:58 PM
 */

package com.githubapi.repositoryLanguage.model;


import com.githubapi.repositoryLanguage.presenter.RepositoryListener;
import com.githubapi.utils.Config;
import com.githubapi.utils.RestClient;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> map = new HashMap<>();
        map.put(Config.QUERY, Config.QUERY_PARAM_LANGUAGE + language);
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
