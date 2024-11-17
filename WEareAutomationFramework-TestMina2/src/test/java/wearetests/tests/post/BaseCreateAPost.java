package wearetests.tests.post;

import com.weare.pages.CreateAPostPage;
import com.weare.pages.FeedsPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import testframework.PropertiesManager;
import wearetests.core.WeAreBaseWeb;

import static wearetests.testdata.Users.*;

public class BaseCreateAPost extends WeAreBaseWeb {
    protected CreateAPostPage createAPostPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        createAPostPage = new CreateAPostPage();
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
        homePage.clickSignInButton();
        loginPage.inputCredentials(USERNAME_VALID, PASSWORD_VALID);
        homePage.clickAddNewPostButton();

    }

    public void createAPost() {
        driver().findElement(By.xpath("//*[@id=\"ftco-nav\"]/ul/li[8]/a")).click();

    }
}
