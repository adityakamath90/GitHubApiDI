/*
 * Created by Aditya on 10/4/17 7:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 7:01 PM
 */

package com.githubapi.repositoryDetail.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.githubapi.R;
import com.githubapi.repositoryDetail.presenter.RepositoryDetailPresenter;
import com.githubapi.repositoryLanguage.model.Item;

public class RepositoryDetailActivity extends AppCompatActivity implements RepositoryDetailView {

    public static final String REPO_DETAIL = "repoDetail";
    private ProgressDialog mProgressDialog;
    private TextView mTextViewContributors;
    private TextView mTextViewIssues;
    private RepositoryDetailPresenter mRepositoryDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_detail);
        mTextViewContributors = (TextView) findViewById(R.id.textViewIssueList);
        mTextViewIssues = (TextView) findViewById(R.id.textViewContributorList);
        mRepositoryDetailPresenter = new RepositoryDetailPresenter(this);
        Item item = getIntent().getParcelableExtra(REPO_DETAIL);
        mRepositoryDetailPresenter.getRepositoryContributors(item.getFullName());
        mRepositoryDetailPresenter.getRepositoryIssues(item.getFullName());
    }

    @Override
    public void showDialog() {
        mProgressDialog = ProgressDialog.show(this, getString(R.string.app_name), getString(R.string.pleaseWait));
        mProgressDialog.show();
    }

    @Override
    public void dismissDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showIssues(String issues) {
        mTextViewIssues.setText("Issue list \n" + issues);

    }

    @Override
    public void showContributors(String contributors) {

        mTextViewContributors.setText("ContributorList\n" + contributors);

    }


}
