/*
 * Created by Aditya on 11/4/17 2:18 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 2:16 AM
 */

package com.githubapi.repositoryLanguage;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.githubapi.R;
import com.githubapi.repositoryLanguage.view.RepositoryLanguageActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class RepositoryRepositoryLanguageActivityTest {

    private static final String JAVA = "java";
    @Rule
    public ActivityTestRule<RepositoryLanguageActivity> mActivityTestRule =
            new ActivityTestRule<>(RepositoryLanguageActivity.class);

    @Test
    public void testClickOnSearchGithubEmpty() {
        onView(ViewMatchers.withId(R.id.buttonSearch)).perform(click());
    }

    @Test
    public void testClickOnSearchGithubWithContent() {
        onView(withId(R.id.editTextLanguage)).perform(typeText(JAVA));
        onView(withId(R.id.buttonSearch)).perform(click());
    }

}
