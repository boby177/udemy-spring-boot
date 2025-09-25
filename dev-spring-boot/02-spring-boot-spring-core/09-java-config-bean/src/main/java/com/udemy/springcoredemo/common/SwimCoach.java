package com.udemy.springcoredemo.common;

// We don't need to setup component again, we can using config bean
public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
