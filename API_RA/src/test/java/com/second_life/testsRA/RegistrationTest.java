package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.LoginRequestDto;
import com.second_life.dto.RegistrationRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class RegistrationTest extends BaseTest {
    private RegistrationRequestDto registration;
    private RegistrationRequestDto registerUserWithInvalidEmailFormat;
    private RegistrationRequestDto registerUserWithExistEmail;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        registration = createRegistrationRequest("registrationEmail.email", "registrationLogin.password", "registrationFirstName.firstName", "registrationLastName.lastName");
        registerUserWithInvalidEmailFormat = createRegistrationRequest("registrationInvalidEmailFormat.email", "registrationLogin.password", "registrationFirstName.firstName", "registrationLastName.lastName");
        registerUserWithExistEmail = createRegistrationRequest("registerUserWithExistEmail.email", "registrationLogin.password", "registrationFirstName.firstName", "registrationLastName.lastName");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post(httpProperties.getProperty("registration.url"))
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    @Test
    public void registerSuccessTest() {
        ResponseDto dto = getValidatableResponse(registration,201)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void registerUserWithInvalidEmailFormatTest() {
        ErrorDto errorDto = getValidatableResponse(registerUserWithInvalidEmailFormat, 400)
                .body(containsString("Email is not valid"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }

    @Test
    public void registerUserWithExistEmailTest() {
        ErrorDto errorDto = getValidatableResponse(registerUserWithExistEmail, 422)
            .body(containsString("Email exxxxample@gmail.com already exists"))
            .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
