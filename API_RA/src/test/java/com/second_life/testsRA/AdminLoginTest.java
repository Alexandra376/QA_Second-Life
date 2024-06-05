package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.LoginRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class AdminLoginTest extends BaseTest {
    LoginRequestDto login = LoginRequestDto.builder()
            .email("admin@email.com")
            .password("Security!234")
            .build();

    @Test
    public void loginSuccessTest() {
        ResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/auth/admin/login")
                .then()
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
                .post("/auth/admin/login")
                .then()
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
                        .email("admin@email.com")
                        .password("Security!23").build())
                .post("/auth/admin/login")
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
                        .email("admine@mail.com")
                        .password("Security!234").build())
                .post("/auth/admin/login")
                .then()
                .assertThat().statusCode(400)
                .body(containsString("Admin not found"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
