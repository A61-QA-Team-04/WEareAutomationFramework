package wearetests.tests.register;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WeAreBaseWeb;

import static wearetests.testdata.Users.*;
import static wearetests.testdata.Users.RANDOM_PASSWORD;

public class RegisterTests extends WeAreBaseWeb {
    String PASSWORD = "vlvl@vlvl123.com";

    @Test
    public void valid_Registration_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(RANDOM_USERNAME, RANDOM_EMAIL, PASSWORD, PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(driver().getTitle(), "Successful Registration", "ERROR REGISTERING");
    }

    @Test
    public void passowrds_Not_Matching_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(RANDOM_USERNAME, RANDOM_EMAIL, PASSWORD, "123123*@(A");
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "Your password is not confirmed", "message not as expected for unmatching passwords");
    }

    @Test
    public void already_Existing_User_Test() {
        homePage.clickRegisterButton();
        registerPage.fillExistingUserDetails();
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "User with this username already exist", "message not as expected for existing user");

    }

    @Test
    public void invalid_Email_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(RANDOM_USERNAME, INVALID_EMAIL, PASSWORD, PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "this doesn't look like valid email", "message not as expected for invalid email");
    }

    @Test
    public void Random_Username_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(RANDOM_USERNAME, RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();

    }
}
