package com.epam.training.student_mykola_koltutskyi.pages;

public abstract class AbstractPage {

    public abstract AbstractPage navigateToUrl(String url);

    public abstract String getTitle();
}