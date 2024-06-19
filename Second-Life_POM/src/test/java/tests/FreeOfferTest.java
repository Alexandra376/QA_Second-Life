package tests;

import model.CreateNewOfferFree;
import org.junit.jupiter.api.Test;
import pages.FreeOfferPage;

public class FreeOfferTest extends BaseUserTest {
    @Test
    void successfullyApplyFreeOfferTest() {
        new FreeOfferPage(driver, wait, getCorrectUser(), getOfferFree()).applyForFreeOffer();
    }
    @Test
    void successfullyCancelFreeOfferTest() {
        new FreeOfferPage(driver, wait, getCorrectUser(), getOfferFree()).cancelFreeOffer();
    }
}
