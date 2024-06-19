package tests;

import org.junit.jupiter.api.Test;
import pages.AboutUsUserPage;

public class AboutUsUserTest extends BaseUserTest {
    @Test
    void checkImagePresentSuccessTest() {
        new AboutUsUserPage(driver, wait).isImagesPresentSuccess();
    }
}
