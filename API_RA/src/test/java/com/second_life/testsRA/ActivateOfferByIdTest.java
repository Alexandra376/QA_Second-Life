package com.second_life.testsRA;

import com.second_life.IdRequestDto;
import com.second_life.ResponseDto;
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
            .header("Authorization", "Bearer " + TOKEN)
            .when()
            .put("/offers/recover/4")
            .then()
            .assertThat().statusCode(200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
}
