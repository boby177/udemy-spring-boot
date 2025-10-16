package com.bob.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // new controller method to show initial HTML Form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML Form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
}
