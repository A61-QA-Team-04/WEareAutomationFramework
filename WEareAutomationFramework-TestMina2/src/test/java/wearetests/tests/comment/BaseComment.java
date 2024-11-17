package wearetests.tests.comment;

import com.weare.pages.CommentPage;
import com.weare.pages.CreateAPostPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import testframework.PropertiesManager;
import wearetests.core.WeAreBaseWeb;

import static wearetests.testdata.Users.PASSWORD_VALID;
import static wearetests.testdata.Users.USERNAME_VALID;

public class BaseComment extends WeAreBaseWeb {
    protected CommentPage commentPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        commentPage = new CommentPage();
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
        homePage.clickSignInButton();
        loginPage.inputCredentials(USERNAME_VALID, PASSWORD_VALID);
        homePage.clickLatestPostButton();

    }

    public void createAComment() {
        driver().findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[1]/div/div[2]/p[3]/a[1]")).click();

    }
}
