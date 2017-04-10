/*
 * Created by Aditya on 10/4/17 5:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 5:01 PM
 */

package com.githubapi.repositoryList.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.githubapi.R;
import com.githubapi.repositoryLanguage.model.Item;
import com.githubapi.repositoryList.presenter.RepositoryListPresenter;

import java.util.ArrayList;
import java.util.List;

public class RepositoryList extends AppCompatActivity implements RepositoryListActivityView {


    public static final String REPO_LANGUAGE = "language";
    private ListView mListView;
    private int mPageCount = 1;
    private ProgressDialog mProgressDialog;
    private RepositoryListAdapter mRepositoryListAdapter;
    private RepositoryListPresenter mListPresenter;
    private String mLanguage;
    boolean userScrolled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_list);
        mListPresenter = new RepositoryListPresenter(this);
        mLanguage = getIntent().getStringExtra(REPO_LANGUAGE);
        mListView = (ListView) findViewById(R.id.repoListView);
        mListView.setAdapter(mRepositoryListAdapter = new RepositoryListAdapter(new ArrayList<Item>(), LayoutInflater.from(this)));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = (Item) adapterView.getItemAtPosition(i);
            }
        });

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {

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
