package com.second_life.testsRA;

import com.second_life.dto.ResponseDto;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminLogoutTest extends BaseTest {
    private String getAdminLogoutUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        getAdminLogoutUrl = httpProperties.getProperty("adminLogout.url");
    }
    @Test
    public void successfulLogoutTest() {
        RestAssured.defaultParser = Parser.JSON;
        withHeaderAndTokenResponse(ADMINTOKEN, getAdminLogoutUrl, 200)
            .extract().response().as(ResponseDto.class);
    }

    @Test
    public void noValidAccessTokenTest() {
        RestAssured.defaultParser = Parser.JSON;
        withHeaderAndTokenResponse(INVALIDADMINTOKEN, getAdminLogoutUrl, 403)
            .extract().response().as(Error.class);
    }
}
