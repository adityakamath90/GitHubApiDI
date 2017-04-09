/*
 * Created by Aditya on 9/4/17 7:00 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 9/4/17 7:00 PM
 */

package com.githubapi.language.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.githubapi.R;

/**
 * LanguageActivity contains an edit text and a button
 * Edit text value cannot be empty and a Toast is displayed.
 * Clicking on Button text validates the github content i.e programming language
 * to be displayed as a list.
 */
public class LanguageActivity extends AppCompatActivity implements LanguageView{

    private EditText mEditTextLanguage;
    private Button mButtonSearchGitHub;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanuage);
        mEditTextLanguage = (EditText) findViewById(R.id.editTextLanguage);
        mButtonSearchGitHub = (Button) findViewById(R.id.buttonSearch);

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
    public void moveToLanguageDetailScreen() {

    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
