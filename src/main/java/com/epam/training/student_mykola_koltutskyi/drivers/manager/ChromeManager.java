package com.epam.training.student_mykola_koltutskyi.drivers.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.epam.training.student_mykola_koltutskyi.service.DataReader;

public final class ChromeManager {

    private ChromeManager(){}

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        return new ChromeDriver(options);
    }
}