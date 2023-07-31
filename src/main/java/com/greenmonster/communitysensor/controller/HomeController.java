package com.greenmonster.communitysensor.controller;

import com.greenmonster.communitysensor.config.CommunitySensorProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    /**
     Example of getting configuration from application.properties

    @Value("${cc.welcomeMessage: Default Welcome Message}")
    private String welcomeMessage;

    @Value("${cc.about}")
    private String about;
    */

    private final CommunitySensorProperties communitySensorProperties;

    public HomeController(CommunitySensorProperties communitySensorProperties) {
        this.communitySensorProperties = communitySensorProperties;
    }

    @GetMapping("/")
    public CommunitySensorProperties home() {
        return communitySensorProperties;
    }
}
