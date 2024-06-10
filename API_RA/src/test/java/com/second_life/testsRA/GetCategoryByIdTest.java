package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetCategoryByIdTest extends BaseTest {
    private IdRequestDto validCategory;
    private IdRequestDto nonExistentCategory;
    private String getCategoryById;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validCategory = createIdRequest("getCategoryById.validId");
        nonExistentCategory = createIdRequest("getCategoryById.nonExistId");
        getCategoryById = httpProperties.getProperty("category.url");
    }

    private ValidatableResponse getValidatableResponse(Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    @Test
    public void getCategoryByIdSuccessTest() {
        ResponseDto dto = getValidatableResponse(validCategory, getCategoryById + "/" + validCategory.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getCategoryByIdNonExistIdTest() {
        ErrorDto errorDto = getValidatableResponse(nonExistentCategory, getCategoryById + "/" + nonExistentCategory.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto);
    }
}
