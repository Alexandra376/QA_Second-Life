package com.second_life.testsRA;

import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeactivateOfferById extends BaseTest {
    IdRequestDto deactivateOffer = IdRequestDto.builder()
            .id(10).build();

    @Test
    public void deactivateOfferByIdSuccessTest() {
        ResponseDto dto = given()
        .contentType(ContentType.JSON)
        .body(deactivateOffer)
        .header(AUTH, "Bearer " + TOKEN)
        .when()
        .delete("offers/10")
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
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .delete("offers/1")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(Error.class);
        System.out.println(errorDto.getMessage());
    }
}
