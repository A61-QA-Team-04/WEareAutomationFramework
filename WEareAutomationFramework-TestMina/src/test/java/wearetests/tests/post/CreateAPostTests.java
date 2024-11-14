package wearetests.tests.post;

import com.weare.pages.CreateAPostPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wearetests.core.WeAreBaseWeb;

import static testframework.core.BaseWebTest.driver;
import static wearetests.testdata.Users.*;

public class CreateAPostTests extends WeAreBaseWeb {

    @Test
    public void createAPost() {

        createAPostPage.createNewPost(String postContent);

        createAPostPage.selectPostVisibility("Private post");
        createAPostPage.addNewPost();
        createAPostPage.clickSavePostButton();

        WebElement postVisibility = driver().findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[1]/div/div[2]/span[1]"));
        Assertions.assertEquals(postVisibility.getText(), "Public Post: False", "Private post text");
        postContent = driver().findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[1]/div/div[2]/p[2]"));
        Assertions.assertNotNull(postContent.getText(), "A new testing post from Selenium.");
    }
}
