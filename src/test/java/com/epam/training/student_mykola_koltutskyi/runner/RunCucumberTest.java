package com.epam.training.student_mykola_koltutskyi.runner;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import com.epam.training.student_mykola_koltutskyi.utils.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/epam/training/student_mykola_koltutskyi/steps",
        plugin = { "html:target/cucumber-Report.html", "json:target/report.json"},
        tags = "@Smoke")
@Listeners(TestListener.class)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    private static final Logger logger = LoggerFactory.getLogger(RunCucumberTest.class);

    @BeforeMethod
    public void initializeDriver() {
        logger.debug("Initializing driver \n");
        DriverProvider.initializeDriver();
        DriverProvider.getDriver();
    }

    @AfterMethod
    public void closeDriver() {
        logger.debug("Closing browser \n");
        DriverProvider.quit();
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}