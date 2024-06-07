package com.second_life.testsRA;

import com.second_life.dto.LocationDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllLocationsTest extends BaseTest {
    @Test
    public void getAllLocationsSuccessTest() {
        List<LocationDto> dto = given()
                .contentType(ContentType.JSON)
                .header(AUTH, "Bearer " + TOKEN)
                .when()
                .get("/locations")
                .then()
                .assertThat().statusCode(200)
                .extract().response().jsonPath().getList("", LocationDto.class);
        System.out.println(dto);
    }
}
