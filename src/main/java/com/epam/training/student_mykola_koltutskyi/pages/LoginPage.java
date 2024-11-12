package com.epam.training.student_mykola_koltutskyi.pages;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
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

    private final WebDriver driver;
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage() {
        super();
        driver = DriverProvider.getDriver();
    }

    public void typeCredentials(String username, String password) {
        log.info("Typing credentials: | {} | {} |", username, password);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clearPasswordInput() {
        clearInputWithActions(passwordField, "Password");
    }

    public void clearUsernameInput() {
        clearInputWithActions(usernameField, "Username");
    }

    private void clearInputWithActions(WebElement target, String inputName) {
        var actions = new Actions(driver);
        actions.doubleClick(target)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();
        log.info("{} input cleared", inputName);
    }

    public void clickOnLoginButton() {
        loginButton.click();
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