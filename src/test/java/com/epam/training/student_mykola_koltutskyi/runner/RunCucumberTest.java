package com.epam.training.student_mykola_koltutskyi.runner;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import com.epam.training.student_mykola_koltutskyi.utils.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = {
                "src/test/resources/features/Empty_Password_Error.feature",
                "src/test/resources/features/Empty_Username_Error.feature",
                "src/test/resources/features/Successful_Login.feature"
        },
        glue = "com/epam/training/student_mykola_koltutskyi/steps",
        plugin = { "html:target/cucumber-Report.html", "json:target/report.json"},
        tags = "@Smoke")
@Listeners(TestListener.class)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void openBrowser() {
        DriverProvider.getDriver().get("https://saucedemo.com");
    }

    @AfterMethod
    public void closeBrowser() {
        DriverProvider.quit();
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}