package com.epam.training.student_mykola_koltutskyi.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
        log.info("Screenshot taken... \n Test name {} ", result.getTestName());
    }

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
}