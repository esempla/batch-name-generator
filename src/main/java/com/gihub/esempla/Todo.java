package com.gihub.esempla;

import com.gihub.esempla.model.Rules;

import java.time.LocalDate;
import java.time.LocalTime;

public class Todo {
    public static final String TEST = "test";

    public static void main(String[] args) {


        Rules rules = Rules.builder().userId(3).userName("tele4entru")
                .jobId(1).currentDate(LocalDate.now()).currentTime(LocalTime.now()).build();

    }
}

