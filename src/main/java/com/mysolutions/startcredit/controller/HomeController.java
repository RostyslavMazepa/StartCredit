package com.mysolutions.startcredit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String homeArea(){
        return "Hello";
    }

    @GetMapping(value = "/private")
    public String privateArea(){
        return "Private";
    }
}
