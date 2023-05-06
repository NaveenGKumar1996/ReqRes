package com.nawinsoft.configuration;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/qa.properties")
public interface Environment extends Config {

    @Key("baseurl")
    String baseURI();

    @DefaultValue("true")
    boolean flag();

}
