package model;

public class CreateNewOfferAuctionWinBid {
    private String title;
    private String description;
    private int startPrice;
    private int winBid;
    private int auctionDuration;
    public CreateNewOfferAuctionWinBid(String title, String description, int startPrice, int winBid, int auctionDuration) {
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.winBid = winBid;
        this.auctionDuration = auctionDuration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public int getWinBid() {
        return winBid;
    }

    public int getAuctionDuration() {
        return auctionDuration;
    }
}
