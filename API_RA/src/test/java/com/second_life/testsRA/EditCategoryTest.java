package com.second_life.testsRA;

import com.second_life.dto.EditCategoryRequestDto;
import com.second_life.dto.ErrorDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EditCategoryTest extends BaseTest {
    EditCategoryRequestDto editCategoryByIdTest = EditCategoryRequestDto.builder()
            .id(4)
            .name("Electronic")
            .description("Smartphones")
            .active(true).build();

    @Test
    public void editCategoryByIdSuccessTest() {
        ResponseDto dto = given()
            .contentType(ContentType.JSON)
            .body(editCategoryByIdTest)
            .header(AUTH, "Bearer " + ADMINTOKEN)
            .when()
            .put("/categories/4")
            .then()
            .assertThat().statusCode(200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void NonExistIdTest() {
        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(EditCategoryRequestDto.builder()
                        .id(100)
                        .name("Electronic")
                        .description("Smartphones")
                        .active(true).build())
                .header(AUTH, "Bearer " + ADMINTOKEN)
                .when()
                .put("/categories/100")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
