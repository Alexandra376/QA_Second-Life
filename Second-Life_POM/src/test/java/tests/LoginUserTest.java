package tests;

import org.junit.jupiter.api.Test;
import pages.LoginUserPage;

public class LoginUserTest extends BaseUserTest {
    @Test
    void successLoginTest() {
        new LoginUserPage(driver, wait).login(correctUser);
    }

    @Test
    void wrongEmailLoginTest() {
        new LoginUserPage(driver, wait).loginWrongEmail(wrongEmailUser);
    }

    @Test
    void wrongPasswordLoginTest() {
        new LoginUserPage(driver, wait).loginWrongPassword(wrongPasswordUser);
    }
}
