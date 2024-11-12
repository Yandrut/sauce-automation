package com.epam.training.student_mykola_koltutskyi.drivers;

import org.openqa.selenium.WebDriver;
import java.util.Objects;

public final class DriverProvider {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private DriverProvider() {}

    public static WebDriver getDriver() {
        if (Objects.isNull(threadLocalDriver.get())) {
            threadLocalDriver.set(DriverFactory.createDriver());
        }
        return threadLocalDriver.get();
    }

    public static void quit() {
        if (Objects.nonNull(threadLocalDriver.get())) {
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }
}