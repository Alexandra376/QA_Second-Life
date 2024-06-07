package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetLocationByIdTest extends BaseTest {
    IdRequestDto getLocatorById = IdRequestDto.builder()
            .id(10).build();

    @Test
    public void getLocationSuccessTest() {
        ResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(getLocatorById)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get("locations/10")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getLocationWithNonExistIdTest() {
        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(IdRequestDto.builder()
                    .id(100).build())
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get("locations/100")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
