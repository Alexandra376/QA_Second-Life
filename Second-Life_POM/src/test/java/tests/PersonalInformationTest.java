package tests;

import org.junit.jupiter.api.Test;
import pages.PersonalInformationPage;

public class PersonalInformationTest extends BaseTest {
    @Test
    void successfullyUploadPhotoTest() {
        new PersonalInformationPage(driver, wait, getCorrectUser()).successfullyUploadPhoto();
    }
}
