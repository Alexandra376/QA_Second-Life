package com.second_life.testsRA;

import com.second_life.dto.EditCategoryRequestDto;
import com.second_life.dto.OfferParamsRequestDto;
import com.second_life.dto.ResponseDto;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetAllOffersTest extends BaseTest {

    private OfferParamsRequestDto validCategory;
    private String getAllOffersUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validCategory = getAllOffersRequest(
                "getAllOffers.page",
                "getAllOffers.size",
                "getAllOffers.sortBy",
                "getAllOffers.id"
        );

        getAllOffersUrl = httpProperties.getProperty("getAllOffers.url");
    }

    private ValidatableResponse getValidatableResponse(@Nullable Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto!= null? requestDto : "")
                .header(AUTH, "Bearer " + ADMINTOKEN)
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    @Test
    public void getAllOffersWithDataSuccessTest() {
        ResponseDto dto = getValidatableResponse(validCategory, getAllOffersUrl,200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
    @Test
    public void getAllOffersSuccessTest() {
        ResponseDto dto = getValidatableResponse(null, getAllOffersUrl,200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
}
