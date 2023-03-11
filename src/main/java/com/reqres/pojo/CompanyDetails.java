package com.reqres.pojo;

public class CompanyDetails {

    private String companyName;
    private int companyNumber;


    public CompanyDetails(String companyName, int companyNumber) {
        this.companyName = companyName;
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

}
