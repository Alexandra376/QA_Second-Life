package tests;

import org.junit.jupiter.api.Test;
import pages.AuctionUserAPage;

public class AuctionUserTest extends BaseUserTest {
    @Test
    void successfullyApplyAuctionTest() {
        new AuctionUserAPage(driver, wait, getCorrectUser(), getOfferAuction(), getOfferAuctionWinBid(), getCorrectAdmin()).applyAuction();
    }
    @Test
    void successfullyBuyoutAuctionWinBidOfferTest() {
        new AuctionUserAPage(driver, wait, getCorrectUser(), getOfferAuction(), getOfferAuctionWinBid(), getCorrectAdmin()).buyoutAuctionWinBid();
    }
    @Test
    void successfullyCancelAuctionOfferTest() {
        new AuctionUserAPage(driver, wait, getCorrectUser(), getOfferAuction(), getOfferAuctionWinBid(), getCorrectAdmin()).cancelAuction();
    }
    @Test
    void successfullyCancelAuctionWinBidOfferTest() {
        new AuctionUserAPage(driver, wait, getCorrectUser(), getOfferAuction(), getOfferAuctionWinBid(), getCorrectAdmin()).cancelAuctionWinBid();
    }
}
