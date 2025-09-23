package com.udemy.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice doing Tennis 1 hour";
    }
}
