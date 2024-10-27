package com.epam.training.student_mykola_koltutskyi;


import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import com.epam.training.student_mykola_koltutskyi.models.User;
import com.epam.training.student_mykola_koltutskyi.pages.LoginPage;
import com.epam.training.student_mykola_koltutskyi.service.UserCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SauceDemoTest extends BaseTest {
    public static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    public static final String EMPTY_PASSWORD_MESSAGE = "Epic sadface: Password is required";
    public static final String EMPTY_USERNAME_MESSAGE = "Epic sadface: Username is required";
    public static final String EXPECTED_PAGE_NAME = "Swag Labs";

    @DisplayName("UC-1")
    @Test
    void isEmptyUsernameErrorPresent() {
        LoginPage page = new LoginPage(DriverProvider.getDriver());
        User user = UserCreator.createUserWithAnyCredentials();

        String actualErrorMessage = page.navigateToUrl(LOGIN_PAGE_URL)
                .typeCredentials(user)
                .clearUsernameInput()
                .clearPasswordInput()
                .clickOnLoginButton()
                .getErrorMessage();

        assertThat(actualErrorMessage).isEqualTo(EMPTY_USERNAME_MESSAGE);
    }

    @DisplayName("UC-2")
    @Test
    void isEmptyPasswordErrorPresent() {
        LoginPage page = new LoginPage(DriverProvider.getDriver());
        User user = UserCreator.createUserWithAnyCredentials();

        String actualErrorMessage = page.navigateToUrl(LOGIN_PAGE_URL)
                .typeCredentials(user)
                .clearPasswordInput()
                .clickOnLoginButton()
                .getErrorMessage();

        assertThat(actualErrorMessage).isEqualTo(EMPTY_PASSWORD_MESSAGE);
    }

    @DisplayName("UC-3")
    @Test
    void redirectsToTheSwagLabsPage() {
        LoginPage page = new LoginPage(DriverProvider.getDriver());
        User user = UserCreator.createUserWithValidCredentials();

        String actualPageName = page.navigateToUrl(LOGIN_PAGE_URL)
                .typeCredentials(user)
                .clickOnLoginButton()
                .getTitle();

        assertThat(actualPageName).isEqualTo(EXPECTED_PAGE_NAME);
    }
}