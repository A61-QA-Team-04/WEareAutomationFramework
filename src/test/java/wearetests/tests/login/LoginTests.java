package wearetests.tests.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static wearetests.testdata.Users.*;


public class LoginTests extends BaseLogin {


    @Test
    @DisplayName("Login with Valid Credentials")

    public void login_whenValidCredentials_AreInput() {
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        WebElement message = driver().findElement(By.xpath("//h1"));
        Assertions.assertEquals(message.getText(), "The Easiest Way to Hack the Crisis", "USER NOT LOGGED IN");
    }

    @Test
    public void login_whenInvalidCredentials_AreInput() {
        loginPage.inputCredentials(INVALID_USER, INVALID_PASSOWRD);
        WebElement message = driver().findElement(By.xpath("//i[text()=' Wrong username or password. ']"));
        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(message.getText(), "Wrong username or password.");
        Assertions.assertEquals(driver().findElement(By.xpath("//i[text()=' Wrong username or password. ']")).getText(), "Wrong username or password.", "USER LOGGED IN WITH INVALID CREDENTIALS");
    }

    @Test
    public void login_whenBlankCredentials_AreInput() {
        loginPage.inputCredentials("", "");
        WebElement message = driver().findElement(By.xpath("//i[text()=' Wrong username or password. ']"));
        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(message.getText(), "Wrong username or password.");
        Assertions.assertEquals(driver().findElement(By.xpath("//i[text()=' Wrong username or password. ']")).getText(), "Wrong username or password.", "USER LOGGED IN WITH INVALID CREDENTIALS");
    }

    @Test
    public void loggedIn_asUser_AdminPanelNotVisible() {
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        By adminPanelButtonLocator = By.xpath("//a[@href='/admin']");
        boolean isAdminPanelVisible = isElementVisible(adminPanelButtonLocator);
        Assertions.assertFalse(isAdminPanelVisible, "Admin Panel button should not be present or visible for a normal user!");
    }

    @Test
    public void loggedIn_asAdmin_AdminPanelVisible() {
        loginPage.inputCredentials(ADMIN_USER, ADMIN_PASSWORD);
        By adminPanelButtonLocator = By.xpath("//a[@href='/admin']");
        boolean isAdminPanelVisible = isElementVisible(adminPanelButtonLocator);
        Assertions.assertTrue(isAdminPanelVisible, "Admin Panel button should be visible for an admin user!");
    }

    @Test
    public void logout_Test() {
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        homePage.clickLogoutButton();
        By registerButton = homePage.getRegisterButtonLocator();
        Assertions.assertTrue(
                driverWait().until(ExpectedConditions.invisibilityOfElementLocated(registerButton)),
                "Register button is still visible, logout might have failed"
        );
        Assertions.assertEquals(loginPage.getLoginText(), "Login Page", "User is not logged out");
    }
}

