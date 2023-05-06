package com.nawinsoft.utils;

import com.nawinsoft.Constants.FrameworkConstant;
import com.nawinsoft.reqbuilder.RequestBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class APIUtils {

    private APIUtils() {
    }

    static Response postRequest(Object obj) {
        return RequestBuilder
                .buildPostRequest()
                .body(obj)
                .post("/employees");
    }


    static Response getRequest() {
        return given()
                .baseUri("http://localhost:3000")
                .queryParam("page", 2)
                .header("Content-type", ContentType.JSON)
                .log()
                .all()
                .get("/employees");
    }

    static Response putRequest() {
        return given()
                .baseUri("https://reqres.in")
                .header("Content-type", ContentType.JSON)
                .log()
                .all()
                .get("/api/users");
    }

    static Response deleteRequest() {
        return given()
                .baseUri("https://reqres.in")
                .header("Content-type", ContentType.JSON)
                .log()
                .all()
                .delete("/api/users");
    }

    @SneakyThrows
    static String readJSONFileAndFetchString(String filePath) {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    @SneakyThrows
    static void writeStringIntoJSONFile(String filePath, Response response) {
        Files.write(Paths.get(filePath), response.asByteArray());
    }

}
