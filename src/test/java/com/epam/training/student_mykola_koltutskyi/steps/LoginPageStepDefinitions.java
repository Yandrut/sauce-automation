package com.epam.training.student_mykola_koltutskyi.steps;

import com.epam.training.student_mykola_koltutskyi.pages.LoginPage;
import com.epam.training.student_mykola_koltutskyi.utils.TestListener;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Listeners;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Listeners(TestListener.class)
public class LoginPageStepDefinitions {
    private LoginPage page;

    @Before
    public void initializePageObject() {
        page = new LoginPage();
    }

    @Given("I enter login credentials with username {string} and password {string}")
    public void iEnterLoginCredentialsWithUsernameAndPassword(String username, String password) {
        page.typeCredentials(username, password);
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
        assertThat(actualErrorMessage)
                .as("Expected error message to appear")
                .isEqualTo(expectedErrorMessage);
    }

    @Then("Verify that page name is valid {}")
    public void verifyThatPageNameIsValid(String expectedPageName) {
        String actualPageName = page.getTitle();
        assertThat(actualPageName)
                .as("Expected page name to match")
                .isEqualTo(expectedPageName);
    }
}