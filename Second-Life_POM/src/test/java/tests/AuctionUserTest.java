package tests;

import org.junit.jupiter.api.Test;
import pages.AuctionUserAPage;

public class AuctionUserTest extends BaseUserTest {
    @Test
    void successfullyApplyAuctionTest() {
        new AuctionUserAPage(driver, wait, getCorrectUser(), getOfferAuction(), getOfferAuctionWinBid()).applyAuction();
    }
    @Test
    void successfullyBuyoutAuctionWinBidOfferTest() {
        new AuctionUserAPage(driver, wait, getCorrectUser(), getOfferAuction(), getOfferAuctionWinBid()).buyoutAuctionWinBid();
    }
    @Test
    void successfullyCancelAuctionOfferTest() {
        new AuctionUserAPage(driver, wait, getCorrectUser(), getOfferAuction(), getOfferAuctionWinBid()).cancelAuction();
    }
    @Test
    void successfullyCancelAuctionWinBidOfferTest() {
        new AuctionUserAPage(driver, wait, getCorrectUser(), getOfferAuction(), getOfferAuctionWinBid()).cancelAuctionWinBid();
    }
}
