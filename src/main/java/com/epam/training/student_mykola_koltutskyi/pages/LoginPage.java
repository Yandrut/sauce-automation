package com.epam.training.student_mykola_koltutskyi.pages;

import com.epam.training.student_mykola_koltutskyi.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public LoginPage navigateToUrl(String url) {
        log.info("Navigating to the url: {} ", url);
        driver.get(url);
        return this;
    }

    public LoginPage typeCredentials(User user) {
        Actions actions = new Actions(driver);
        actions.sendKeys(usernameField, user.getUsername())
                .sendKeys(passwordField, user.getPassword())
                .build().perform();
        log.info("Typing the user credentials");
        return this;
    }

    public LoginPage clearPasswordInput() {
        Actions actions = new Actions(driver);
        actions.doubleClick(passwordField)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();

        return this;
    }

    public LoginPage clearUsernameInput() {
        Actions actions = new Actions(driver);
        actions.doubleClick(usernameField)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();
        return this;
    }

    public LoginPage clickOnLoginButton() {
        loginButton.submit();
        log.info("Clicking on login button");
        return this;
    }

    public String getErrorMessage() {
        log.info("Extracting error message");
        return errorMessage.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}