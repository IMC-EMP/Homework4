package com.stv.factorytests;

import com.stv.factorypages.LoginPage;
import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordMaskingTest extends BaseTest {

    @Test
    public void verifyPasswordFieldMasking() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();

        assertTrue("Password field should be masked by default",
                loginPage.isPasswordMasked());

        loginPage.enterCredentials("test@example.com", "password123");
        assertTrue("Password should remain masked after input",
                loginPage.isPasswordMasked());
    }
}