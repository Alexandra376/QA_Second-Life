package com.second_life.testsRA;

import com.second_life.dto.LoginRequestDto;
import com.second_life.utils.PropertiesLoader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTgyMDcyNjAsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.FZBGFeUDqBGplOR9iWvBuurlp2oNkuI6hSyjTdFQrfs";
    public static final String INVALIDTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTc5NjU1MDksInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.BuV_Gb1LZUUmFHxLbQIHtCvW3g2B7ResQS28p86eZN";
    public static final String ADMINTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTgxMzE3MTQsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.fh3yHfxhO17vpcXrZyMtalAM2EoYQDMBXvl04Thjmo0";
    public static final String INVALIDADMINTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTgxMzE3MTQsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.fh3yHfxhO17vpcXrZyMtalAM2EoYQDMBXvl04Thjmo";
    public static final String AUTH = "Authorization";


    @BeforeMethod
    public void init(){
        RestAssured.baseURI = "https://second-life-app-y2el9.ondigitalocean.app/api";
        RestAssured.basePath = "v1";
    }

    protected Properties testProperties;
    protected Properties httpProperties;

    @BeforeClass
    public void setUp() throws IOException {
        PropertiesLoader.getInstance();
        testProperties = PropertiesLoader.getTestProperties();
        httpProperties = PropertiesLoader.getHttpProperties();
    }

    protected LoginRequestDto createLoginRequest(String emailKey, String passwordKey) {
        return LoginRequestDto.builder()
                .email(testProperties.getProperty(emailKey))
                .password(testProperties.getProperty(passwordKey))
                .build();
    }
}
