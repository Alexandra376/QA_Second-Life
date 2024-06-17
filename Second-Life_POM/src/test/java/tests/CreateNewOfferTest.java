package tests;

import model.User;
import org.junit.jupiter.api.Test;
import pages.CreateNewOfferPage;

public class CreateNewOfferTest extends BaseTest {

    private User user;
    @Test
    void successSaveAsDraftTest() {
        new CreateNewOfferPage(driver, wait, getCorrectUser()).saveAsDraft(createNewOfferFree);
    }
    @Test
    void successSubmitTest() {
        new CreateNewOfferPage(driver, wait, getCorrectUser()).submit(createNewOfferAuction);
    }
    @Test
    void successCancelTest() {
        new CreateNewOfferPage(driver, wait, getCorrectUser()).cancel(createNewOfferAuctionWithWinBid);
    }
    @Test
    void successCopyToNewDraftTest() {
        new CreateNewOfferPage(driver, wait, getCorrectUser()).copyToNewDraft(createNewOfferAuctionWithWinBid);
    }
    @Test
    void incorrectTitleSaveAsDraftTest() {
        new CreateNewOfferPage(driver, wait, getCorrectUser()).submitIncorrectTitle(createNewOfferFreeWithIncorrectTitle);
    }
    @Test
    void incorrectDescriptionSaveAsDraftTest() {
        new CreateNewOfferPage(driver, wait, getCorrectUser()).submitIncorrectDescription(createNewOfferFreeWithIncorrectDescription);
    }
}
