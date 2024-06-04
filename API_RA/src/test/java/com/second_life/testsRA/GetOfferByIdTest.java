package com.second_life.testsRA;

import com.second_life.ErrorDto;
import com.second_life.IdRequestDto;
import com.second_life.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetOfferByIdTest extends BaseTest {
    IdRequestDto getOffer = IdRequestDto.builder()
            .id(4)
            .build();

    @Test
    public void getOfferByIdSuccessTest() {
        ResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(getOffer)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get("/offers/4")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getOfferByIdWithNonExistIdTest() {
        ErrorDto errordto = given()
                .contentType(ContentType.JSON)
                .body(IdRequestDto.builder()
                   .id(20).build())
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get("/offers/20")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errordto);
    }
}
