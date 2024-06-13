package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    void successLoginTest() {
        new LoginPage(driver, wait).login(correctUser);
    }

    @Test
    void wrongEmailLoginTest() {
        new LoginPage(driver, wait).loginWrongEmail(wrongEmailUser);
    }

    @Test
    void wrongPasswordLoginTest() {
        new LoginPage(driver, wait).loginWrongPassword(wrongPasswordUser);
    }
}
