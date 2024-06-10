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

public class ActivateOfferByIdTest extends BaseTest {
    private IdRequestDto validOffer;
    private IdRequestDto nonExistentOffer;
    private String activateOfferUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = createIdRequest("activateOfferById.validId");
        nonExistentOffer = createIdRequest("activateOfferById.nonExistId");
        activateOfferUrl = httpProperties.getProperty("activateOfferById.url");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .put(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    @Test
    public void activateOfferByIdSuccessTest() {
        ResponseDto dto = getValidatableResponse(validOffer, activateOfferUrl + "/" + validOffer.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void activateNonExistentOfferByIdTest() {
        ErrorDto errorDto = getValidatableResponse(nonExistentOffer, activateOfferUrl + "/" + nonExistentOffer.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
