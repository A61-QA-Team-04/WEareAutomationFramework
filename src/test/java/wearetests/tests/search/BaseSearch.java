package wearetests.tests.search;

import wearetests.core.WeAreBaseWeb;

public class BaseSearch extends WeAreBaseWeb {
    public void searchForProfession(String profession) {
        homePage.searchForProfession(profession);
    }

    public void clickSearchButton() {
        homePage.clickSearchButton();

    }
}
