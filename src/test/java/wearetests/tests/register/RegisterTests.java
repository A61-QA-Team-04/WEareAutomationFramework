package wearetests.tests.register;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WeAreBaseWeb;

import static wearetests.testdata.Users.*;
import static wearetests.testdata.Users.RANDOM_PASSWORD;

public class RegisterTests extends WeAreBaseWeb {
    String PASSWORD = "Vald!d!@#12*";

    @Test
    public void valid_Registration_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(VALID_USER, VALID_EMAIL, PASSWORD, PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(driver().getTitle(), "Successful Registration", "ERROR REGISTERING");
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
    public void passowrds_Not_Matching_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(RANDOM_USERNAME, RANDOM_EMAIL, PASSWORD, "Vald!d!@#12");
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "Your password is not confirmed", "message not as expected for unmatching passwords");
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
    public void username_less_than_2_symbols_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(ONE_SYMBOL_USER, VALID_EMAIL, PASSWORD, PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "Username must be between 2 and 20 symbols.", "message not as expected for invalid username");
    }

    @Test
    public void username_more_than_20_symbols_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(TWENTY_SYMBOLS_USER, VALID_EMAIL, PASSWORD, PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "Username must be between 2 and 20 symbols.", "message not as expected for invalid username");
    }

    @Test
    public void password_less_than_8_symbols_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(VALID_USER_B, VALID_EMAIL, LESS_THAN_EIGHT_SYMBOLS_PASSOWRD, LESS_THAN_EIGHT_SYMBOLS_PASSOWRD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "Password must be more than 8 symbols.", "message not as expected for invalid username");
    }

    @Test
    public void password_without_capital_letter_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(VALID_USER_C, VALID_EMAIL, NO_CAPITAL_LETTER_PASSWORD, NO_CAPITAL_LETTER_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "Password should contain capital letter.", "message not as expected for invalid username");
    }

    @Test
    public void password_without_digit_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(VALID_USER_D, VALID_EMAIL, NO_DIGIT_PASSWORD, NO_DIGIT_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "Password should contain a digit.", "message not as expected for invalid username");
    }

    @Test
    public void password_without_special_symbol_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(VALID_USER_E, VALID_EMAIL, NO_SPECIAL_SYMBOL_PASSWORD, NO_SPECIAL_SYMBOL_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(), "Password should contain a special symbol.", "message not as expected for invalid username");
    }

    @Test
    public void valid_Registration_Admin_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(ADMIN_USER, RANDOM_EMAIL, ADMIN_PASSWORD, ADMIN_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(driver().getTitle(), "Successful Registration", "ERROR REGISTERING");
    }

    @Test
    public void Random_Username_Test() {
        homePage.clickRegisterButton();
        registerPage.fillAllFields(RANDOM_USERNAME, RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();

    }
}
