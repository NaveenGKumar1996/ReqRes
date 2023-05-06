package com.nawinsoft.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private static final Faker faker = new Faker();

    private FakerUtils() {}

    static String getFirstName() {
        return faker.name().firstName();
    }

    static String getLastName() {
        return faker.name().lastName();
    }

    static int getAgeBetween(int minAge, int maxAge) {
        return faker.number().numberBetween(minAge, maxAge);
    }

    static int getId() {
        return faker.number().numberBetween(999, 9999);
    }
}
