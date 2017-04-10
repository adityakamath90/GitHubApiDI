/*
 * Created by Aditya on 10/4/17 7:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 6:15 PM
 */

package com.githubapi.repositoryDetail.presenter;

import java.util.List;

/**
 * Created by Aditya on 10/04/17.
 */

public interface RepositoryDetailListener<DescriptionType> {
    void onSuccess(int requestType, List<DescriptionType> list);

    void onFailure(int requestType, String errorMessage);
}
