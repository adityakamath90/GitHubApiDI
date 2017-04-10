/*
 * Created by Aditya on 11/4/17 1:27 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 8:00 PM
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_detail);
        mTextViewContributors = (TextView) findViewById(R.id.textViewIssueList);
        mTextViewIssues = (TextView) findViewById(R.id.textViewContributorList);
        RepositoryDetailPresenter repositoryDetailPresenter = new RepositoryDetailPresenter(this);
        Item item = getIntent().getParcelableExtra(REPO_DETAIL);
        repositoryDetailPresenter.getRepositoryContributors(item.getFullName());
        repositoryDetailPresenter.getRepositoryIssues(item.getFullName());
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
        mTextViewIssues.setText("Issue list \n \t" + issues);

    }

    @Override
    public void showContributors(String contributors) {

        mTextViewContributors.setText("Contributor List\n \t" + contributors);

    }


}
