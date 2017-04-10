/*
 * Created by Aditya on 10/4/17 3:57 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 3:57 PM
 */

package com.githubapi.repositoryLanguage.model;

import com.githubapi.utils.Config;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Aditya on 09/04/17.
 */

public interface GithubApiService {

    @GET(Config.API_SEARCH_REPOSITORIES)
    Call<Repository> getRepos(@QueryMap Map<String, String> language);
}
