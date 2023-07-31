package com.greenmonster.communitysensor.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record CommunitySensorProperties (String welcomeMessage, String about){

}
