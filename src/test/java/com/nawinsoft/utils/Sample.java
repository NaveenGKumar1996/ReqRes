package com.nawinsoft.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Sample {

    private final static String reqBody = "{\n" +
            "    \"name\": \"Arvind\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";

    private final static String path = System.getProperty("user.dir") + "/src/test/resources/TestData/employee.json";

    //Using String directly bad approach
    //not recommended

    @Test
    public void postNormalWay() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(reqBody)
                .log()
                .all()
                .post("https://reqres.in/api/users");
        System.out.println(response.prettyPrint());
    }

    //Not recommended when dynamic data are there
    //It not prints the request body

    @Test
    public void postFile() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(new File(path))
                .post("https://reqres.in/api/users");
        System.out.println("Response:: " + '\n' + response.prettyPrint());
    }

    //With this approach we can log as well as replace params
    @Test
    public void postFileWithExtraFeatures() {
        String reqBody = null;
        try {
            reqBody = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Response response = given()
                .contentType(ContentType.JSON)
                .body(reqBody)
                .log()
                .all()
                .post("https://reqres.in/api/users");
        System.out.println("Response:: " + '\n' + response.prettyPrint());
    }

    // Forming POST with Map & List
    //using Jackson performing serialization
    //java object -> byte stream -> json -> Serialization
    //json -> byte stream -> java object -> Deserialization

    @Test
    public void postFileWithCollection() {
        List li = List.of("Software Tester", "Devops");
        Map map = Map.of("name", "NKRaja", "job", li);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(map)
                .log()
                .all()
                .post("https://reqres.in/api/users");
        System.out.println("Response:: " + '\n' + response.prettyPrint());
    }

    /*
    Using org json libs
    JSONObject and JSONArray class
     */

    @Test
    public void postFileWithJSONLib() {

        JSONObject student = new JSONObject();
        JSONArray marks = new JSONArray();

        marks.put(180);
        marks.put(152);

        student.put("Name", "Naveen");
        student.put("Age", 26);
        student.put("Gender", "Male");
        student.put("Marks", marks);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(student.toMap())
                .log()
                .all()
                .post("https://reqres.in/api/users");
        System.out.println("Response:: " + '\n' + response.prettyPrint());
    }


}
