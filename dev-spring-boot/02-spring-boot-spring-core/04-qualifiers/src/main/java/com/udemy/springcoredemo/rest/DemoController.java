package com.udemy.springcoredemo.rest;

import com.udemy.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //    define a private field for the dependency
    private Coach myCoach;

    // using Qualifier based on the classes of coach
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
        myCoach = theCoach;
    }

//    public DemoController(@Qualifier("trackCoach") Coach theCoach){
//        myCoach = theCoach;
//    }

//    public DemoController(@Qualifier("baseballCoach") Coach theCoach){
//        myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
