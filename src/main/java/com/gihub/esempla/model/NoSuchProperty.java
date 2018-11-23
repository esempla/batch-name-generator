package com.gihub.esempla.model;

public class NoSuchProperty extends RuntimeException {
    public NoSuchProperty(String message) {
        super(message);
    }
}