package com.second_life.testsRA;

import com.second_life.ErrorDto;
import com.second_life.ResponseDto;
import com.second_life.UpdateOfferRequestDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateOfferTest extends BaseTest {
    UpdateOfferRequestDto updateOffer = UpdateOfferRequestDto.builder()
        .id(4)
        .title("Chair")
        .description("In a big village")
        .auctionDurationDays(3)
        .startPrice(100)
        .step(12)
        .winBid(1222)
        .isFree(false)
        .categoryId(1)
        .build();

    @Test
    public void updateOfferSuccessTest() {
        ResponseDto dto = given()
            .contentType(ContentType.JSON)
            .body(updateOffer)
            .header(AUTH, "Bearer " + TOKEN)
            .when()
            .put("/offers")
            .then()
            .assertThat().statusCode(200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void updateOfferBadRequestTest() {
        ErrorDto errorDto = given()
            .contentType(ContentType.JSON)
            .body(UpdateOfferRequestDto.builder()
                .id(4)
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
            .put("/offers")
            .then()
            .assertThat().statusCode(400)
            .extract().response().as(ErrorDto.class);
        System.out.println(errorDto);
    }
}
