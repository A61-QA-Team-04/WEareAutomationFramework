package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BaseWeArePage {
    public ProfilePage() {
        super("");
    }

    private final By EDIT_BUTTON = By.xpath("//a[contains(text(),'edit')]");
    private final By FIRST_NAME_FIELD = By.id("nameE");
    private final By LAST_NAME_FIELD = By.id("lastnameE");
    private final By BIRTHDAY_FIELD = By.id("birthDayE");
    private final By SUBMIT_BUTTON = By.xpath("//button[@name='submit']");
    private final By PROFILE_BUTTON = By.id("list-front-list");
    private final By WELCOME_NAME = By.xpath("//h1");

    public String getName() {
        WebElement name = driver().findElement(WELCOME_NAME);
        return name.getText();
    }

    public void clickProfileButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(PROFILE_BUTTON)).click();
    }

    public void clickUpdateButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(SUBMIT_BUTTON)).click();
    }

    public void updateFirstName(String firstName) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_FIELD)).clear();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_FIELD)).sendKeys(firstName);
    }

    public void updateBirthday(String birthday) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(BIRTHDAY_FIELD)).sendKeys(birthday);
    }

    public void updateLastName(String lastname) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME_FIELD)).clear();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME_FIELD)).sendKeys(lastname);
    }


    public void clickEditButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(EDIT_BUTTON)).click();
    }
}
