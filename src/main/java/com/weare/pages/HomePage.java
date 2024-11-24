package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseWeArePage {
    public HomePage() {
        super("");
    }

    private final By registerButton = By.xpath("//li[@class='nav-item cta mr-md-1']");
    private final By signInButton = By.xpath("//li[@class='nav-item cta cta cta-colored']");
    private final By latestPostButton = By.xpath("//a[text()='Latest Posts']");
    private final By logoutButton = By.xpath("//a[text()='LOGOUT']");
    private final By addNewPostButton = By.xpath("//*[@id=\"ftco-nav\"]/ul/li[8]/a");

    public void clickRegisterButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public void clickLogoutButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
    }

    public By getRegisterButtonLocator() {
        return registerButton;
    }

    public void clickSignInButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void clickAddNewPostButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(addNewPostButton)).click();
    }

    public void clickLatestPostButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(latestPostButton)).click();
    } //WE are social media  WE are social media


}
