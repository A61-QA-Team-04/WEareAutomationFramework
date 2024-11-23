package wearetests.testdata;

import org.apache.commons.lang3.RandomStringUtils;

public class Users {

    public static final String VALID_USER = "validUser";
    public static final String INVALID_USER = "!@$!#@";
    public static final String VALID_PASSWORD = "Vald!d!@#12*";
    public static final String INVALID_PASSOWRD = "12";
    public static final String ADMIN_USER = "Admin";
    public static final String ADMIN_PASSWORD = "Admin-24";
    public static final String USERNAME_VALID = "validUser";
    public static final String PASSWORD_VALID = "Vald!d!@#12*";
    public static final String RANDOM_USERNAME = RandomStringUtils.random(10, true, false);
    public static final String RANDOM_PASSWORD = RandomStringUtils.random(10, true, true);
    public static final String RANDOM_EMAIL = RandomStringUtils.random(10, true, true) + "@yahoo.com";
    public static final String INVALID_EMAIL="asdasd";


}