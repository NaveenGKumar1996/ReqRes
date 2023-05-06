package com.nawinsoft.constants;

import lombok.Getter;

import java.util.Objects;

@Getter
public class FrameworkConstant {

    private static FrameworkConstant frameworkInstance = null;

    private FrameworkConstant() {
    }

    public static FrameworkConstant getFrameworkInstance() {
        if (Objects.isNull(frameworkInstance)) {
            frameworkInstance = new FrameworkConstant();
        }
        return frameworkInstance;
    }

    private static final String mainResource = "src/main/resources";
    private static final String testResource = "src/test/resources";
    private static final String reqestJSONPath = mainResource + "/TestData";
    private static final String responseJSONPath = testResource + "/TestData";
}
