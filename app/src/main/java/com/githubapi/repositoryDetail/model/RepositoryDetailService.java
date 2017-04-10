/*
 * Created by Aditya on 10/4/17 6:58 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 6:58 PM
 */

package com.githubapi.repositoryDetail.model;

import com.githubapi.repositoryDetail.model.dto.Contributor;
import com.githubapi.repositoryDetail.model.dto.Issues;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Aditya on 10/04/17.
 */

public interface RepositoryDetailService {

    @GET
    Call<List<Contributor>> getContributors(@Url String url);

    @GET
    Call<List<Issues>> getIssues(@Url String url);
}
