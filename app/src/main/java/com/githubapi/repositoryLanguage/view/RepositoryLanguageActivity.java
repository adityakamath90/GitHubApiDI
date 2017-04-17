/*
 * Created by Aditya on 11/4/17 2:17 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 2:16 AM
 */

package com.githubapi.repositoryLanguage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.githubapi.R;
//import com.githubapi.repositoryLanguage.di.DaggerRepositoryLanguageComponent;
//import com.githubapi.repositoryLanguage.di.RepositoryActivityModule;
import com.githubapi.repositoryLanguage.di.DaggerRepositoryLanguageComponent;
import com.githubapi.repositoryLanguage.di.RepositoryActivityModule;
import com.githubapi.repositoryLanguage.di.RepositoryLanguageComponent;
import com.githubapi.repositoryLanguage.presenter.RepositoryPresenter;
import com.githubapi.repositoryList.view.RepositoryList;

import javax.inject.Inject;

/**
 * RepositoryLanguageActivity contains an edit text and a button
 * Edit text value cannot be empty and a Toast is displayed.
 * Clicking on Button text validates the github content i.e programming language
 * to be displayed as a list.
 */
public class RepositoryLanguageActivity extends AppCompatActivity implements LanguageView {

    @Inject
    RepositoryPresenter mRepositoryPresenter;
    private String mLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanuage);
        RepositoryLanguageComponent languageComponent =DaggerRepositoryLanguageComponent
            .builder().repositoryActivityModule(new RepositoryActivityModule(this)).build();
        languageComponent.inject(this);

        final EditText editTextLanguage = (EditText) findViewById(R.id.editTextLanguage);
        Button buttonSearchGitHub = (Button) findViewById(R.id.buttonSearch);
        buttonSearchGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLanguage = editTextLanguage.getText().toString().trim();
                mRepositoryPresenter.isLanguageStringValid(mLanguage);
            }
        });
    }


    @Override
    public void moveToLanguageDetailScreen() {
        Intent languageDetailIntent = new Intent(this, RepositoryList.class);
        languageDetailIntent.putExtra(RepositoryList.REPO_LANGUAGE, mLanguage);
        startActivity(languageDetailIntent);
    }

    @Override
    public void displayMessage() {
        Toast.makeText(this, getString(R.string.enterLanguage), Toast.LENGTH_LONG).show();
    }
}
