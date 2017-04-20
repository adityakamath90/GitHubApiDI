/*
 * Created by Aditya on 10/4/17 7:04 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 7:03 PM
 */

package com.githubapi.repositoryList.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.githubapi.GithubApplication;
import com.githubapi.R;
import com.githubapi.di.application.ApplicationComponent;
import com.githubapi.repositoryDetail.view.RepositoryDetailActivity;
import com.githubapi.repositoryLanguage.model.Item;
import com.githubapi.repositoryList.di.DaggerRepositoryListComponent;
import com.githubapi.repositoryList.di.RepositoryListComponent;
import com.githubapi.repositoryList.di.RepositoryListModule;
import com.githubapi.repositoryList.model.RepositoryDataHandler;
import com.githubapi.repositoryList.presenter.RepositoryListPresenter;
import com.githubapi.utils.RestClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RepositoryList extends AppCompatActivity implements RepositoryListActivityView {


    public static final String REPO_LANGUAGE = "language";
    private int mPageCount = 1;
    private ProgressDialog mProgressDialog;
    private RepositoryListAdapter mRepositoryListAdapter;
    @Inject
    RepositoryListPresenter mListPresenter;
    @Inject
    RepositoryDataHandler mDataHandler;
    @Inject
    RestClient mRestClient;
    private String mLanguage;
    @Inject
    ApplicationComponent mApplicationComponent;
    boolean userScrolled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_list);
        RepositoryListComponent repositoryComponent = DaggerRepositoryListComponent.builder()
                .applicationComponent(((GithubApplication) getApplication())
                        .getApplicationComponent()).repositoryListModule(new RepositoryListModule
                        (this, new RepositoryDataHandler(mListPresenter, ((GithubApplication)
                                getApplication()).getApplicationComponent().getRestClient())))
                .build();
        repositoryComponent.inject(this);
        mLanguage = getIntent().getStringExtra(REPO_LANGUAGE);
        ListView listView = (ListView) findViewById(R.id.repoListView);
        listView.setAdapter(mRepositoryListAdapter = new RepositoryListAdapter(new ArrayList<Item>(), LayoutInflater.from(this)));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = (Item) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(RepositoryList.this, RepositoryDetailActivity.class);
                intent.putExtra(RepositoryDetailActivity.REPO_DETAIL, item);
                startActivity(intent);
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView arg0, int scrollState) {
                // If scroll state is touch scroll then set userScrolled
                // true
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    userScrolled = true;

                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                // Now check if userScrolled is true and also check if
                // the item is end then update list view and set
                // userScrolled to false
                if (userScrolled && firstVisibleItem + visibleItemCount == totalItemCount) {
                    userScrolled = false;
                    mListPresenter.fetchRepos(mLanguage, String.valueOf(++mPageCount));
                }
            }
        });

        mListPresenter.fetchRepos(mLanguage, String.valueOf(mPageCount));

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
    public void showMessage(String errorMesssage) {
        Toast.makeText(this, errorMesssage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void notifyDataSetChanged(List<Item> listItem) {
        mRepositoryListAdapter.addToRepo(listItem);
    }
}
