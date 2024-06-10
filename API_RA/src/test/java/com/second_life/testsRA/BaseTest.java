package com.second_life.testsRA;

import com.second_life.dto.*;
import com.second_life.utils.PropertiesLoader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTgyMDcyNjAsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.FZBGFeUDqBGplOR9iWvBuurlp2oNkuI6hSyjTdFQrfs";
    public static final String INVALIDTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTc5NjU1MDksInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.BuV_Gb1LZUUmFHxLbQIHtCvW3g2B7ResQS28p86eZN";
    public static final String ADMINTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTgxMzE3MTQsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.fh3yHfxhO17vpcXrZyMtalAM2EoYQDMBXvl04Thjmo0";
    public static final String INVALIDADMINTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTgxMzE3MTQsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.fh3yHfxhO17vpcXrZyMtalAM2EoYQDMBXvl04Thjmo";
    public static final String AUTH = "Authorization";


    @BeforeMethod
    public void init(){
        RestAssured.baseURI = "https://second-life-app-y2el9.ondigitalocean.app/api";
        RestAssured.basePath = "v1";
    }

    protected Properties testProperties;
    protected Properties httpProperties;

    @BeforeClass
    public void setUp() throws IOException {
        PropertiesLoader.getInstance();
        testProperties = PropertiesLoader.getTestProperties();
        httpProperties = PropertiesLoader.getHttpProperties();
    }

    protected LoginRequestDto createLoginRequest(String emailKey, String passwordKey) {
        return LoginRequestDto.builder()
                .email(testProperties.getProperty(emailKey))
                .password(testProperties.getProperty(passwordKey))
                .build();
    }

    protected RegistrationRequestDto createRegistrationRequest(String emailKey, String passwordKey,
                                                               String firstNameKey, String lastNameKey) {
        return RegistrationRequestDto.builder()
                .email(testProperties.getProperty(emailKey))
                .password(testProperties.getProperty(passwordKey))
                .firstName(testProperties.getProperty(firstNameKey))
                .lastName(testProperties.getProperty(lastNameKey))
                .build();
    }

    protected IdRequestDto createIdRequest(String idKey) {
        int id = Integer.parseInt(testProperties.getProperty(idKey));
        return IdRequestDto.builder()
                .id(id)
                .build();
    }

    protected CreateNewOfferRequestDto createNewOfferRequest(String titleKey, String descriptionKey,
                                                             String auctionDurationDaysKey, String startPriceKey,
                                                             String stepKey, String winBidKey, String isFreeKey,
                                                             String categoryIdKey, String locationIdKey) {

        return CreateNewOfferRequestDto.builder()
                .title(testProperties.getProperty(titleKey))
                .description(testProperties.getProperty(descriptionKey))
                .auctionDurationDays(Integer.parseInt(testProperties.getProperty(auctionDurationDaysKey)))
                .startPrice(Integer.parseInt(testProperties.getProperty(startPriceKey)))
                .step(Integer.parseInt(testProperties.getProperty(stepKey)))
                .winBid(Integer.parseInt(testProperties.getProperty(winBidKey)))
                .isFree(Boolean.parseBoolean(testProperties.getProperty(isFreeKey)))
                .categoryId(Integer.parseInt(testProperties.getProperty(categoryIdKey)))
                .locationId(Integer.parseInt(testProperties.getProperty(locationIdKey)))
                .build();
    }

    protected EditCategoryRequestDto editCategoryRequest(String idKey, String nameKey,
                                                           String descriptionKey, String activeKey) {

        return EditCategoryRequestDto.builder()
                .id(Integer.parseInt(testProperties.getProperty(idKey)))
                .name(testProperties.getProperty(nameKey))
                .description(testProperties.getProperty(descriptionKey))
                .active(Boolean.parseBoolean(testProperties.getProperty(activeKey)))
                .build();
    }

    protected OfferParamsRequestDto getAllOffersRequest(String pageKey, String sizeKey,
                                                         String sortByKey, String idKey) {

        return OfferParamsRequestDto.builder()
                .page(Integer.parseInt(testProperties.getProperty(pageKey)))
                .size(Integer.parseInt(testProperties.getProperty(sizeKey)))
                .sortBy(testProperties.getProperty(sortByKey))
                .id(Integer.parseInt(testProperties.getProperty(idKey)))
                .build();
    }
}
