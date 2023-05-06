package com.nawinsoft.reqbuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestBuilder {

    private RequestBuilder() {
    }

    public static RequestSpecification basicBuilder() {
        return given()
                .baseUri("")
                .log()
                .all();
    }

    public static RequestSpecification buildPostRequest() {
        return basicBuilder()
                .header("Content-type", ContentType.JSON);
    }

    public static RequestSpecification buildGetRequest() {
        return basicBuilder()
                .contentType(ContentType.JSON);
    }
}
