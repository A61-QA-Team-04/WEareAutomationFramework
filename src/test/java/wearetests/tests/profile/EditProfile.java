package wearetests.tests.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EditProfile extends BaseEdit {
    private String updatedFirstName = "Vladislav";
    private String updatedLastName = "Adamov";
    private String month = "01";
    private String day = "06";
    private String year = "1998";
    private String fullName = updatedFirstName + " " + updatedLastName;
    private String dayToCheck = year + "-" + day + "-" + month;
    private String updatedEmail="newMail@abv.bg";
    private String aFewWordsAboutYourself = "I like to go for a long walks";

    @Test
    public void update_FirstName_LastName_BirthDay_Test() {
        updateProfile(updatedFirstName, updatedLastName, day + month + year);
        Assertions.assertEquals(profilePage.getName(), fullName, "name not updated");
        Assertions.assertTrue(profilePage.getInfo().contains(updatedFirstName), "First name not updated");
        Assertions.assertTrue(profilePage.getInfo().contains(updatedLastName), "Last name not updated");
        Assertions.assertTrue(profilePage.getInfo().contains(dayToCheck), "Birthday not updated");
    }
    @Test
    public void update_Email_Test() {
        updateEmail(updatedEmail);
        Assertions.assertTrue(profilePage.getInfo().contains(updatedEmail), "Email not updated");
    }

    @Test
    public void update_Birthday_Test() {
        updateBirthDate("10/11/2010");
        Assertions.assertTrue(profilePage.getInfo().contains("10/11/2010"), "Birthday not updated");
    }
    @Test
    public void add_aFew_Words_About_Yourself() {
        profilePage.addAFewWordsAboutYourself(aFewWordsAboutYourself);
        profilePage.clickUpdateButton();
        profilePage.clickProfileButton();
        Assertions.assertTrue(profilePage.getInfo().contains(aFewWordsAboutYourself), "Bio not updated");
    }
    @Test
    public void firstName_Blank_Test() {
        updateFirstName("");
        Assertions.assertEquals(profilePage.getErrorMessage(),
                "first name must have at least 3 symbols!",
                "No error for blank first name");
    }
}
