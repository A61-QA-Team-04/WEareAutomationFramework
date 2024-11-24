package wearetests.tests.comment;

import com.weare.pages.CommentPage;
import com.weare.pages.CreateAPostPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import testframework.PropertiesManager;
import wearetests.core.WeAreBaseWeb;

import static wearetests.testdata.Users.*;

public class BaseComment extends WeAreBaseWeb {
    protected CommentPage commentPage;

    @BeforeEach
    public void setUp() {
        commentPage = new CommentPage();
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
        homePage.clickSignInButton();
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        homePage.clickLatestPostButton();

    }

    public void createAComment() {
        driver().findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[1]/div/div[2]/p[3]/a[1]")).click();

    }
}
