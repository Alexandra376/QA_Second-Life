package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.RegistrationRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class RegistrationTest extends BaseTest {
    private String registrationUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        registrationUrl = httpProperties.getProperty("registration.url");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
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
        ResponseDto dto = getValidatableResponse(registration, registrationUrl, 201)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void registerUserWithInvalidEmailFormatTest() {
        RegistrationRequestDto registerUserWithInvalidEmailFormat = createRegistrationRequest("registrationInvalidEmailFormat.email", "registrationLogin.password", "registrationFirstName.firstName", "registrationLastName.lastName");
        ErrorDto errorDto = getValidatableResponse(registerUserWithInvalidEmailFormat, registrationUrl, 400)
                .body(containsString("Email is not valid"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }

    @Test
    public void registerUserWithExistEmailTest() {
        RegistrationRequestDto registerUserWithExistEmail = createRegistrationRequest("registerUserWithExistEmail.email", "registrationLogin.password", "registrationFirstName.firstName", "registrationLastName.lastName");
        ErrorDto errorDto = getValidatableResponse(registerUserWithExistEmail, registrationUrl, 422)
            .body(containsString("Email barak.obama@email.com already exists"))
            .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
