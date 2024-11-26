package wearetests.tests.register;

import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import wearetests.core.WeAreBaseWeb;


public class BaseRegister extends WeAreBaseWeb {
    @BeforeEach
    public void setUp() {
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
        homePage.clickRegisterButton();

    }

    public void logout() {
        homePage.clickLogoutButton();
    }

}
