package com.second_life.testsRA;

import com.second_life.dto.ErrorDto;
import com.second_life.dto.IdRequestDto;
import com.second_life.dto.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActivateOfferByIdTest extends BaseTest {
    private IdRequestDto validOffer;
    private IdRequestDto nonExistentOffer;
    private String activateOfferUrl;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        validOffer = createIdRequest("activateOfferById.validId");
        nonExistentOffer = createIdRequest("activateOfferById.nonExistId");
        activateOfferUrl = httpProperties.getProperty("activateOfferById.url");
    }

    @Test
    public void activateOfferByIdSuccessTest() {
        ResponseDto dto = withHeaderTokenAndBodyPutResponse(validOffer, TOKEN,activateOfferUrl + "/" + validOffer.getId(), 200)
                .extract().response().as(ResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void activateNonExistentOfferByIdTest() {
        ErrorDto errorDto = withHeaderTokenAndBodyPutResponse(nonExistentOffer, TOKEN,activateOfferUrl + "/" + nonExistentOffer.getId(), 404)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
    }
}
