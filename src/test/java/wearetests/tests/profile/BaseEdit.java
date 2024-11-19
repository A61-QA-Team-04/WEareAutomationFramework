package wearetests.tests.profile;


import com.weare.pages.BaseWeArePage;
import com.weare.pages.FeedsPage;
import com.weare.pages.ProfilePage;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import wearetests.core.WeAreBaseWeb;

import static wearetests.testdata.Users.VALID_PASSWORD;
import static wearetests.testdata.Users.VALID_USER;

public class BaseEdit extends WeAreBaseWeb {
    protected ProfilePage profilePage;

    @BeforeEach
    public void setUp() {
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
        profilePage = new ProfilePage();
        homePage.clickSignInButton();
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        homePage.clickMyAccountButton();
        profilePage.clickEditButton();


    }

    protected void updateProfile(String firstName, String lastName, String birthday) {
        profilePage.updateFirstName(firstName);
        profilePage.updateLastName(lastName);
        profilePage.updateBirthday(birthday);
        profilePage.clickUpdateButton();
        profilePage.clickProfileButton();
    }

    protected void updateEmail(String email) {
        profilePage.updateEmail(email);
        profilePage.clickUpdateButton();
        profilePage.clickProfileButton();
    }
}
