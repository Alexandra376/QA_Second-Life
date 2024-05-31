package com.second_life;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class RegistrationRequestDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
