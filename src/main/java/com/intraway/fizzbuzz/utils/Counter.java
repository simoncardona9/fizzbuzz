package com.intraway.fizzbuzz.utils;

public class Counter {

    private Integer counter;

    public Counter(int counter) {
        this.counter = counter;
    }

    public Integer getCounter() {
        return counter;
    }

    public synchronized void incrementCounter() {
        this.counter = this.counter+1;
    }
}
