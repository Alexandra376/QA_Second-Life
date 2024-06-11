package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetOfferByIdTest extends BaseTest {
    private IdRequestDto validOffer;
    private IdRequestDto nonExistentOffer;
    private String getOfferByIdUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = createIdRequest("getOfferById.validId");
        nonExistentOffer = createIdRequest("getOfferById.nonExistId");
        getOfferByIdUrl = httpProperties.getProperty("offers.url");
    }

    @Test
    public void getOfferByIdSuccessTest() {
        ResponseDto dto = withHeaderBodyAndTokenGetResponse(validOffer, TOKEN, getOfferByIdUrl + "/" + validOffer.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void getOfferByIdWithNonExistIdTest() {
        ErrorDto errordto = withHeaderBodyAndTokenGetResponse(nonExistentOffer, TOKEN,getOfferByIdUrl + "/" + nonExistentOffer.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errordto);
    }
}
