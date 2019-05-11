package com.intraway.fizzbuzz.entities;

import java.io.Serializable;

public class FizzBuzzObject implements Serializable {

    private String timestamp;

    public FizzBuzzObject() {
    }

    public FizzBuzzObject(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
