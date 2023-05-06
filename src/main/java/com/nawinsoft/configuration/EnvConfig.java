package com.nawinsoft.configuration;

import org.aeonbits.owner.ConfigFactory;

public class EnvConfig {

    private EnvConfig(){}

    private static Environment config = ConfigFactory.create(Environment.class);

    public static final String BASE_URL = config.baseURI();

    public static final boolean FLAG = config.flag();

}
