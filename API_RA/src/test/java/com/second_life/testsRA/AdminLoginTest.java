package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.LoginRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class AdminLoginTest extends BaseTest {
    private LoginRequestDto login;
    private LoginRequestDto wrongPasswordLogin;
    private LoginRequestDto wrongEmailLogin;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        login = createLoginRequest("adminLogin.email", "adminLogin.password");
        wrongPasswordLogin = createLoginRequest("adminLogin.email", "wrongAdminLogin.password");
        wrongEmailLogin = createLoginRequest("wrongAdminLogin.email", "adminLogin.password");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post(httpProperties.getProperty("adminLogin.url"))
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    @Test
    public void loginSuccessTest() {
        ResponseDto dto = getValidatableResponse(login, 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void loginSuccessTest2() {
        String responseToken = getValidatableResponse(login, 200)
                .body(containsString("accessToken"))
                .extract().path("accessToken");
        System.out.println(responseToken);
    }

    @Test
    public void loginWithWrongPasswordTest() {
        ErrorDto errorDto = getValidatableResponse(wrongPasswordLogin, 401)
                .body(containsString("Password is incorrect"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }

    @Test
    public void loginWithWrongEmailTest() {
        ErrorDto errorDto =  getValidatableResponse(wrongEmailLogin, 400)
                .body(containsString("Admin not found"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
