package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class FeedsPage extends BaseWeArePage {
    public FeedsPage() {
        super("/posts");
    }

    private final By likeButton = By.id("submit-val65");
    private final By likeCount = By.id("like-count65");

    List<WebElement> elements = driver().findElements(By.xpath("//div[@class='text pl-md-4']"));

    public void clickLikeButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButton)).click();
    }
    public void clickDislikeButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButton)).click();
    }

    public String getLikeCount() {
        WebElement likeElement = driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeCount));
        return likeElement.getText();
    }

}
