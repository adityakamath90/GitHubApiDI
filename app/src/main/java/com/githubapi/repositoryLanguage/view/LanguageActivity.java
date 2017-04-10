/*
 * Created by Aditya on 10/4/17 5:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 5:01 PM
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
import com.githubapi.repositoryLanguage.presenter.LanguagePresenter;
import com.githubapi.repositoryList.view.RepositoryList;

/**
 * LanguageActivity contains an edit text and a button
 * Edit text value cannot be empty and a Toast is displayed.
 * Clicking on Button text validates the github content i.e programming language
 * to be displayed as a list.
 */
public class LanguageActivity extends AppCompatActivity implements LanguageView{

    private LanguagePresenter mLanguagePresenter;
    private String mLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanuage);
        final EditText editTextLanguage = (EditText) findViewById(R.id.editTextLanguage);
        Button buttonSearchGitHub = (Button) findViewById(R.id.buttonSearch);
        buttonSearchGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLanguage = editTextLanguage.getText().toString().trim();
                mLanguagePresenter.isLanguageStringValid(mLanguage);
            }
        });
        mLanguagePresenter = new LanguagePresenter(this);

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
