package com.second_life.testsRA;

import com.second_life.IdRequestDto;
import com.second_life.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeactivateOfferById extends BaseTest {
    IdRequestDto deactivateOffer = IdRequestDto.builder()
            .id(2).build();

    @Test
    public void deactivateOfferByIdSuccessTest() {
        ResponseDto dto = given()
        .contentType(ContentType.JSON)
        .body(deactivateOffer)
        .header("Authorization", "Bearer " + TOKEN)
        .when()
        .delete("offers/2")
            .then()
            .assertThat().statusCode(200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void offerNotFound() {
        Error errorDto = given()
                .contentType(ContentType.JSON)
                .body(IdRequestDto.builder()
                        .id(3).build())
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .delete("offers/1")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(Error.class);
        System.out.println(errorDto.getMessage());
    }
}
