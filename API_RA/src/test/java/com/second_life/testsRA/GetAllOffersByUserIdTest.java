package com.second_life.testsRA;

import com.second_life.dto.OfferParamsRequestDto;
import com.second_life.dto.ResponseDto;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetAllOffersByUserIdTest extends BaseTest {
    private OfferParamsRequestDto validCategory;
    private String getOffersByUserByIdUrl;
    private String getAllOffersUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validCategory = getAllOffersRequest(
                "getAllOffersByUser.page",
                "getAllOffersByUser.size",
                "getAllOffersByUser.sortBy",
                "getAllOffersByUser.id"
        );

        getOffersByUserByIdUrl = httpProperties.getProperty("getOffersByUserById.url");
        getAllOffersUrl = httpProperties.getProperty("getAllOffers.url");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + ADMINTOKEN)
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    @Test
    public void getAllOffersByUserIdWithDataSuccessTest() {
        ResponseDto dto = getValidatableResponse(validCategory, getAllOffersUrl, 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getAllOffersByUserIdSuccessTest() {
        ResponseDto dto = getValidatableResponse(validCategory.getId(), getOffersByUserByIdUrl + "/" + validCategory.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
}
