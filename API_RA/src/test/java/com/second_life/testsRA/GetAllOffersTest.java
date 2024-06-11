package com.second_life.testsRA;

import com.second_life.dto.OfferParamsRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAllOffersTest extends BaseTest {

    private OfferParamsRequestDto validCategory;
    private String getAllOffersUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validCategory = getAllOffersRequest(
                "getAllOffers.page",
                "getAllOffers.size",
                "getAllOffers.sortBy",
                "getAllOffers.id"
        );

        getAllOffersUrl = httpProperties.getProperty("getAllOffers.url");
    }

    @Test
    public void getAllOffersWithDataSuccessTest() {
        ResponseDto dto = withHeaderBodyAndTokenGetOptionalParamResponse(validCategory, ADMINTOKEN, getAllOffersUrl,200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
    @Test
    public void getAllOffersSuccessTest() {
        ResponseDto dto = withHeaderBodyAndTokenGetOptionalParamResponse(null, ADMINTOKEN, getAllOffersUrl,200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
}
