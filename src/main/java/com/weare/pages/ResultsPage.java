package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends BaseWeArePage {
    public ResultsPage() {
        super("/search");
    }

    private final By userNamesLocator = By.xpath("//h2[@class='mr-3 text-black']");

    public List<String> getUserNames() {
        List<WebElement> userElements = driver().findElements(userNamesLocator);
        List<String> userNames = new ArrayList<>();

        for (WebElement userElement : userElements) {
            userNames.add(userElement.getText());
        }

        return userNames;
    }

    public boolean isUserPresent(String userName) {
        List<String> userNames = getUserNames();
        return userNames.contains(userName);
    }


}
