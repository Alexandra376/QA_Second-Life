package tests;

import model.User;
import org.junit.jupiter.api.Test;
import pages.CreateNewOfferUserPage;

public class CreateNewOfferUserTest extends BaseUserTest {

    private User user;
    @Test
    void successSaveAsDraftTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).saveAsDraft(createNewOfferFree);
    }
    @Test
    void successSubmitTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).submit(createNewOfferAuction);
    }
    @Test
    void successCancelTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).cancel(createNewOfferAuctionWithWinBid);
    }
    @Test
    void successCopyToNewDraftTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).copyToNewDraft(createNewOfferAuctionWithWinBid);
    }
    @Test
    void incorrectTitleSaveAsDraftTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).submitIncorrectTitle(createNewOfferFreeWithIncorrectTitle);
    }
    @Test
    void incorrectDescriptionSaveAsDraftTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).submitIncorrectDescription(createNewOfferFreeWithIncorrectDescription);
    }
}
