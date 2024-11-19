package wearetests.tests.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static wearetests.testdata.Users.VALID_USER;

public class SearchTests extends BaseSearch {

    @Test
    public void search_for_users_Test() {
        searchForProfession("Doctor");
        clickSearchButton();
        assertTrue(resultsPage.isUserPresent(VALID_USER), "User not found in search results!");
    }
    public void search_for_not_found_user_Test() {

    }

}
