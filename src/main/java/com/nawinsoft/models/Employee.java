package com.nawinsoft.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Builder(setterPrefix = "set")
public class Employee {

    private int empId;
    private String firstName;
    private String lastName;
    private Character gender;
    private int age;
    private List<String> skills;
    private Address address;
    private boolean isMarried;
    private long phoneNumber;
    private float currentSalary;
    private List<Object> previousExperience;
}