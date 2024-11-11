package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseWeArePage {
    public HomePage() {
        super("");
    }

    private final By registerButton = By.xpath("//li[@class='nav-item cta mr-md-1']");
    private final By signInButton = By.xpath("//li[@class='nav-item cta cta cta-colored']");

    public void clickRegisterButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public void clickSignInButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }


}
