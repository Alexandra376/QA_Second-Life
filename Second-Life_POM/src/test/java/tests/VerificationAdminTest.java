package tests;

import org.junit.jupiter.api.Test;
import pages.VerificationAdminPage;

public class VerificationAdminTest extends BaseUserTest {
    @Test
    void successVerifyOfferTest() {
        new VerificationAdminPage(driver, wait, getCorrectAdmin()).verifyOffer();
    }
}
