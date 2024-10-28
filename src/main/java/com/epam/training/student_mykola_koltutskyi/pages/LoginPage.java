package com.epam.training.student_mykola_koltutskyi.pages;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends AbstractPage {

    @FindBy(css = "#user-name")
    private WebElement usernameField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    @FindBy(css = "div.error-message-container.error > h3")
    private WebElement errorMessage;

    private static final Logger log = LogManager.getLogger(LoginPage.class);
    private final WebDriver driver = DriverProvider.getDriver();

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public void typeCredentials(String username, String password) {
        log.info("Typing credentials: | {} | {} |", username, password);
        Actions actions = new Actions(driver);
        actions.sendKeys(usernameField, username)
                .sendKeys(passwordField, password)
                .build().perform();
    }

    public void clearPasswordInput() {
        Actions actions = new Actions(driver);
        actions.doubleClick(passwordField)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();
        log.info("Password input cleared");
    }

    public void clearUsernameInput() {
        Actions actions = new Actions(driver);
        actions.doubleClick(usernameField)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();
        log.info("Username input cleared");
    }

    public void clickOnLoginButton() {
        loginButton.submit();
        log.info("Clicking on login button");
    }

    public String getErrorMessage() {
        log.info("Extracting error message");
        return errorMessage.getText();
    }

    public String getTitle() {
        var title = driver.getTitle();
        log.info("Actual page title is: {}", title);
        return title;
    }
}