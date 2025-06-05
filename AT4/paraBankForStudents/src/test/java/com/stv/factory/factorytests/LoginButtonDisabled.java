package com.stv.factorytests;

import com.stv.factorypages.LoginPage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginButtonDisabled extends BaseTest {

    private LoginPage loginPage;

    @Before
    public void setUpTest() {
        loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
    }

    @Test
    public void verifyLoginButtonDisabledWhenEmpty() {
        assertFalse("Login button should be disabled with empty fields",
                loginPage.isLoginButtonEnabled());
    }

    @Test
    public void verifyLoginButtonDisabledWithEmailOnly() {
        loginPage.enterEmailOnly("test@example.com");
        assertFalse("Login button should be disabled with password missing",
                loginPage.isLoginButtonEnabled());
    }

    @Test
    public void verifyLoginButtonDisabledWithPasswordOnly() {
        loginPage.enterPasswordOnly("password123");
        assertFalse("Login button should be disabled with email missing",
                loginPage.isLoginButtonEnabled());
    }

    @Test
    public void verifyLoginButtonEnabledWithValidCredentials() {
        loginPage.enterCredentials("valid@user.com", "validPassword");
        assertTrue("Login button should be enabled with both fields filled",
                loginPage.isLoginButtonEnabled());
    }

    @Test
    public void verifyLoginButtonDisabledWithInvalidEmailFormat() {
        loginPage.enterCredentials("invalid-format", "password123");
        assertFalse("Login button should be disabled with invalid email format",
                loginPage.isLoginButtonEnabled());
    }
}