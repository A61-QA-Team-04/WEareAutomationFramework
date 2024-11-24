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

public class CreateAPostTests extends BaseCreateAPost {

    @Test
    public void createAPost() {
        createAPostPage.createNewPost("Test1234");
        createAPostPage.selectPostVisibility("Public post");
        createAPostPage.clickSavePostButton();

        String postContent = createAPostPage.getPostText();
        Assertions.assertTrue(postContent.contains("Test1234"), "Post content does not match expected value.");
    }
}
