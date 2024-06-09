package com.second_life.testsRA;

import com.second_life.dto.ResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogoutTest extends BaseTest {

    private ValidatableResponse getValidatableResponse(String token, int expectedStatusCode) {
        RestAssured.defaultParser = Parser.JSON;
        return (ValidatableResponse) given()
                .contentType(ContentType.JSON)
                .header(AUTH, "Bearer " + token)
                .when()
                .get(httpProperties.getProperty("logout.url"))
                .then()
                .assertThat().statusCode(expectedStatusCode)
                .extract().response().as(ResponseDto.class);
    }

    @Test
    public void successfulLogoutTest() {
        getValidatableResponse(TOKEN,200);
    }

    @Test
    public void noValidAccessTokenTest() {
        getValidatableResponse(INVALIDTOKEN, 403);
    }
}
