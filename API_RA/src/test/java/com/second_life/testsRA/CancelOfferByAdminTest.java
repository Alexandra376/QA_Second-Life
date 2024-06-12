package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CancelOfferByAdminTest extends BaseTest {
    private IdRequestDto validOffer;
    private IdRequestDto nonExistentOffer;
    private String getOffersUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = createIdRequest("cancelOfferByAdmin.id");
        nonExistentOffer = createIdRequest("cancelOfferByAdmin.nonExistId");
        getOffersUrl = httpProperties.getProperty("offers.url");
    }

    @Test
    public void сancelOfferByAdminSuccessTest() {
        ResponseDto dto = withHeaderTokenAndBodyDeleteResponse(validOffer, ADMINTOKEN, getOffersUrl + "/" + validOffer.getId() + "/block-by-admin", 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void сancelOfferByAdminNonExistIdTest() {
        ErrorDto errorDto = withHeaderTokenAndBodyDeleteResponse(nonExistentOffer, ADMINTOKEN, getOffersUrl + "/" + nonExistentOffer.getId() + "/block-by-admin", 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
