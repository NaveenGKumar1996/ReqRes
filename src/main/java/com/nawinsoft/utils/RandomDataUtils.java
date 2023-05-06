package com.nawinsoft.utils;

public final class RandomDataUtils {

    private RandomDataUtils() {
    }

    public static String firstName() {
        return FakerUtils.getFirstName();
    }

    public static String lastName() {
        return FakerUtils.getLastName();
    }

    public static int id() {
        return FakerUtils.getId();
    }

    public static int age() {
        return FakerUtils.getAgeBetween(18, 70);
    }

}
