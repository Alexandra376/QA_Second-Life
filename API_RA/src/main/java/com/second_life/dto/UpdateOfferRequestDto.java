package com.second_life.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class UpdateOfferRequestDto {
    private int id;
    private String title;
    private String description;
    private int auctionDurationDays;
    private int startPrice;
    private int winBid;
    private boolean isFree;
    private int categoryId;
}
