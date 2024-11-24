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

    public static final String POST_TEXT = "A new testing post for the WEare social network.";
    public static final String POST_TEXT_B = "Another testing post with a song uploaded.";

    @Test
    public void createAPost_Test() {
        createAPostPage.createNewPost(POST_TEXT);
        createAPostPage.selectPostVisibility("Private post");
        createAPostPage.clickSavePostButton();

        String postContent = createAPostPage.getPostText();
        Assertions.assertTrue(postContent.contains(POST_TEXT), "Post content does not match expected value.");
    }

    @Test
    public void createAPost_with_song_upload_Test() {
        createAPostPage.createNewPost(POST_TEXT_B);
        createAPostPage.selectPostVisibility("Private post");
        createAPostPage.clickChooseFileButton();
        createAPostPage.clickSavePostButton();

        String postContent = createAPostPage.getPostText();
        Assertions.assertTrue(postContent.contains(POST_TEXT_B), "Post content does not match expected value.");
    }
}
