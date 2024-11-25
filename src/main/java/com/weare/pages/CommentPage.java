package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommentPage extends BaseWeArePage{
    public CommentPage() {
        super("/api/comment/auth/creator");
    }

        private final By exploreThisPostButton = By.xpath("/html/body/section[1]/div/div/div[1]/div/div[1]/div/div[2]/p[3]/a[1]");
        private final By commentField = By.id("message");
        private final By postCommentButton = By.xpath("//*[@id=\"leaveComment\"]/form/div[2]/input");
        private final By commentConfirmationText = By.xpath("//p[text()='A new comment is created']");

    public void clickExploreThisPostButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(exploreThisPostButton)).click();
    }

    public void createNewComment(String commentContent) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(commentField)).sendKeys(commentContent);
    }

    public void clickPostCommentButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(postCommentButton));
    }

    public void addNewComment(String commentContent) {

        createNewComment(commentContent);
    }

    public String getCommentText() {
        return driverWait().until(ExpectedConditions.visibilityOfElementLocated(commentConfirmationText)).getText();
    }
}
