package com.second_life.testsRA;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTc3ODE5NjAsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.U1WJljvP0RpeG3U3GVWc-4-t3e-nQMzAgly-uxOcMgA";

    public static final String LOGIN = "Login";
    public static final String REGISTRATION = "Registration";
    public static final String LOGOUT = "Logout";

    @BeforeMethod
    public void init(){
        RestAssured.baseURI = "https://second-life-app-y2el9.ondigitalocean.app/api";
        RestAssured.basePath = "v1";
    }
}
