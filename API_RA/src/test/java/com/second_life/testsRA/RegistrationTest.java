package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.RegistrationRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class RegistrationTest extends BaseTest {
    RegistrationRequestDto registration = RegistrationRequestDto.builder()
        .email("exxxample@gmail.com")
        .password("p@ssw0rd123")
        .firstName("Alex")
        .lastName("Laurentius")
        .build();

    @Test
    public void registerSuccessTest() {
        ResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(registration)
                .when()
                .post("/users/register")
                .then()
                .assertThat().statusCode(201)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void registerUserWithInvalidEmailFormatTest() {
        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(RegistrationRequestDto.builder()
                        .firstName("Luna")
                        .lastName("Klein")
                        .email("noextrasanytime.com")
                        .password("secure#passw0rd").build())
                .post("/users/register")
                .then()
                .assertThat().statusCode(400)
                .body(containsString("Email is not valid"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }

    @Test
    public void registerUserWithExistEmailTest() {
        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(RegistrationRequestDto.builder()
                .firstName("Bella")
                .lastName("Leo")
                .email("example@gmail.com")
                .password("secure#passw0rd").build())
            .post("/users/register")
            .then()
            .assertThat().statusCode(422)
            .body(containsString("Email example@gmail.com already exists"))
            .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }

    @Test
    public void registerUserWithEmptyStringTest() {
        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(RegistrationRequestDto.builder()
                        .firstName("")
                        .lastName("Leo")
                        .email("example@gmail.com")
                        .password("secure#passw0rd").build())
                .post("/users/register")
                .then()
                .assertThat().statusCode(400)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
