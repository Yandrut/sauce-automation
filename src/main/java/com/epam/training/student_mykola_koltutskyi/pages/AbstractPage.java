package com.epam.training.student_mykola_koltutskyi.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract AbstractPage navigateToUrl(String url);

    public abstract String getTitle();
}