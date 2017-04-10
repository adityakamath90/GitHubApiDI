/*
 * Created by Aditya on 10/4/17 6:58 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 6:58 PM
 */

package com.githubapi.repositoryDetail.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Issue {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("actor")
    @Expose
    private Actor actor;
    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("commit_id")
    @Expose
    private Object commitId;
    @SerializedName("commit_url")
    @Expose
    private Object commitUrl;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("issue")
    @Expose
    private Issues issue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Object getCommitId() {
        return commitId;
    }

    public void setCommitId(Object commitId) {
        this.commitId = commitId;
    }

    public Object getCommitUrl() {
        return commitUrl;
    }

    public void setCommitUrl(Object commitUrl) {
        this.commitUrl = commitUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Issues getIssue() {
        return issue;
    }

    public void setIssue(Issues issue) {
        this.issue = issue;
    }

}