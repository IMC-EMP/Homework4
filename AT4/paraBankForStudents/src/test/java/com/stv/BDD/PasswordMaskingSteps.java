package com.stv.BDD;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import com.stv.factorypages.LoginPage;
import com.stv.factorytests.BaseTest;

public class PasswordMaskingSteps extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    @Given("I have saved credentials in my browser")
    public void i_have_saved_credentials_in_my_browser() {
    }

    @When("I navigate to Wiggle.com/login")
    public void i_navigate_to_wiggle_com_login() {
        loginPage.navigateToLoginPage();
    }

    @When("the browser autofills my password")
    public void the_browser_autofills_my_password() {
        loginPage.simulateAutofill();
    }

    @Then("the password field should display masked characters \\(•••••)")
    public void the_password_field_should_display_masked_characters() {
        assertTrue("Password should be masked", loginPage.isPasswordMasked());
    }

    @Then("the visibility toggle should default to \"hidden\" state")
    public void the_visibility_toggle_should_default_to_hidden_state() {
        assertFalse("Password visibility toggle should be off",
                loginPage.isPasswordVisible());
    }

    @Given("I am on the Wiggle login page")
    public void i_am_on_the_wiggle_login_page() {
        loginPage.navigateToLoginPage();
    }

    @When("I enter {string} and {string}")
    public void i_enter_and(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see {string}")
    public void i_should_see(String errorMessage) {
        assertEquals("Error message should match",
                errorMessage,
                loginPage.getErrorMessage());
    }
}