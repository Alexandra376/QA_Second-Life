package com.second_life.testsRA;

import com.second_life.dto.EditCategoryRequestDto;
import com.second_life.dto.ErrorDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @Test
    public void editCategoryByIdSuccessTest() {
        ResponseDto dto = withHeaderTokenAndBodyPutResponse(validCategory, ADMINTOKEN,editCategoryUrl + "/" + validCategory.getId(), 200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void NonExistIdTest() {
        ErrorDto errorDto = withHeaderTokenAndBodyPutResponse(nonExistCategory, ADMINTOKEN,editCategoryUrl + "/" + nonExistCategory.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
