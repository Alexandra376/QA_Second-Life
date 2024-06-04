package com.second_life.testsRA;

import com.second_life.CreateNewOfferRequestDto;
import com.second_life.ResponseDto;
import com.second_life.ErrorDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateNewOfferTest extends BaseTest {
    CreateNewOfferRequestDto createOffer = CreateNewOfferRequestDto.builder()
        .title("Upholstered chair")
        .description("In a small village")
        .auctionDurationDays(3)
        .startPrice(100)
        .step(12)
        .winBid(1222)
        .isFree(false)
        .categoryId(1)
        .build();

    @Test
    public void createNewOfferSuccessTest() {
        ResponseDto dto = given()
        .contentType(ContentType.JSON)
        .body(createOffer)
        .header(AUTH, "Bearer " + TOKEN)
        .when()
        .post("/offers")
        .then()
        .assertThat().statusCode(201)
        .extract().response().as(ResponseDto.class);
    System.out.println(dto);
    }

    @Test
    public void createNewOfferBadRequestTest() {
        ErrorDto errorDto = given()
            .contentType(ContentType.JSON)
            .body(CreateNewOfferRequestDto.builder()
                .title("Upholstered chair")
                .description("In a small village")
                .auctionDurationDays(3)
                .startPrice(100)
                .step(12)
                .winBid(1222)
                .isFree(true)
                .categoryId(1).build())
            .header(AUTH, "Bearer " + TOKEN)
            .when()
            .post("/offers")
            .then()
            .assertThat().statusCode(400)
            .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
