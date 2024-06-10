package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetOfferByIdTest extends BaseTest {

    private IdRequestDto validOffer;
    private IdRequestDto nonExistentOffer;
    private String getOfferByIdUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = createIdRequest("getOfferById.validId");
        nonExistentOffer = createIdRequest("getOfferById.nonExistId");
        getOfferByIdUrl = httpProperties.getProperty("offers.url");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    @Test
    public void getOfferByIdSuccessTest() {
        ResponseDto dto = getValidatableResponse(validOffer, getOfferByIdUrl + "/" + validOffer.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getOfferByIdWithNonExistIdTest() {
        ErrorDto errordto = getValidatableResponse(nonExistentOffer, getOfferByIdUrl + "/" + nonExistentOffer.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errordto);
    }
}
