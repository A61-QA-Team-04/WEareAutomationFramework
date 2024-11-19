package wearetests.tests.login;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import wearetests.core.WeAreBaseWeb;

import static testframework.DriverManager.getDriver;

public class BaseLogin extends WeAreBaseWeb {
    public boolean isElementVisible(By locator) {
        try {
            WebElement element = driver().findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @BeforeEach
    public void login() {
        homePage.clickSignInButton();

    }

}
