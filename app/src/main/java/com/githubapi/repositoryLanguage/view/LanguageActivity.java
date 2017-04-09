/*
 * Created by Aditya on 9/4/17 9:22 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 9:22 PM
 */

package com.githubapi.repositoryLanguage.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.githubapi.R;
import com.githubapi.repositoryLanguage.model.Repository;
import com.githubapi.repositoryLanguage.presenter.LanguagePresenter;

import java.util.List;

/**
 * LanguageActivity contains an edit text and a button
 * Edit text value cannot be empty and a Toast is displayed.
 * Clicking on Button text validates the github content i.e programming language
 * to be displayed as a list.
 */
public class LanguageActivity extends AppCompatActivity implements LanguageView{

    private ProgressDialog mProgressDialog;
    private LanguagePresenter mLanguagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanuage);
        final EditText editTextLanguage = (EditText) findViewById(R.id.editTextLanguage);
        Button buttonSearchGitHub = (Button) findViewById(R.id.buttonSearch);
        buttonSearchGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String language = editTextLanguage.getText().toString().trim();
                if (mLanguagePresenter.isLanguageStringValid(language)) {
                    mLanguagePresenter.fetchRepos(language);
                }
            }
        });
        mLanguagePresenter = new LanguagePresenter(this);

    }


    @Override
    public void showDialog() {
        mProgressDialog = ProgressDialog.show(this,getString(R.string.app_name), getString(R.string.pleaseWait));
        mProgressDialog.show();
    }

    @Override
    public void dismissDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    public void moveToLanguageDetailScreen(List<Repository> repositoryList) {
        Intent languageDetailIntent = new Intent(this, LanguageActivity.class);
        startActivity(languageDetailIntent);
        finish();
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
