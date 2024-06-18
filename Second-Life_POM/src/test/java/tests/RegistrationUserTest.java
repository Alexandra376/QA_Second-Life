package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationUserPage;

public class RegistrationUserTest extends BaseUserTest {
    @Test
    void successRegisterTest() {
        new RegistrationUserPage(driver, wait).register(correctRegisterUser);
    }

    @Test
    void wrongEmailRegisterTest1() {
        new RegistrationUserPage(driver, wait).wrongEmail(wrongEmailRegisterUser);
    }

    @Test
    void wrongEmailRegisterTest2() {
        new RegistrationUserPage(driver, wait).emailAlreadyExist(existEmail);
    }

    @Test
    void wrongPasswordRegisterTest1() {
        new RegistrationUserPage(driver, wait).wrongPasswordWithoutLetter(wrongPasswordRegisterUser1);
    }

    @Test
    void wrongPasswordRegisterTest2() {
        new RegistrationUserPage(driver, wait).wrongPasswordWithoutSpecialCharacterAndLetter(wrongPasswordRegisterUser2);
    }
}
