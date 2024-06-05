package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.LoginRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class UserLoginTest extends BaseTest {
    LoginRequestDto login = LoginRequestDto.builder()
        .email("barak.obama@email.com")
        .password("Security!234")
        .build();

    @Test
    public void loginSuccessTest() {
        ResponseDto dto = given()
            .contentType(ContentType.JSON)
            .body(login)
            .when()
            .post("/auth/user/login")
            .then().log().all()
            .assertThat().statusCode(200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void loginSuccessTest2() {
        String responseToken = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/auth/user/login")
                .then().log().all()
                .assertThat().statusCode(200)
                .body(containsString("accessToken"))
                .extract().path("accessToken");
        System.out.println(responseToken);
    }

    @Test
    public void loginWithWrongPasswordTest() {
        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(LoginRequestDto.builder()
                .email("barak.obama@email.com")
                .password("Security!23").build())
            .post("/auth/user/login")
            .then()
            .assertThat().statusCode(401)
            .body(containsString("Password is incorrect"))
            .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }

    @Test
    public void loginWithWrongEmailTest() {
        ErrorDto errorDto = given()
                    .contentType(ContentType.JSON)
                    .body(LoginRequestDto.builder()
                    .email("barak.obamaemail.com")
                    .password("Security!234").build())
                .post("/auth/user/login")
                .then()
                .assertThat().statusCode(400)
                .body(containsString("User not found"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
