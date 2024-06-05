package com.second_life.testsRA;

import com.second_life.ErrorDto;
import com.second_life.IdRequestDto;
import com.second_life.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCategoryByIdTest extends BaseTest {
    IdRequestDto getCategoryByIdTest = IdRequestDto.builder()
            .id(6).build();

    @Test
    public void getCategoryByIdSuccessTest() {
        ResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(getCategoryByIdTest)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get("/categories/3")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getCategoryByIdNonExistIdTest() {
        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(IdRequestDto.builder()
                   .id(50).build())
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get("/categories/50")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto);
    }
}
