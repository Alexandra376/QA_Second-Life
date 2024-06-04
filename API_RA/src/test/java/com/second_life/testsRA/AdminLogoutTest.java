package com.second_life.testsRA;

import com.second_life.ResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AdminLogoutTest extends BaseTest {
    @Test
    public void successfulLogoutTest() {
        RestAssured.defaultParser = Parser.JSON;
        given()
                .contentType(ContentType.JSON)
                .header(AUTH, "Bearer " + ADMINTOKEN)
                .when()
                .get("/auth/admin/logout")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(ResponseDto.class);
    }

    @Test
    public void noValidAccessTokenTest() {
        RestAssured.defaultParser = Parser.JSON;
        given()
                .contentType(ContentType.JSON)
                .header(AUTH, "Bearer " + INVALIDADMINTOKEN)
                .when()
                .get("/auth/admin/logout")
                .then()
                .assertThat().statusCode(403)
                .extract().response().as(ResponseDto.class);
    }
}
