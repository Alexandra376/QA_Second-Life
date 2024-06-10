package com.second_life.testsRA;

import com.second_life.dto.LocationDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllLocationsTest extends BaseTest {
    private String getAllLocationsUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        getAllLocationsUrl = httpProperties.getProperty("getAllLocations.url");
    }

    private ValidatableResponse getValidatableResponse(String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }
    @Test
    public void getAllLocationsSuccessTest() {
        List<LocationDto> dto = getValidatableResponse(getAllLocationsUrl,200)
                .extract().response().jsonPath().getList("", LocationDto.class);
        System.out.println(dto);
    }
}
