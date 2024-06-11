package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @Test
    public void getCategoryByIdSuccessTest() {
        ResponseDto dto = withHeaderBodyAndTokenGetResponse(validCategory, TOKEN,getCategoryById + "/" + validCategory.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getCategoryByIdNonExistIdTest() {
        ErrorDto errorDto = withHeaderBodyAndTokenGetResponse(nonExistentCategory, TOKEN,getCategoryById + "/" + nonExistentCategory.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto);
    }
}
