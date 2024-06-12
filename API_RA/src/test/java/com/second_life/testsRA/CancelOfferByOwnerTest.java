package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CancelOfferByOwnerTest extends BaseTest {
    private IdRequestDto validOffer;
    private IdRequestDto nonExistentOffer;
    private String getOffersUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = createIdRequest("cancelOfferByOwner.id");
        nonExistentOffer = createIdRequest("cancelOfferByOwner.nonExistId");
        getOffersUrl = httpProperties.getProperty("offers.url");
    }

    @Test
    public void cancelOfferByOwnerSuccessTest() {
        ResponseDto dto = withHeaderTokenAndBodyDeleteResponse(validOffer, TOKEN, getOffersUrl + "/" + validOffer.getId() + "/cancel", 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void cancelOfferByOwnerNonExistIdTest() {
        ErrorDto errorDto = withHeaderTokenAndBodyDeleteResponse(nonExistentOffer, TOKEN, getOffersUrl + "/" + nonExistentOffer.getId() + "/cancel", 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
