package tests;

import org.junit.jupiter.api.Test;
import pages.FreeOfferPage;

public class FreeOfferTest extends BaseUserTest {
    @Test
    void successfullyApplyFreeOfferTest() {
        new FreeOfferPage(driver, wait, getCorrectUser(), getCorrectTestUser(), getOfferFree(), getCorrectAdmin()).applyForFreeOffer();
    }
    @Test
    void successfullyCancelFreeOfferTest() {
        new FreeOfferPage(driver, wait, getCorrectUser(), null, getOfferFree(), getCorrectAdmin()).cancelFreeOffer();
    }
}
