package com.epam.training.student_mykola_koltutskyi.drivers;

import com.epam.training.student_mykola_koltutskyi.exception.DriverNotSupportedException;
import org.openqa.selenium.WebDriver;
import com.epam.training.student_mykola_koltutskyi.drivers.manager.ChromeManager;
import com.epam.training.student_mykola_koltutskyi.drivers.manager.FirefoxManager;

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
            throw new DriverNotSupportedException("Provided driver is not supported");
        }
        driver.manage().window().maximize();
        return driver;
    }
}