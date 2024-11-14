package com.weare.pages;

import org.apache.groovy.parser.antlr4.GroovyParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateAPostPage extends BaseWeArePage{
    public CreateAPostPage() {
     super("newPost");
}


private final By postVisibilityDropdown = By.id("StringListId");
private final By postContentBox = By.id("message");
private final By savePostButton = By.xpath("//input[@value='Save post']");



public void selectPostVisibility(String postVisibility) {
    WebElement visibilityOption = driverWait().until(ExpectedConditions.visibilityOfElementLocated(postVisibilityDropdown));

    Select select = new Select(visibilityOption);
    select.selectByVisibleText(postVisibility);
}

public void createNewPost(String postContent) {
    driverWait().until(ExpectedConditions.visibilityOfElementLocated(postContentBox)).sendKeys(postContent);
}

public void clickSavePostButton() {
    driverWait().until(ExpectedConditions.visibilityOfElementLocated(savePostButton)).click();
}

    public void addNewPost(String postContent) {
    createNewPost(postContent);
}
}
