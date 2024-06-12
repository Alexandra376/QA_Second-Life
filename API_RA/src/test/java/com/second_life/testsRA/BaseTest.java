package com.second_life.testsRA;

import com.second_life.dto.*;
import com.second_life.utils.PropertiesLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.jetbrains.annotations.Nullable;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

import static com.second_life.testsRA.RegistrationTest.getRandomEmail;
import static io.restassured.RestAssured.given;

public class BaseTest {
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTg4MjExNTAsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.Stdd0S_hYz89eC14lj2g3Z9ULQ30hhQMFsuwHm63k1I";
    public static final String INVALIDTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYXJhay5vYmFtYUBlbWFpbC5jb20iLCJleHAiOjE3MTc5NjU1MDksInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJlbWFpbCI6ImJhcmFrLm9iYW1hQGVtYWlsLmNvbSJ9.BuV_Gb1LZUUmFHxLbQIHtCvW3g2B7ResQS28p86eZN";
    public static final String ADMINTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTg4MTEyMzgsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.mmp6XepnA_7p0bZbwiKxPFJdGriL15FLkA6Rv0aSfVg";
    public static final String INVALIDADMINTOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlbWFpbC5jb20iLCJleHAiOjE3MTgxMzE3MTQsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBlbWFpbC5jb20ifQ.fh3yHfxhO17vpcXrZyMtalAM2EoYQDMBXvl04Thjmo";
    public static final String AUTH = "Authorization";


    @BeforeMethod
    public void init(){
        RestAssured.baseURI = "https://second-life-app-y2el9.ondigitalocean.app/api";
        RestAssured.basePath = "v1";
    }

    ValidatableResponse withHeaderTokenAndBodyPutResponse(Object requestDto, String token, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + token)
                .when()
                .put(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    ValidatableResponse withHeaderTokenAndBodyPostResponse(Object requestDto, String token, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + token)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    ValidatableResponse withBodyResponse(Object requestDto, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    ValidatableResponse withHeaderAndTokenResponse(String token, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .header(AUTH, "Bearer " + token)
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    ValidatableResponse withHeaderTokenAndBodyDeleteResponse(Object requestDto, String token, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + token)
                .when()
                .delete(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    ValidatableResponse withHeaderBodyAndTokenGetResponse(Object requestDto, String token, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + token)
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    ValidatableResponse withBodyAndTokenPatchResponse(Object requestDto, String token, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .header(AUTH, "Bearer " + token)
                .when()
                .patch(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
    }

    ValidatableResponse withHeaderBodyAndTokenGetOptionalParamResponse(@Nullable Object requestDto, String token, String endpoint, int expectedStatusCode) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestDto!= null? requestDto : "")
                .header(AUTH, "Bearer " + token)
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(expectedStatusCode);
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
        String email = emailKey != null ? testProperties.getProperty(emailKey) : getRandomEmail();
        return RegistrationRequestDto.builder()
                .email(email)
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
                                                             String winBidKey, String isFreeKey, String categoryIdKey,
                                                             String locationIdKey, String sendToVerificationKey) {

        return CreateNewOfferRequestDto.builder()
                .title(testProperties.getProperty(titleKey))
                .description(testProperties.getProperty(descriptionKey))
                .auctionDurationDays(Integer.parseInt(testProperties.getProperty(auctionDurationDaysKey)))
                .startPrice(Integer.parseInt(testProperties.getProperty(startPriceKey)))
                .winBid(Integer.parseInt(testProperties.getProperty(winBidKey)))
                .isFree(Boolean.parseBoolean(testProperties.getProperty(isFreeKey)))
                .categoryId(Integer.parseInt(testProperties.getProperty(categoryIdKey)))
                .locationId(Integer.parseInt(testProperties.getProperty(locationIdKey)))
                .sendToVerification(Boolean.parseBoolean(testProperties.getProperty(sendToVerificationKey)))
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

    protected UpdateOfferRequestDto updateOfferRequest(String titleKey, String idKey, String descriptionKey,
                                                             String auctionDurationDaysKey, String startPriceKey,
                                                             String winBidKey, String isFreeKey, String categoryIdKey) {

        return UpdateOfferRequestDto.builder()
                .title(testProperties.getProperty(titleKey))
                .id(Integer.parseInt(testProperties.getProperty(idKey)))
                .description(testProperties.getProperty(descriptionKey))
                .auctionDurationDays(Integer.parseInt(testProperties.getProperty(auctionDurationDaysKey)))
                .startPrice(Integer.parseInt(testProperties.getProperty(startPriceKey)))
                .winBid(Integer.parseInt(testProperties.getProperty(winBidKey)))
                .isFree(Boolean.parseBoolean(testProperties.getProperty(isFreeKey)))
                .categoryId(Integer.parseInt(testProperties.getProperty(categoryIdKey)))
                .build();
    }

    protected OfferStatusRequestDto offerStatus(String idKey, String winnerBidIdKey) {
        return OfferStatusRequestDto.builder()
                .id(Integer.parseInt(testProperties.getProperty(idKey)))
                .winnerBidId(Integer.parseInt(testProperties.getProperty(winnerBidIdKey)))
                .build();
    }
}
