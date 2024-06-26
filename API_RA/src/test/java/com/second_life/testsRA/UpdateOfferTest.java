package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.ResponseDto;
import com.second_life.dto.UpdateOfferRequestDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateOfferTest extends BaseTest {
    private UpdateOfferRequestDto validInformation;
    private UpdateOfferRequestDto invalidInput;
    private UpdateOfferRequestDto offerNotFound;
    private UpdateOfferRequestDto unprocessableEntityInformation;
    private String updateOfferUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validInformation = updateOfferRequest(
                "updateOffer.title",
                "updateOffer.id",
                "updateOffer.description",
                "updateOffer.auctionDurationDays",
                "updateOffer.startPrice",
                "updateOffer.winBid",
                "updateOffer.isFree",
                "updateOffer.categoryId"
        );
        invalidInput = updateOfferRequest(
                "updateOffer.title",
                "updateOffer.id",
                "updateOffer.description",
                "updateOffer.auctionDurationDays",
                "updateOffer.startPrice",
                "updateOffer.winBid",
                "updateOffer.isFreeInvalidInput",
                "updateOffer.categoryId"
        );
        offerNotFound = updateOfferRequest(
                "updateOffer.title",
                "updateOffer.idInvalid",
                "updateOffer.description",
                "updateOffer.auctionDurationDays",
                "updateOffer.startPrice",
                "updateOffer.winBid",
                "updateOffer.isFreeInvalidInput",
                "updateOffer.categoryId"
        );
        unprocessableEntityInformation = updateOfferRequest(
                "updateOffer.title",
                "updateOffer.id",
                "updateOffer.description",
                "updateOffer.auctionDurationDays",
                "updateOffer.startPriceUnprocessableEntity",
                "updateOffer.winBid",
                "updateOffer.isFree",
                "updateOffer.categoryId"
        );
        updateOfferUrl = httpProperties.getProperty("offers.url");
    }

    @Test
    public void updateOfferSuccessTest() {
        ResponseDto dto = withHeaderTokenAndBodyPutResponse(validInformation, TOKEN, updateOfferUrl, 200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void updateOfferInvalidInputTest() {
        ErrorDto errorDto = withHeaderTokenAndBodyPutResponse(invalidInput, TOKEN, updateOfferUrl,400)
            .extract().response().as(ErrorDto.class);
        System.out.println(errorDto);
    }

    @Test
    public void updateOfferNotFoundTest() {
        ErrorDto errorDto = withHeaderTokenAndBodyPutResponse(offerNotFound, TOKEN, updateOfferUrl,404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto);
    }

    @Test
    public void updateOfferUnprocessableEntityTest() {
        ErrorDto errorDto = withHeaderTokenAndBodyPutResponse(unprocessableEntityInformation, TOKEN, updateOfferUrl,422)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto);
    }
}
