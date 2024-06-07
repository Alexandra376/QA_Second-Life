package com.second_life.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class EditCategoryRequestDto {
    private int id;
    private String name;
    private String description;
    private boolean active;
}
