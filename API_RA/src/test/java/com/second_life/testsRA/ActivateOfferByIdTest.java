package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ActivateOfferByIdTest extends BaseTest {
    IdRequestDto activateOffer = IdRequestDto.builder()
            .id(4)
            .build();
    @Test
    public void activateOfferByIdSuccessTest() {
        ResponseDto dto = given()
            .contentType(ContentType.JSON)
            .body(activateOffer)
            .header(AUTH, "Bearer " + TOKEN)
            .when()
            .put("/offers/recover/4")
            .then()
            .assertThat().statusCode(200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void activateNonExistentOfferByIdTest() {
        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(IdRequestDto.builder()
                   .id(20).build())
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .put("/offers/recover/20")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
