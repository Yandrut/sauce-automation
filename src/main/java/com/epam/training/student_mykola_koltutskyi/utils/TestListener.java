package com.epam.training.student_mykola_koltutskyi.utils;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements BeforeTestExecutionCallback, TestExecutionExceptionHandler {

    public void saveScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) DriverProvider.getDriver();
        File screenCapture = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenCapture,
                    new File(".//target/screenshots/" + getCurrentTime() + ".png"));

        } catch (IOException e) {
          e.getLocalizedMessage();
        }
    }

    public String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-dd-MM_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        extensionContext.getDisplayName();
    }

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        saveScreenshot();
        extensionContext.getDisplayName();
        throw throwable;
    }
}