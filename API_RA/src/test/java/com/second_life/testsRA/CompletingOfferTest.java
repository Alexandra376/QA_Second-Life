package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.OfferStatusRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CompletingOfferTest extends BaseTest {
    private OfferStatusRequestDto validOffer;
    private OfferStatusRequestDto nonExistentOffer;
    private String getOfferByIdUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = offerStatus("completingOffer.id", "completingOffer.winnerBidIdKey");
        nonExistentOffer = offerStatus("completingOffer.nonExistId", "completingOffer.nonExistWinnerBidIdKey");
        getOfferByIdUrl = httpProperties.getProperty("offers.url");
    }

    @Test
    public void completingOfferSuccessTest() {
        ResponseDto dto = withBodyAndTokenPatchResponse(validOffer, ADMINTOKEN, getOfferByIdUrl + "/" + validOffer.getId() + "/start-auction", 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void completingOfferNonExistIdTest() {
        ErrorDto errorDto = withBodyAndTokenPatchResponse(nonExistentOffer, ADMINTOKEN, getOfferByIdUrl + "/" + nonExistentOffer.getId() + "/start-auction", 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
