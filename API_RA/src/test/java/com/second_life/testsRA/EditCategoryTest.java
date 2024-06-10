package com.second_life.testsRA;

import com.second_life.dto.EditCategoryRequestDto;
import com.second_life.dto.ErrorDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class EditCategoryTest extends BaseTest {
    private EditCategoryRequestDto validCategory;
    private EditCategoryRequestDto nonExistCategory;
    private String editCategoryUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validCategory = editCategoryRequest(
                "editCategory.id",
                "editCategory.name",
                "editCategory.description",
                "editCategory.active"
        );
        nonExistCategory = editCategoryRequest(
                "editCategory.nonExistId",
                "editCategory.name",
                "editCategory.description",
                "editCategory.active"
        );

        editCategoryUrl = httpProperties.getProperty("category.url");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + ADMINTOKEN)
                .when()
                .put(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }
    @Test
    public void editCategoryByIdSuccessTest() {
        ResponseDto dto = getValidatableResponse(validCategory, editCategoryUrl + "/" + validCategory.getId(), 200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void NonExistIdTest() {
        ErrorDto errorDto = getValidatableResponse(nonExistCategory, editCategoryUrl + "/" + nonExistCategory.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
