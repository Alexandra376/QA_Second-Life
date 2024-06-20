package tests;

import org.junit.jupiter.api.Test;
import pages.LoginAdminPage;

public class LoginAdminTest extends BaseUserTest {
    @Test
    void successLoginTest() {
        new LoginAdminPage(driver, wait, getCorrectAdmin()).login(correctAdmin);
    }

    @Test
    void wrongEmailLoginTest() {
        new LoginAdminPage(driver, wait, getCorrectAdmin()).loginWrongEmail(wrongEmailAdmin);
    }

    @Test
    void wrongPasswordLoginTest() {
        new LoginAdminPage(driver, wait, getCorrectAdmin()).loginWrongPassword(wrongPasswordAdmin);
    }
}
