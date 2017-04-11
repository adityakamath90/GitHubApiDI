/*
 * Created by Aditya on 11/4/17 2:19 AM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 11/4/17 2:19 AM
 */

package com.githubapi.repositoryLanguage;

import android.app.Instrumentation;
import android.os.IBinder;
import android.support.test.espresso.Root;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.WindowManager;
import android.widget.Toast;

import com.githubapi.R;
import com.githubapi.repositoryLanguage.view.RepositoryLanguageActivity;
import com.githubapi.repositoryList.view.RepositoryList;

import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class RepositoryLanguageActivityTest {

    private static final String JAVA = "java";
    @Rule
    public ActivityTestRule<RepositoryLanguageActivity> mActivityTestRule =
            new ActivityTestRule<>(RepositoryLanguageActivity.class);

    @Test
    public void testClickOnSearchGithubEmpty() {
        onView(ViewMatchers.withId(R.id.buttonSearch)).perform(click());
        onView(withText(mActivityTestRule.getActivity().getString(R.string.enterLanguage)))
                .inRoot(withDecorView(not(mActivityTestRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

    }

    @Test
    public void testClickOnSearchGithubWithContent() {
        Intents.init();
        onView(withId(R.id.editTextLanguage)).perform(typeText(JAVA));
        onView(withId(R.id.buttonSearch)).perform(click());
        intended(hasComponent(RepositoryList.class.getName()));
        Intents.release();
    }
}
