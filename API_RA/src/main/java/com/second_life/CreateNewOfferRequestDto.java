package com.second_life;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class CreateNewOfferRequestDto {
    private String title;
    private String description;
    private int auctionDurationDays;
    private int startPrice;
    private int step;
    private int winBid;
    private boolean isFree;
    private int categoryId;
    private int locationId;
}
