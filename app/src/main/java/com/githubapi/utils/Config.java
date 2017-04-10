/*
 * Created by Aditya on 10/4/17 7:00 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 6:15 PM
 */

package com.githubapi.utils;

/**
 * Created by Aditya on 09/04/17.
 */
public class Config {

    public static final String BASE_URL = "https://api.github.com/";

    public static final String API_SEARCH_REPOSITORIES = "search/repositories";

    //Query param for Search repo api
    public static final String QUERY = "q";
    public static final String QUERY_PARAM_LANGUAGE = "language:";
    public static final String PAGE = "page";

    //Query param for  issues repo api
    public static final String ISSUES = "repos/%s/issues";
    public static final String CONTRIBUTORS = "repos/%s/contributors";


}
