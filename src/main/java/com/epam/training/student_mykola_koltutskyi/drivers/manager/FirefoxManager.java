package com.epam.training.student_mykola_koltutskyi.drivers.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class FirefoxManager {

    private FirefoxManager() {}

    public static WebDriver getDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        return new FirefoxDriver();
    }
}