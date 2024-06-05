package com.second_life.testsRA;

import com.second_life.dto.LoginRequestDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class BaseTest {
    public static String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTgyMDcyNjAsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.FZBGFeUDqBGplOR9iWvBuurlp2oNkuI6hSyjTdFQrfs";
    public static final String INVALIDTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTc5NjU1MDksInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.BuV_Gb1LZUUmFHxLbQIHtCvW3g2B7ResQS28p86eZN";
    public static final String ADMINTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTgxMzE3MTQsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.fh3yHfxhO17vpcXrZyMtalAM2EoYQDMBXvl04Thjmo0";
    public static final String INVALIDADMINTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTgxMzE3MTQsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.fh3yHfxhO17vpcXrZyMtalAM2EoYQDMBXvl04Thjmo";
    public static final String AUTH = "Authorization";


    @BeforeMethod
    public void init(){
        RestAssured.baseURI = "https://second-life-app-y2el9.ondigitalocean.app/api";
        RestAssured.basePath = "v1";
    }

    @BeforeSuite
    public void setToken() {
        LoginRequestDto login = LoginRequestDto.builder()
                .email("barak.obama@email.com")
                .password("Security!234")
                .build();

        TOKEN  = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/auth/user/login")
                .then().log().all()
                .assertThat().statusCode(200)
                .body(containsString("accessToken"))
                .extract().path("accessToken");
    }
}
