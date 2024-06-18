package tests;

import org.junit.jupiter.api.Test;
import pages.PersonalInformationUserPage;

public class PersonalInformationUserTest extends BaseUserTest {
    @Test
    void successfullyUploadPhotoTest() {
        new PersonalInformationUserPage(driver, wait, getCorrectUser()).successfullyUploadPhoto();
    }
}
