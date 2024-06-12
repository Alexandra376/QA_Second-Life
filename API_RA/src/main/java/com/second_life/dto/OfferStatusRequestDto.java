package com.second_life.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class OfferStatusRequestDto {
    private int id;
    private int winnerBidId;
}
