package com.intraway.fizzbuzz.utils;

import java.time.Instant;

public class FBUtils {

    public static String getTimeStamp () {
        Instant currTimeStamp = Instant.now();
        return Long.toString(currTimeStamp.toEpochMilli());
    }

}
