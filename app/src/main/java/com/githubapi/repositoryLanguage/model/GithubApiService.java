/*
 * Created by Aditya on 9/4/17 9:22 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 9:12 PM
 */

package com.githubapi.repositoryLanguage.model;

import com.githubapi.utils.Config;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Aditya on 09/04/17.
 */

public interface GithubApiService {

    @GET(Config.API_SEARCH_REPOSITORIES)
    Call<List<Repository>> getRepos();
}
