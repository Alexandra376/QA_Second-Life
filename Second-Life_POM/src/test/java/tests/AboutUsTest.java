package tests;

import org.junit.jupiter.api.Test;
import pages.AboutUsPage;

public class AboutUsTest extends BaseUserTest {
    @Test
    void checkImagePresentSuccessTest() {
        new AboutUsPage(driver, wait).isImagesPresentSuccess();
    }
}
