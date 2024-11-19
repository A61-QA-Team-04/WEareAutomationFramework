package wearetests.tests.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EditProfile extends BaseEdit {
    private String updatedFirstName = "Vladislav";
    private String updatedLastName = "Adamov";
    private String updatedBirthday = "01061997";
    private String fullName = updatedFirstName + " " + updatedLastName;

    @Test
    public void testEditProfile() {
        updateProfile(updatedFirstName, updatedLastName, updatedBirthday);
        Assertions.assertEquals(profilePage.getName(), fullName, "name not updated");
    }
}
