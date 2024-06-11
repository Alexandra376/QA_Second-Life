package com.second_life.testsRA;

import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeactivateOfferById extends BaseTest {

    private IdRequestDto validOffer;
    private IdRequestDto nonExistentOffer;
    private String getOfferByIdUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = createIdRequest("deactivateOfferById.validId");
        nonExistentOffer = createIdRequest("deactivateOfferById.nonExistId");
        getOfferByIdUrl = httpProperties.getProperty("offers.url");
    }

    @Test
    public void deactivateOfferByIdSuccessTest() {
        ResponseDto dto = withHeaderTokenAndBodyDeleteResponse(validOffer, TOKEN, getOfferByIdUrl + "/" + validOffer.getId(),200)
            .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void offerNotFound() {
        Error errorDto = withHeaderTokenAndBodyDeleteResponse(nonExistentOffer, TOKEN, getOfferByIdUrl + "/" + nonExistentOffer.getId(),404)
                .extract().response().as(Error.class);
        System.out.println(errorDto.getMessage());
    }
}
