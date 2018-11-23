package com.gihub.esempla.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rules {

    private static final String USER_ID = "$UserID";
    private static final String USER_NAME = "$UserName";
    private static final String CURRENT_DATE = "$CurrentDate";
    private static final String CURRENT_TIME = "$CurrentTime";
    private static final String JOB_ID = "$JobID";

    private String userId;
    private String userName;
    private String currentDate;
    private String currentTime;
    private String jobId;

    public String parse() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "&"
                + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String parse(String expression) throws Exception {

        checkForException(expression);

        if (expression.contains(USER_NAME)) {
            expression = expression.replace(USER_NAME, userName);
        }
        if (expression.contains(USER_ID)) {
            expression = expression.replace(USER_ID, userId);
        }

        if (expression.contains(CURRENT_DATE) && currentDate == null) {
            expression = expression.replace(CURRENT_DATE, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        } else if (expression.contains(CURRENT_DATE)) {
            expression = expression.replace(CURRENT_DATE, currentDate);

        }

        if (expression.contains(CURRENT_TIME) && currentTime == null) {
            expression = expression.replace(CURRENT_TIME, LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));

        } else if (expression.contains(CURRENT_TIME)) {
            expression = expression.replace(CURRENT_TIME, currentTime);
        }

        if (expression.contains(JOB_ID)) {
            expression = expression.replace(JOB_ID, jobId);
        }

        return expression;
    }


    public String checkForException(String expression) throws Exception {
        String patternString = "[^\\w^&\"-]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.lookingAt()) {
            if (expression.contains(CURRENT_TIME) || expression.contains(CURRENT_DATE) || expression.contains(USER_ID)
                    || expression.contains(USER_NAME) || expression.contains(JOB_ID)) {
                return expression;
            } else {
                throw new NoSuchProperty("Property not Found.");
            }

        }
        return expression;
    }

    public List<String> getAllRules(){
        List<String> rules = Arrays.asList(USER_ID,USER_NAME,CURRENT_DATE,CURRENT_TIME,JOB_ID);
        return rules;
    }
}
