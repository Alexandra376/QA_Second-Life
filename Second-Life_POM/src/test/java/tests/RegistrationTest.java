package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {
    @Test
    void successRegisterTest() {
        new RegistrationPage(driver, wait).register(correctRegisterUser);
    }

    @Test
    void wrongEmailRegisterTest1() {
        new RegistrationPage(driver, wait).wrongEmail(wrongEmailRegisterUser);
    }

    @Test
    void wrongEmailRegisterTest2() {
        new RegistrationPage(driver, wait).emailAlreadyExist(existEmail);
    }

    @Test
    void wrongPasswordRegisterTest1() {
        new RegistrationPage(driver, wait).wrongPasswordWithoutLetter(wrongPasswordRegisterUser1);
    }

    @Test
    void wrongPasswordRegisterTest2() {
        new RegistrationPage(driver, wait).wrongPasswordWithoutSpecialCharacterAndLetter(wrongPasswordRegisterUser2);
    }
}
