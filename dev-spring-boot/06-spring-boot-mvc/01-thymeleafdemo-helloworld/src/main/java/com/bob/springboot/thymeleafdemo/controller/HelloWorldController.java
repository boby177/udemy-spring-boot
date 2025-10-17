package com.bob.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // need a controller method to read form data
    @RequestMapping("/processFormVersion2")
    public String letShoutDude(HttpServletRequest request, Model model) {

        // Read the request params from the html form
        String theName = request.getParameter("studentName");

        // convert the data to all uppercase
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersion3")
    public String processFormVersion3(@RequestParam("studentName") String theName,
                                      Model model) {

        // convert the data to all uppercase
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey My Friend! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
