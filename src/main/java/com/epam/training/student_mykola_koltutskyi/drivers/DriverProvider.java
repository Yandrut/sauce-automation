package com.epam.training.student_mykola_koltutskyi.drivers;

import com.epam.training.student_mykola_koltutskyi.configuration.BrowserType;
import org.openqa.selenium.WebDriver;
import com.epam.training.student_mykola_koltutskyi.configuration.ConfigFactory;

import java.util.Objects;

public final class DriverProvider {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private DriverProvider() {}

    public static WebDriver getDriver() {
        if (Objects.isNull(threadLocalDriver.get())) {
            BrowserType browserType = ConfigFactory.getConfig().browser();
            threadLocalDriver.set(DriverFactory.getBrowsersDriver(browserType));
        }
        return threadLocalDriver.get();
    }

    public static void quit() {
        if (Objects.nonNull(getDriver())) {
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }
}