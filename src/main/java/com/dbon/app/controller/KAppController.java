package com.dbon.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kapp")
public class KAppController {

    Logger logger = LoggerFactory.getLogger(KAppController.class);

    @Value("${kapp.secret1:}")
    String secret1;

    @Autowired
    private BuildProperties buildProperties;


    @GetMapping("/action")
    public String doIt(@RequestBody String input) {

        logger.info("Secret1: {}", secret1);
        return "["+buildProperties.getVersion()+"]: "+input+"!";
    }
}