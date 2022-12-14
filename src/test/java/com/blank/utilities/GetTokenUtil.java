package com.blank.utilities;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class GetTokenUtil {

    public static String getAccessToken(String email, String password){

        String accessToken = given().accept(ContentType.JSON)
                .and().queryParams("email", email,
                        "password",password)
                .when().get("BaseURL"+ "/sign")
                .then().statusCode(200)
                .and().extract().body().path("accessToken");
        System.out.println("accessToken = " + accessToken);
        return "Bearer " + accessToken;
    }

}
