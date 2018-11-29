package com.gihub.esempla.batch;

public enum Rule {
    USER_ID("$UserID"),
    USER_NAME("$UserName"),
    CURRENT_DATE("$CurrentDate"),
    CURRENT_TIME("$CurrentTime"),
    JOB_ID("$JobID");

    private String name;

    Rule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
