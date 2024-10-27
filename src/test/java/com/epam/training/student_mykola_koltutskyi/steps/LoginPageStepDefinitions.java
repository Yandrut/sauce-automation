package com.epam.training.student_mykola_koltutskyi.steps;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import com.epam.training.student_mykola_koltutskyi.pages.LoginPage;
import com.epam.training.student_mykola_koltutskyi.runner.RunCucumberTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginPageStepDefinitions {
    private static final String BASE_URL = "https://saucedemo.com";
    private final LoginPage page = new LoginPage(DriverProvider.getDriver());
    private static final Logger logger = LoggerFactory.getLogger(LoginPageStepDefinitions.class);

    @Given("I type the login credentials {} {}")
    public void iTypeTheLoginCredentials(String username, String password) {
        logger.info("Typing login credentials: {} | {}", username, password);
        page.navigateToUrl(BASE_URL)
                .typeCredentials(username, password);
    }

    @When("I clear the username input")
    public void iClearTheUsernameInput() {
        page.clearUsernameInput();
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        page.clickOnLoginButton();
    }

    @Then("Verify that the error message appears {}")
    public void verifyThatTheErrorMessageAppears(String expectedErrorMessage) {
        String actualErrorMessage = page.getErrorMessage();
        logger.trace("Actual error message: {} ", actualErrorMessage);
        assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage);
    }

    @When("I clear the password input")
    public void iClearThePasswordInput() {
        page.clearPasswordInput();
    }


    @Then("Verify the error message appears {}")
    public void verifyTheErrorMessageAppears(String emptyPasswordMessage) {
        String actualErrorMessage = page.getErrorMessage();
        assertThat(actualErrorMessage).isEqualTo(emptyPasswordMessage);
    }


    @Given("I type valid login credentials as {} {}")
    public void iTypeValidLoginCredentialsAs(String username, String password) {
        logger.info("Typing valid credentials: {} | {}", username, password);
        page.navigateToUrl(BASE_URL)
                .typeCredentials(username, password);
    }

    @Then("Verify that page name is valid {}")
    public void verifyThatPageNameIsValid(String expectedPageName) {
        String actualPageName = page.getTitle();
        logger.info("Actual page name is: {}", actualPageName);
        assertThat(actualPageName).isEqualTo(expectedPageName);
    }
}
