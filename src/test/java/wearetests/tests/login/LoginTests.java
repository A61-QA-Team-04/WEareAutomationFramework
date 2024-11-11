package wearetests.tests.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wearetests.core.WeAreBaseWeb;

import static testframework.core.BaseWebTest.driver;
import static wearetests.testdata.Users.*;


public class LoginTests extends WeAreBaseWeb {

    @Test
    public void login_whenValidCredentials_AreInput() {
        homePage.clickSignInButton();
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        WebElement message = driver().findElement(By.xpath("//h1"));
        Assertions.assertEquals(message.getText(), "The Easiest Way to Hack the Crisis", "USER NOT LOGGED IN");
    }

    @Test
    public void login_whenInvalidCredentials_AreInput() {
        homePage.clickSignInButton();
        loginPage.inputCredentials(INVALID_USER, INVALID_PASSOWRD);
        WebElement message = driver().findElement(By.xpath("//i[text()=' Wrong username or password. ']"));
        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(message.getText(), "Wrong username or password.");
        Assertions.assertEquals(driver().findElement(By.xpath("//i[text()=' Wrong username or password. ']")).getText(), "Wrong username or password.", "USER LOGGED IN WITH INVALID CREDENTIALS");
    }

    @Test
    public void login_whenBlankCredentials_AreInput() {
        homePage.clickSignInButton();
        loginPage.inputCredentials("", "");
        WebElement message = driver().findElement(By.xpath("//i[text()=' Wrong username or password. ']"));
        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(message.getText(), "Wrong username or password.");
        Assertions.assertEquals(driver().findElement(By.xpath("//i[text()=' Wrong username or password. ']")).getText(), "Wrong username or password.", "USER LOGGED IN WITH INVALID CREDENTIALS");
    }
}
