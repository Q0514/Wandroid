package com.practice.androidapp.beans;

import java.util.List;

public class Navigation {
    private List<Home> articles;
    private String name;
    private int cid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Home> getArticles() {
        return articles;
    }

    public void setArticles(List<Home> articles) {
        this.articles = articles;
    }
}

