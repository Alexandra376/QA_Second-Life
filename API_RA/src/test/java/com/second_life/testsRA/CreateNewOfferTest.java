package com.second_life.testsRA;

import com.second_life.dto.CreateNewOfferRequestDto;
import com.second_life.dto.ResponseDto;
import com.second_life.dto.ErrorDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CreateNewOfferTest extends BaseTest {
    private CreateNewOfferRequestDto validInformation;
    private CreateNewOfferRequestDto  badRequestInformation;
    private String createNewOfferUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validInformation = createNewOfferRequest(
                "createNewOffer.title",
                "createNewOffer.description",
                "createNewOffer.auctionDurationDays",
                "createNewOffer.startPrice",
                "createNewOffer.step",
                "createNewOffer.winBid",
                "createNewOffer.isFree",
                "createNewOffer.categoryId",
                "createNewOffer.locationId"
        );
        badRequestInformation = createNewOfferRequest(
                "createNewOffer.title",
                "createNewOffer.description",
                "createNewOffer.auctionDurationDays",
                "createNewOffer.startPrice",
                "createNewOffer.step",
                "createNewOffer.winBid",
                "createNewOffer.isFreeBadRequest",
                "createNewOffer.categoryIdBadRequest",
                "createNewOffer.locationId"
        );
        createNewOfferUrl = httpProperties.getProperty("offers.url");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    @Test
    public void createNewOfferSuccessTest() {
        ResponseDto dto = getValidatableResponse(validInformation, createNewOfferUrl,201)
        .extract().response().as(ResponseDto.class);
    System.out.println(dto);
    }

    @Test
    public void createNewOfferBadRequestTest() {
        ErrorDto errorDto = getValidatableResponse(badRequestInformation, createNewOfferUrl,400)
            .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
