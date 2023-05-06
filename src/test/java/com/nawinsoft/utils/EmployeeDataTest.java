package com.nawinsoft.utils;

import com.nawinsoft.models.Address;
import com.nawinsoft.models.Employee;
import com.nawinsoft.models.PreviousCompanies;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.nawinsoft.utils.RandomDataUtils.*;

public class EmployeeDataTest {

    private final static String path = System.getProperty("user.dir") + "/src/test/resources/TestSchema/EmployeeSchema.json";


    @SneakyThrows
    @Test
    public void employeeNameCheck() {

        var address = Address.builder()
                .setFlatNo(21)
                .setStreet("Bharathi Nagar")
                .setCity("Kovilpatti")
                .setDistrict("Tuticorin")
                .setPincode(628501)
                .setState("TamilNadu")
                .build();


        var previousExp1 = PreviousCompanies.builder()
                .companyName("Apptivo")
                .totalYOE(2F)
                .build();

        var previousExp2 = PreviousCompanies.builder()
                .companyName("Insticator")
                .totalYOE(2F)
                .build();

        var previousExp3 = PreviousCompanies.builder()
                .companyName("Piramal")
                .totalYOE(2F)
                .build();

        var employee = Employee.builder()
                .setEmpId(id())
                .setFirstName(firstName())
                .setLastName(lastName())
                .setGender('M')
                .setAge(age())
                .setPreviousExperience(List.of(previousExp1, previousExp2, previousExp3))
                .setPhoneNumber(9629930247L)
                .setIsMarried(false)
                .setAddress(address)
                .setCurrentSalary(11750.09F)
                .setSkills(List.of("Test AUtomation", "Manual Testing", "Devops"))
                .build();

        var response = APIUtils.postRequest(employee);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.header("Content-type"), ContentType.JSON);
        Assert.assertEquals(response.jsonPath().get("phoneNumber"), "");

        var deserializedObj = response.as(Employee.class);

        response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(Files.readString(Paths.get(path))));
    }

}
