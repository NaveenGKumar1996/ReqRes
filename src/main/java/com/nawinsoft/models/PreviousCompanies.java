package com.nawinsoft.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class PreviousCompanies {

    private String companyName;
    private Float totalYOE;

}
