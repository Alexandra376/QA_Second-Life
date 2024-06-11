package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.LoginRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.core.StringContains.containsString;

public class UserLoginTest extends BaseTest {
    private LoginRequestDto login;
    private LoginRequestDto wrongPasswordLogin;
    private LoginRequestDto wrongEmailLogin;
    private String userLoginUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        login = createLoginRequest("userLogin.email", "userLogin.password");
        wrongPasswordLogin = createLoginRequest("userLogin.email", "wrongUserLogin.password");
        wrongEmailLogin = createLoginRequest("wrongUserLogin.email", "userLogin.password");
        userLoginUrl = httpProperties.getProperty("userLogin.url");
    }

    @Test
    public void loginSuccessTest() {
        ResponseDto dto = withBodyResponse(login, userLoginUrl, 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void loginSuccessTest2() {
        String responseToken = withBodyResponse(login, userLoginUrl, 200)
                .body(containsString("accessToken"))
                .extract().path("accessToken");
        System.out.println(responseToken);
    }

    @Test
    public void loginWithWrongPasswordTest() {
        ErrorDto errorDto = withBodyResponse(wrongPasswordLogin, userLoginUrl, 401)
                .body(containsString("Password is incorrect"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }

    @Test
    public void loginWithWrongEmailTest() {
        ErrorDto errorDto = withBodyResponse(wrongEmailLogin, userLoginUrl, 400)
                .body(containsString("User not found"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
