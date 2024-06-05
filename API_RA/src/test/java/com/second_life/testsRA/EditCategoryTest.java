//package com.second_life.testsRA;
//
//import com.second_life.EditCategoryRequestDto;
//import com.second_life.ResponseDto;
//import io.restassured.http.ContentType;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//
//public class EditCategoryTest extends BaseTest {
//    EditCategoryRequestDto editCategoryByIdTest = EditCategoryRequestDto.builder()
//            .id(1).build();
//
//    @Test
//    public void editCategoryByIdSuccessTest() {
//        ResponseDto dto = given()
//                .contentType(ContentType.JSON)
//                .body(editCategoryByIdTest)
//                .header(AUTH, "Bearer " + TOKEN)
//                .when()
//                .put("/categories/")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().as(ResponseDto.class);
//        System.out.println(dto);
//    }
//}
