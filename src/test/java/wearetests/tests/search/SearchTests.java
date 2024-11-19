package wearetests.tests.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static wearetests.testdata.Users.RANDOM_USERNAME;
import static wearetests.testdata.Users.VALID_USER;

public class SearchTests extends BaseSearch {
    private String nonExistingUser = "unex user";

    @Test
    public void search_for_users_Test() {
        searchForProfession("Doctor");
        clickSearchButton();
        assertTrue(resultsPage.isUserPresent(VALID_USER), "User not found in search results!");
    }

    @Test
    public void search_for_not_found_user_Test() {
        searchForName(nonExistingUser);
        clickSearchButton();
        Assertions.assertEquals(resultsPage.getErrorMessage(), "There are no users existing in this search criteria.", "NO ERROR MESSAGE FOR USER NO FOUND");
    }

}
