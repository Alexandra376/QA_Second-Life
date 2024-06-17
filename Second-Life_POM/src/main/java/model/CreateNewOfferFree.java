package model;

public class CreateNewOfferFree {
    private String title;
    private String description;
    private int auctionDuration;

    public CreateNewOfferFree(String title, String description, int auctionDuration) {
        this.title = title;
        this.description = description;
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
}
