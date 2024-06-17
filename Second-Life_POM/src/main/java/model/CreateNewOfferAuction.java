package model;

public class CreateNewOfferAuction {
    private String title;
    private String description;
    private int startPrice;
    private int auctionDuration;

    public CreateNewOfferAuction(String title, String description, int auctionDuration, int startPrice) {
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.auctionDuration = auctionDuration;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public int getAuctionDuration() {
        return auctionDuration;
    }

    public int getStartPrice() {
        return startPrice;
    }
}
