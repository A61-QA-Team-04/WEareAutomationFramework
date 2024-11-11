package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseWeArePage {
    public LoginPage() {
        super("login");
    }

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By submitButton = By.xpath("//input[@value='Login']");

    public void inputCredentials(String username, String password) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
    }

}
