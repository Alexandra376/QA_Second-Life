package tests;

import org.junit.jupiter.api.Test;
import pages.CreateNewOfferUserPage;

public class CreateNewOfferUserTest extends BaseUserTest {

    @Test
    void successSaveAsDraftTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).saveAsDraft(createNewOfferFree);
    }
    @Test
    void successSubmitOfferFreeTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).submitFreeOffer(createNewOfferFree);
    }
    @Test
    void successSubmitOfferAuctionTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).submitOfferAuction(createNewOfferAuction);
    }
    @Test
    void successSubmitOfferAuctionWithWinBidTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).submitOfferAuctionWithWinBid(createNewOfferAuctionWithWinBid);
    }
    @Test
    void successCancelOfferAuctionWinBidTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).cancelOfferAuctionWinBid(createNewOfferAuctionWithWinBid);
    }
    @Test
    void successCopyToNewDraftOfferAuctionWithWinBidTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).copyToNewDraftOfferAuctionWithWinBid(createNewOfferAuctionWithWinBid);
    }
    @Test
    void unsuccessSubmitOfferFreeWithIncorrectTitle() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).submitOfferFreeWithIncorrectTitle(createNewOfferFreeWithIncorrectTitle);
    }
    @Test
    void unsuccessSubmitOfferFreeWithIncorrectDescriptionTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectUser()).submitOfferFreeWithIncorrectDescription(createNewOfferFreeWithIncorrectDescription);
    }
    @Test
    void successSubmitOfferFreeNewAccountTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectTestUser()).submitFreeOfferWithTestAccount(createNewOfferFree);
    }
    @Test
    void successSubmitOfferAuctionNewAccountTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectTestUser()).submitOfferAuctionWithTestAccount(createNewOfferAuction);
    }
    @Test
    void successSubmitOfferAuctionWithWinBidNewAccountTest() {
        new CreateNewOfferUserPage(driver, wait, getCorrectTestUser()).submitOfferAuctionWithWinBidWithTestAccount(createNewOfferAuctionWithWinBid);
    }
}
