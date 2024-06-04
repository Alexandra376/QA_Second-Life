package com.second_life.testsRA;

import com.second_life.OfferParamsRequestDto;
import com.second_life.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllOffersTest extends BaseTest {
    OfferParamsRequestDto getAllOffers = OfferParamsRequestDto.builder()
            .page(3)
            .size(4)
            .sortBy("sortBy")
            .id(4).build();

    @Test
    public void getAllOffersWithDataSuccessTest() {
        ResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(getAllOffers)
                .when()
                .get("/offers/all")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
    @Test
    public void getAllOffersSuccessTest() {
        ResponseDto dto = given()
            .contentType(ContentType.JSON)
            .header(AUTH, "Bearer " + TOKEN)
            .when()
            .get("/offers/all")
            .then()
            .assertThat().statusCode(200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
}
