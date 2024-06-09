package com.second_life.testsRA;

import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DeactivateOfferById extends BaseTest {

    private IdRequestDto validOffer;
    private IdRequestDto nonExistentOffer;
    private String getOfferByIdUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = createIdRequestDto("deactivateOfferById.validId");
        nonExistentOffer = createIdRequestDto("deactivateOfferById.nonExistId");
        getOfferByIdUrl = httpProperties.getProperty("getOfferById.url");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .delete(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    @Test
    public void deactivateOfferByIdSuccessTest() {
        ResponseDto dto = getValidatableResponse(validOffer, getOfferByIdUrl +  validOffer.getId(),200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void offerNotFound() {
        Error errorDto = getValidatableResponse(nonExistentOffer,getOfferByIdUrl + nonExistentOffer.getId(),404)
                .extract().response().as(Error.class);
        System.out.println(errorDto.getMessage());
    }
}
