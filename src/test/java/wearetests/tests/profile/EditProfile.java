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

    @Test
    public void update_FirstName_LastName_BirthDay_Test() {
        updateProfile(updatedFirstName, updatedLastName, day + month + year);
        Assertions.assertEquals(profilePage.getName(), fullName, "name not updated");
        Assertions.assertTrue(profilePage.getInfo().contains(updatedFirstName), "First name not updated");
        Assertions.assertTrue(profilePage.getInfo().contains(updatedLastName), "Last name not updated");
        Assertions.assertTrue(profilePage.getInfo().contains(dayToCheck), "Birthdat not updated");
    }
    @Test
    public void update_Email_Test(){
        updateEmail(updatedEmail);
        Assertions.assertTrue(profilePage.getInfo().contains(updatedEmail), "Email not updated");
    }

    
}
