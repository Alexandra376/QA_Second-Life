package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.RegistrationRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

import static org.hamcrest.core.StringContains.containsString;

public class RegistrationTest extends BaseTest {
    private String registrationUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        registrationUrl = httpProperties.getProperty("registration.url");
    }

    public static String getRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#%&+=!";
        Random random = new SecureRandom();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(chars.length());
            result.append(chars.charAt(randomIndex));
        }
        return result + "@test.com";
    }

    @Test
    public void registerSuccessTest() {
        RegistrationRequestDto registration = createRegistrationRequest(null, "registrationLogin.password", "registrationFirstName.firstName", "registrationLastName.lastName");
        ResponseDto dto = withBodyResponse(registration, registrationUrl, 201)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void registerUserWithInvalidEmailFormatTest() {
        RegistrationRequestDto registerUserWithInvalidEmailFormat = createRegistrationRequest("registrationInvalidEmailFormat.email", "registrationLogin.password", "registrationFirstName.firstName", "registrationLastName.lastName");
        ErrorDto errorDto = withBodyResponse(registerUserWithInvalidEmailFormat, registrationUrl, 400)
                .body(containsString("Email is not valid"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }

    @Test
    public void registerUserWithExistEmailTest() {
        RegistrationRequestDto registerUserWithExistEmail = createRegistrationRequest("registerUserWithExistEmail.email", "registrationLogin.password", "registrationFirstName.firstName", "registrationLastName.lastName");
        ErrorDto errorDto = withBodyResponse(registerUserWithExistEmail, registrationUrl, 422)
            .body(containsString("Email barak.obama@email.com already exists"))
            .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
