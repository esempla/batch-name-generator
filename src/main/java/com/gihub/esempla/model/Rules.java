package com.gihub.esempla.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rules {

    private long userId;
    private String userName;
    private LocalDate currentDate = LocalDate.now();
    private LocalTime currentTime =  LocalTime.now();
    private long jobId;

}
