package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.OfferStatusRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChangeOfferStatusToRejectedTest extends BaseTest {
    private OfferStatusRequestDto validOffer;
    private OfferStatusRequestDto nonExistentOffer;
    private String getOffersUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = offerStatus("changeOfferStatusToRejected.id", "changeOfferStatusToRejected.winnerBidIdKey");
        nonExistentOffer = offerStatus("changeOfferStatusToRejected.nonExistId", "changeOfferStatusToRejected.nonExistWinnerBidIdKey");
        getOffersUrl = httpProperties.getProperty("offers.url");
    }

    @Test
    public void changeOfferStatusToRejectedSuccessTest() {
        ResponseDto dto = withHeaderBodyAndTokenGetResponse(validOffer, ADMINTOKEN, getOffersUrl + "/" + validOffer.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void changeOfferStatusToRejectedNonExistIdTest() {
        ErrorDto errorDto = withHeaderBodyAndTokenGetResponse(nonExistentOffer, ADMINTOKEN, getOffersUrl + "/" + nonExistentOffer.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
