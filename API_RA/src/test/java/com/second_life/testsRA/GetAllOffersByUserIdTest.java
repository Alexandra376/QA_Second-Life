package com.second_life.testsRA;

import com.second_life.IdRequestDto;
import com.second_life.OfferParamsRequestDto;
import com.second_life.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllOffersByUserIdTest extends BaseTest {
    OfferParamsRequestDto getAllOffersByUserId = OfferParamsRequestDto.builder()
            .page(2)
            .size(5)
            .sortBy("sortBy")
            .id(4).build();

    @Test
    public void getAllOffersByUserIdWithDataSuccessTest() {
        ResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(getAllOffersByUserId)
                .when()
                .get("/offers/all")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getAllOffersByUserIdSuccessTest() {
        ResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(OfferParamsRequestDto.builder()
                        .id(4).build())
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .get("/offers/user/4")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
}
