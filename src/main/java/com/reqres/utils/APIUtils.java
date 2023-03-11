package com.reqres.utils;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIUtils {

    private APIUtils(){
    }

    static Response getRequest() {
        return given()
                .baseUri("")
                .get("https://reqres.in");
    }

    static Response postRequest() {

        String payLoad = "";

        Response response = given()
                .baseUri("http://localhost:8000/")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(payLoad)
                .post("/employees");
        response.prettyPrint();

        return response;
    }


}
