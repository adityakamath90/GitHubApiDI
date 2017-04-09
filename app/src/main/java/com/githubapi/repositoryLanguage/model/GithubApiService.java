/*
 * Created by Aditya on 9/4/17 10:37 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 9:40 PM
 */

package com.githubapi.repositoryLanguage.model;

import com.githubapi.utils.Config;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aditya on 09/04/17.
 */

public interface GithubApiService {

    @GET(Config.API_SEARCH_REPOSITORIES)
    Call<List<Repository>> getRepos(@Query(Config.QUERY_PARAM_LANGUAGE) String language);
}
