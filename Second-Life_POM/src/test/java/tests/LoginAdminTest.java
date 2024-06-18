package tests;

import org.junit.jupiter.api.Test;
import pages.LoginAdminPage;

public class LoginAdminTest extends BaseAdminTest {
    @Test
    void successLoginTest() {
        new LoginAdminPage(driver, wait).login(correctUser);
    }

    @Test
    void wrongEmailLoginTest() {
        new LoginAdminPage(driver, wait).loginWrongEmail(wrongEmailUser);
    }

    @Test
    void wrongPasswordLoginTest() {
        new LoginAdminPage(driver, wait).loginWrongPassword(wrongPasswordUser);
    }
}
