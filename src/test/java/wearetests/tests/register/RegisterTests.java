package wearetests.tests.register;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weAreWeb.core.core.WeAreBaseWeb;

public class RegisterTests extends WeAreBaseWeb {
    @Test
    public void valid_Registration_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields("validUser", "vlvl@vlvl123.com", "vald!d!@#12*", "vald!d!@#12*");
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(driver().getTitle(), "Successful Registration", "ERROR REGISTERING");
    }

    @Test
    public void passowrds_Not_Matching_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields("VlVlvl", "vlvl@vlvl1.com", "123123*@(", "123123*@(A");
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
        registerPage.fillAllFields("VlVlvvl", "asdasdadada", "123123*@(A", "123123*@(A");
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "this doesn't look like valid email", "message not as expected for invalid email");
    }
}
