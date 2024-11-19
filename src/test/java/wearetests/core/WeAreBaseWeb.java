package wearetests.core;

import com.weare.pages.HomePage;
import com.weare.pages.LoginPage;
import com.weare.pages.RegisterPage;
import com.weare.pages.ResultsPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import testframework.ExtentManager;
import testframework.ExtentTestWatcher;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;
@ExtendWith(ExtentTestWatcher.class)
public class WeAreBaseWeb extends BaseWebTest {
    protected RegisterPage registerPage;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ResultsPage resultsPage;

    @BeforeAll
    public static void setupSuite() {
        // Initialize ExtentReports before all tests
        ExtentManager.getExtentReports();
    }
    @BeforeEach
    public void setUp(TestInfo testInfo) {
        // Retrieve the test name and description dynamically
            String testName = testInfo.getDisplayName();
            String testDescription = testInfo.getTags().toString(); // Optional
            ExtentManager.createTest(testName, testDescription);
            ExtentManager.getTest().info("Starting test: " + testName);


        // Initialize page objects
        registerPage = new RegisterPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        resultsPage = new ResultsPage();

        // Launch the browser and open the base URL
        ChromeOptions options = new ChromeOptions();
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
    }


    @BeforeAll
    public static void beforeAll() {
        // perform some code before all tests start
    }

    @AfterEach
    public void afterTest() {
        // Log the completion of the test
        ExtentManager.getTest().info("Test Finished");

        // Ensure we log the final result as 'fail' if necessary
        if (driver().getTitle().contains("Error")) {  // Customize the condition based on the actual error check
            ExtentManager.getTest().fail("Test failed due to some condition in the browser");
        }

        // Close the browser after each test
        driver().close();
    }

    @AfterAll
    public static void tearDownSuite() {
        // Flush the reports after all tests are executed
        ExtentManager.getExtentReports().flush();
    }


}