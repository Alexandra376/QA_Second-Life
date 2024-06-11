package com.second_life.testsRA;

import com.second_life.dto.ResponseDto;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutTest extends BaseTest {
    private String getUserLogoutUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        getUserLogoutUrl = httpProperties.getProperty("logout.url");
    }

    @Test
    public void successfulLogoutTest() {
        RestAssured.defaultParser = Parser.JSON;
        withHeaderAndTokenResponse(TOKEN, getUserLogoutUrl, 200)
                .extract().response().as(ResponseDto.class);
    }

    @Test
    public void noValidAccessTokenTest() {
        RestAssured.defaultParser = Parser.JSON;
        withHeaderAndTokenResponse(INVALIDTOKEN, getUserLogoutUrl,403)
                .extract().response().as(Error.class);
    }
}
