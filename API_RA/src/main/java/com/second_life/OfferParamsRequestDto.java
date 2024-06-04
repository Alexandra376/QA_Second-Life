package com.second_life;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class OfferParamsRequestDto {
    private int page;
    private int size;
    private String sortBy;
    private int id;
}
