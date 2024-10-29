package com.epam.training.student_mykola_koltutskyi.drivers;

import org.openqa.selenium.WebDriver;
import com.epam.training.student_mykola_koltutskyi.drivers.manager.ChromeManager;
import com.epam.training.student_mykola_koltutskyi.drivers.manager.FirefoxManager;
import java.time.Duration;

public final class DriverFactory {

    private DriverFactory() {}

    public static WebDriver createDriver() {
        var browserType = System.getProperty("browser", "chrome");
        WebDriver driver;
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = ChromeManager.getChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = FirefoxManager.getFirefoxDriver();
        } else {
            throw new RuntimeException("Invalid name of the browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        return driver;
    }
}