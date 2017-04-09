/*
 * Created by Aditya on 9/4/17 11:42 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 11:42 PM
 */

package com.githubapi.repositoryLanguage.model;

import com.githubapi.utils.Config;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aditya on 09/04/17.
 */

public interface GithubApiService {

    @GET(Config.API_SEARCH_REPOSITORIES)
    Call<Repository> getRepos(@Query(Config.QUERY_PARAM_LANGUAGE) String language);
}
