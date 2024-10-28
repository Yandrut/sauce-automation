package com.epam.training.student_mykola_koltutskyi.steps;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import com.epam.training.student_mykola_koltutskyi.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class LoginPageStepDefinitions {
    private static final String BASE_URL = "https://saucedemo.com";
    private final LoginPage page = new LoginPage(DriverProvider.getDriver());

    @Given("I enter login credentials with username {string} and password {string}")
    public void iEnterLoginCredentialsWithUsernameAndPassword(String username, String password) {
        page.navigateToUrl(BASE_URL)
                .typeCredentials(username, password);
    }

    @When("I clear the username input")
    public void iClearTheUsernameInput() {
        page.clearUsernameInput();
    }

    @When("I clear the password input")
    public void iClearThePasswordInput() {
        page.clearPasswordInput();
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        page.clickOnLoginButton();
    }

    @Then("Verify that the error message appears {}")
    public void verifyThatTheErrorMessageAppears(String expectedErrorMessage) {
        String actualErrorMessage = page.getErrorMessage();
        assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage);
    }

    @Then("Verify that page name is valid {}")
    public void verifyThatPageNameIsValid(String expectedPageName) {
        String actualPageName = page.getTitle();
        assertThat(actualPageName).isEqualTo(expectedPageName);
    }
}