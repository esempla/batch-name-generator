package com.gihub.esempla.model;

public enum EnumRoles {
    UserID("$UserID"),
    $UserName("$UserName"),
    $CurrentDate("$CurrentDate"),
    $CurrentTime("$CurrentTime"),
    $JobID("$JobID");

    private String name;

    EnumRoles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
