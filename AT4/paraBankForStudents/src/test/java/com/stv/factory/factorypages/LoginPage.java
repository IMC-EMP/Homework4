package com.stv.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "loginEmail")
    private WebElement emailField;

    @FindBy(id = "loginPassword")
    private WebElement passwordField;

    @FindBy(id = "loginSubmit")
    private WebElement loginButton;

    @FindBy(id = "togglePasswordVisibility")
    private WebElement visibilityToggle;

    @FindBy(className = "error-message")
    private WebElement errorMessage;

    public void navigateToLoginPage() {
    }

    public void enterEmailOnly(String email) {
        enterText(emailField, email);
        passwordField.clear();
    }

    public void enterPasswordOnly(String password) {
        emailField.clear();
        enterText(passwordField, password);
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }
    public void simulateAutofill() {
    }

    public boolean isPasswordMasked() {
        return "password".equals(passwordField.getAttribute("type"));
    }

    public boolean isPasswordVisible() {
        return visibilityToggle.isSelected();
    }

    public void enterCredentials(String username, String password) {
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
