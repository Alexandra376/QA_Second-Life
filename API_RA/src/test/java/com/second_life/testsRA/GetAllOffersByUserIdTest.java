package com.second_life.testsRA;

import com.second_life.dto.OfferParamsRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAllOffersByUserIdTest extends BaseTest {
    private OfferParamsRequestDto validCategory;
    private String getOffersByUserByIdUrl;
    private String getAllOffersUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validCategory = getAllOffersRequest(
                "getAllOffersByUser.page",
                "getAllOffersByUser.size",
                "getAllOffersByUser.sortBy",
                "getAllOffersByUser.id"
        );

        getOffersByUserByIdUrl = httpProperties.getProperty("getOffersByUserById.url");
        getAllOffersUrl = httpProperties.getProperty("getAllOffers.url");
    }

    @Test
    public void getAllOffersByUserIdWithDataSuccessTest() {
        ResponseDto dto = withHeaderBodyAndTokenGetResponse(validCategory, ADMINTOKEN, getAllOffersUrl, 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getAllOffersByUserIdSuccessTest() {
        ResponseDto dto = withHeaderBodyAndTokenGetResponse(validCategory.getId(), ADMINTOKEN,getOffersByUserByIdUrl + "/" + validCategory.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }
}
