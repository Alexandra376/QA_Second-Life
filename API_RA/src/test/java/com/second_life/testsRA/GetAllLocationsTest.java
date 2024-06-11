package com.second_life.testsRA;

import com.second_life.dto.LocationDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class GetAllLocationsTest extends BaseTest {
    private String getAllLocationsUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        getAllLocationsUrl = httpProperties.getProperty("getAllLocations.url");
    }

    @Test
    public void getAllLocationsSuccessTest() {
        List<LocationDto> dto = withHeaderAndTokenResponse(TOKEN, getAllLocationsUrl, 200)
                .extract().response().jsonPath().getList("", LocationDto.class);
        System.out.println(dto);
    }
}
