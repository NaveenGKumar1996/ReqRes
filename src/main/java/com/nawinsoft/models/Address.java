package com.nawinsoft.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder(setterPrefix = "set")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Address {

    private int flatNo;
    private String street;
    private String city;
    private String district;
    private String state;
    private int pincode;

}
