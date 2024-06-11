package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetLocationByIdTest extends BaseTest {
    private IdRequestDto validLocation;
    private IdRequestDto nonExistentLocation;
    private String getLocationByIdUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validLocation = createIdRequest("getLocationById.validId");
        nonExistentLocation = createIdRequest("getLocationById.nonExistId");
        getLocationByIdUrl = httpProperties.getProperty("getLocationById.url");
    }

    @Test
    public void getLocationSuccessTest() {
        ResponseDto dto = withHeaderBodyAndTokenGetResponse(validLocation, TOKEN, getLocationByIdUrl + "/" + validLocation.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getLocationWithNonExistIdTest() {
        ErrorDto errorDto = withHeaderBodyAndTokenGetResponse(nonExistentLocation, TOKEN, getLocationByIdUrl + "/" + nonExistentLocation.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
