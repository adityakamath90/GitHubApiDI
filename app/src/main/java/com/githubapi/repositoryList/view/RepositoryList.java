/*
 * Created by Aditya on 9/4/17 11:29 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 11:29 PM
 */

package com.githubapi.repositoryList.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.githubapi.R;
import com.githubapi.repositoryLanguage.model.Item;

import java.util.List;

public class RepositoryList extends AppCompatActivity {


    public static final String REPO_LIST = "repoList";
    private List<Item> mItemList;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_list);
        mItemList = getIntent().getParcelableArrayListExtra(REPO_LIST);
        mListView = (ListView) findViewById(R.id.repoListView);
        mListView.setAdapter(new RepositoryListAdapter(mItemList, LayoutInflater.from(this)));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = (Item) adapterView.getItemAtPosition(i);
            }
        });

    }
}
