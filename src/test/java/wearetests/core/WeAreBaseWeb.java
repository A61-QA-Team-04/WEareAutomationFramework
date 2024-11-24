package wearetests.core;

import com.weare.pages.CreateAPostPage;
import com.weare.pages.HomePage;
import com.weare.pages.LoginPage;
import com.weare.pages.RegisterPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class WeAreBaseWeb extends BaseWebTest {
    protected RegisterPage registerPage;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected CreateAPostPage createAPostPage;


    @BeforeEach
    public void setUp() {
        registerPage = new RegisterPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        ChromeOptions options = new ChromeOptions();
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
    }


    @BeforeAll
    public static void beforeAll() {
        // perform some code before all tests start
    }

     @AfterEach
  public void afterTest() {
      driver().close();
      // perform some code after each test has finished
         }

    @AfterAll
    public static void afterAll() {
        // perform some code after all tests have finished
    }


}