package com.example.blindpersonpickerbe.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @PostMapping("/addmember")
    public String addMember(){
        return "Hello Spring";
    }

}
