package com.gihub.esempla.batch;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Builder
public class BatchNameGenerator {

    private String userId;
    private String userName;
    private String currentDate;
    private String currentTime;
    private String jobId;

    private static boolean stringContainsRole(String expression, List<String> rules) {
        final boolean result = rules.stream().anyMatch(expression::contains);
        if (!result) {
            throw new NoSuchPropertyExceptiopn("Property not Found.");
        } else
            return true;
    }

    public static List<String> getAllRules() {
        return Stream.of(Rule.values())
                .map(Rule::getName)
                .collect(Collectors.toList());
    }

    public String parseInput(String expression) {
        stringContainsRole(expression, getAllRules());

        if (expression.contains(Rule.USER_NAME.getName())) {
            expression = expression.replace(Rule.USER_NAME.getName(), userName);
        }
        if (expression.contains(Rule.USER_ID.getName())) {
            expression = expression.replace(Rule.USER_ID.getName(), userId);
        }

        if (expression.contains(Rule.CURRENT_DATE.getName()) && currentDate == null) {
            expression = expression.replace(Rule.CURRENT_DATE.getName(), LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        } else if (expression.contains(Rule.CURRENT_DATE.getName())) {
            expression = expression.replace(Rule.CURRENT_DATE.getName(), currentDate);

        }

        if (expression.contains(Rule.CURRENT_TIME.getName()) && currentTime == null) {
            expression = expression.replace(Rule.CURRENT_TIME.getName(), LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm")));

        } else if (expression.contains(Rule.CURRENT_TIME.getName())) {
            expression = expression.replace(Rule.CURRENT_TIME.getName(), currentTime);
        }

        if (expression.contains(Rule.JOB_ID.getName())) {
            expression = expression.replace(Rule.JOB_ID.getName(), jobId);
        }

        return expression;
    }


    public String parseInput() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "&"
                + LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm"));
    }
}
